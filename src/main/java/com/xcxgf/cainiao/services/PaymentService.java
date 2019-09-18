package com.xcxgf.cainiao.services;



import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.POJO.ReturnData;
import com.xcxgf.cainiao.POJO.SystemInfo;
import com.xcxgf.cainiao.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    //新增
    public int insertHydropowerPaymentData(SystemInfo systemInfo){
        return paymentMapper.insertHydropowerPaymentData(systemInfo);
    }

    //查询公司
    public String getEnterpriseNumber(String building,String room){
        return paymentMapper.getEnterpriseNumber(building,room);
    }

    //查询所有楼栋
    public List<String> getBuilingList(){
        return paymentMapper.getBuildingList();
    }

    //查询所属楼栋的未使用的房号
    public List<Long> getBuildingRoomList(String building){
        return paymentMapper.getBuildingRoomList(building);
    }

    //查询水电表已存在的房号
    public List<Long> getPaymentinfoRoomList(String building){
        return paymentMapper.getPaymentinfoRoomList(building);
    }

    //查询去重的房号
    public List<Long> getRoomList(String building){
        List list1 =getBuildingRoomList(building);
        List list2 =getPaymentinfoRoomList(building);
        return removeAll(list1,list2);
    }

    //去重
    public  static List<String> removeAll(List<String> list1,List<String> list2){
        LinkedList<String> result = new LinkedList<>(list1);
        HashSet<String> set = new HashSet<>(list2);
        Iterator<String> itor = result.iterator();
        while(itor.hasNext()){
            if(set.contains(itor.next())){
                itor.remove();
            }
        }
        return result;
    }

    //新增
    public int insert(PaymentInfo paymentInfo){
        int flagTwo = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String start = paymentInfo.getStartTime();
        String end = paymentInfo.getEndTime();
        String startTime = null;
        String endTime = null;
        try {
            if (start.length()>=10 && end.length()>=10){
                startTime=subDay(df.format(df.parse(start)));
                endTime=subDay(df.format(df.parse(end)));
                flagTwo = timeSetting(paymentInfo,startTime,endTime);
//                System.out.println(startTime);
            }
            if (start.length()<10 && end.length()<10){
                startTime=formatDate(start);
                endTime=formatDate(end);
                flagTwo = timeSetting(paymentInfo,startTime,endTime);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flagTwo;
    }

    //时间天数加一天处理
    public String subDay(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.DAY_OF_MONTH, 1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    //时间月份减一个月
    public String subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, -1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    //新增判断
    public int timeSetting(PaymentInfo paymentInfo,String startTime,String endTime){
        int flag = 0,flagTwo = 0;
        PaymentInfo hc ;
        paymentInfo.setStartTime(startTime);
        paymentInfo.setEndTime(endTime);
        if (paymentMapper.repeatData(paymentInfo) != 1) {
            flag =paymentMapper.insertPaymentInfo(paymentInfo);
            if (flag == 1){
                hc = paymentMapper.selectPaymentInfoId(paymentInfo);
                flagTwo = paymentMapper.insertCost(hc);
                if(flagTwo!=1){
                    paymentMapper.deletePaymentInfo(hc.getId());
                }
            }
        }else {
            flagTwo=2;
        }
        return flagTwo;
    }

    //时间类型转换
    public static String formatDate(String inDate) {
        SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yy");
        SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
        String outDate = "";
        if (inDate != null) {
            try {
                Date date = inSDF.parse(inDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex){
            }
        }
        return outDate;
    }
    //更新
    public int update(PaymentInfo paymentInfo){
        int flag = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        paymentInfo.setUpdateTime(df.format(new Date()));
        flag = paymentMapper.updatePaymentInfo(paymentInfo);
        if (flag == 1){
            paymentMapper.insertCost(paymentInfo);
        }
       return flag;
    }
    //删除
    public int delete(PaymentInfo paymentInfo){
//        System.out.println("delete");
        return paymentMapper.deletePaymentInfo(paymentInfo.getId());
    }
    //删除全部
    public void deleteAll(){
        System.out.println(paymentMapper.deletePaymentInfoAll());
    }

    //得到本期数据
    public ReturnData getPaymentList(String limit){
        ReturnData dataReturn = new ReturnData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        try {
            dataReturn.setDataCount(paymentMapper.getCount(subMonth(df.format(new Date()))));
            dataReturn.setPaymentInfos(paymentMapper.getPaymentList(subMonth(df.format(new Date())),limit));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dataReturn;
    }
    //得到上期数据
    public ReturnData getPreviousPaymentList(String limit){
        ReturnData dataReturn = new ReturnData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        String years = null;
        try {
            years = subMonth(subMonth(df.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataReturn.setDataCount(paymentMapper.getCount(years));
        dataReturn.setPaymentInfos(paymentMapper.getPaymentList(years,limit));
        return dataReturn;
    }

    //得到水电价格数据
    public List<SystemInfo> getHydropowerPaymentList(){
        return paymentMapper.getHydropowerPaymentList();
    }

    //更新水电价格数据
    public int updateHydropower(SystemInfo systemInfo){
        return paymentMapper.updateHydropowerPaymentInfo(systemInfo);
    }

    //得到水电费数据
    public List<PaymentInfo> getHydropowerCost(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getHydropowerCost(df.format(new Date()));
    }

    //得到所有年份数据
    public List<Long> getYearsList(){
        return paymentMapper.getYearsList();
    }

    //得到年份水费数据
    public List<Float> getYearsWaterCostList(){
        return paymentMapper.getYearsWaterCostList();
    }

    //得到年份电费数据
    public List<Float> getYearsElectricityCostList(){
        return paymentMapper.getYearsElectricityCostList();
    }

    //得到本年月份
    public List<Long> getMonthList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getMonthList(df.format(new Date()));
    }

    //得到本年月份水费数据
    public List<Float> getMonthWaterCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getMonthWaterCostList(df.format(new Date()));
    }

    //得到本年月份电费数据
    public List<Float> getMonthElectricityCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getMonthElectricityCostList(df.format(new Date()));
    }

    //得到本年季度
    public List<Long> getQuarterList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getQuarterList(df.format(new Date()));
    }

    //得到本年季度月份水费数据
    public List<Float> getQuarterWaterCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getQuarterWaterCostList(df.format(new Date()));
    }

    //得到本年季度月份电费数据
    public List<Float> getQuarterElectricityCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getQuarterElectricityCostList(df.format(new Date()));
    }

}
