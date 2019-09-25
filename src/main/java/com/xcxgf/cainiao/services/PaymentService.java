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

    //批量导入excel
    public void batInfoAdd(List<PaymentInfo> paymentInfo){
        float WaterUnitPrice = 1,ElectricityUnitPrice = 1;//单价
        List<PaymentInfo> list =new ArrayList<>();
        for(SystemInfo si: paymentMapper.getSystemInfoList()){//得到单价
            WaterUnitPrice= si.getWaterUnitPrice();
            ElectricityUnitPrice = si.getElectricityUnitPrice();
        }
        for (PaymentInfo pi : paymentInfo){
            pi.setWaterCost(Math.abs(pi.getWaterNumber()*WaterUnitPrice));
            pi.setElectricityCost(Math.abs(pi.getElectricityNumber()*ElectricityUnitPrice));
            pi.setWaterNumberPrevious(pi.getWaterNumber());
            pi.setWaterDifference(pi.getWaterNumber());
            pi.setElectricityNumberPrevious(pi.getElectricityNumber());
            pi.setElectricityDifference(pi.getElectricityNumber());
            pi.setTotal(pi.getWaterCost()+pi.getElectricityCost());
            list.add(pi);
        }
        paymentMapper.batInfoAdd(list);
    }

    public SystemInfo getSystemInfo(){
        List<SystemInfo> systemInfoList = paymentMapper.getSystemInfoList(); //获取系统设置中的水电单价
        SystemInfo systemInfo = new SystemInfo();
        for(SystemInfo si: systemInfoList){//得到单价
            systemInfo.setWaterUnitPrice(si.getWaterUnitPrice());
            systemInfo.setElectricityUnitPrice(si.getElectricityUnitPrice());
        }
        return systemInfo;
    }

    //新增表数据的判断逻辑
    public int timeSetting(PaymentInfo paymentInfo,String startTime,String endTime,float WaterUnitPrice,float ElectricityUnitPrice){
        int flagTwo = 0;//状态
        int id;
        paymentInfo.setStartTime(startTime);//设置开始时间
        paymentInfo.setEndTime(endTime);//设置结束时间
        float WaterCost = 0,ElectricityCost = 0;//费用
        PaymentInfo pi;

        String flag = paymentMapper.repeatData(paymentInfo);
        if ( flag == null) {//不存在的数据执行插入
            try {
                //计算
                WaterCost = paymentInfo.getWaterNumber() * WaterUnitPrice;
                ElectricityCost = paymentInfo.getElectricityNumber() * ElectricityUnitPrice;
                //存入实体类
                paymentInfo.setWaterCost(WaterCost);
                paymentInfo.setWaterNumberPrevious(paymentInfo.getWaterNumber());
                paymentInfo.setWaterDifference(paymentInfo.getWaterNumber());
                paymentInfo.setElectricityCost(ElectricityCost);
                paymentInfo.setElectricityNumberPrevious(paymentInfo.getElectricityNumber());
                paymentInfo.setElectricityDifference(paymentInfo.getElectricityNumber());
                paymentInfo.setTotal(WaterCost+ElectricityCost);
                //执行mysql插入语句
                paymentMapper.insertPaymentInfo(paymentInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            flagTwo=1;
        }
        else if(flag.equals("1")){//存在执行更新
            id = paymentMapper.selectPaymentInfoId(paymentInfo);//获取到id
            PaymentInfo info = paymentMapper.selectPaymentInfo(id);//查出水电读数
            if(info.getWaterNumber()<paymentInfo.getWaterNumber() && info.getElectricityNumber()<paymentInfo.getElectricityNumber()){//判断导入数据是否大于原数据
                pi = paymentInfo;//数据暂存
                pi.setId(id);//设置id
                //将查出来的水电读数设置为上期水电数据
                pi.setWaterNumberPrevious(info.getWaterNumber());
                pi.setElectricityNumberPrevious(info.getElectricityNumber());
                //设置差值
                pi.setWaterDifference(Math.abs(paymentInfo.getWaterNumber()-pi.getWaterNumberPrevious()));
                pi.setElectricityDifference(Math.abs(paymentInfo.getElectricityNumber()-pi.getElectricityNumberPrevious()));
                //设置单个金额
                pi.setWaterCost(pi.getWaterDifference() * WaterUnitPrice);
                pi.setElectricityCost(pi.getElectricityDifference() * ElectricityUnitPrice);
                //设置总金额
                pi.setTotal(pi.getWaterCost()+pi.getElectricityCost());
                //更新
                paymentMapper.updataPaymentInfo(pi);
                flagTwo=1;
            }else {
                flagTwo = 0;
            }
        }
        return flagTwo;
    }

    //新增系统设置单价
    public int insertSystemInfo(SystemInfo systemInfo){
        return paymentMapper.insertSystemInfo(systemInfo);
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        return paymentMapper.getPaymentinfoRoomList(building,df.format(new Date()));
    }

    //查询去重的房号
    public List<Long> getRoomList(String building){
        List list1 =getBuildingRoomList(building);
        List list2 =getPaymentinfoRoomList(building);
        return PaymentUtil.removeAll(list1,list2);
    }

    //新增表数据
    public int insert(PaymentInfo paymentInfo,float WaterUnitPrice,float ElectricityUnitPrice){
        int flagTwo = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String start = paymentInfo.getStartTime();
        String end = paymentInfo.getEndTime();
        String startTime = null;
        String endTime = null;

        try {
            if (start.length()>=10 && end.length()>=10){
                startTime=PaymentUtil.subDay(df.format(df.parse(start)));
                endTime=PaymentUtil.subDay(df.format(df.parse(end)));
                flagTwo = timeSetting(paymentInfo,startTime,endTime,WaterUnitPrice,ElectricityUnitPrice);
            }
            if (start.length()<10 && end.length()<10){
                startTime=PaymentUtil.formatDate(start);
                endTime=PaymentUtil.formatDate(end);
                flagTwo = timeSetting(paymentInfo,startTime,endTime,WaterUnitPrice,ElectricityUnitPrice);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flagTwo;
    }

    //得到表数据
    public ReturnData getPaymentList(String limit){
        ReturnData dataReturn = new ReturnData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        try {
            dataReturn.setDataCount(paymentMapper.getCount());
            dataReturn.setPaymentInfos(paymentMapper.getPaymentList(limit));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataReturn;
    }

    //系统设置中是否有数据
    public int systemInfoIsNull(){return paymentMapper.systemInfoIsNull();}

    //得到系统单价数据
    public List<SystemInfo> getSystemInfoList(){
        return paymentMapper.getSystemInfoList();
    }

    //更新系统单价数据
    public int updateSystemInfo(SystemInfo systemInfo){
        return paymentMapper.updateSystemInfo(systemInfo);
    }

    //得到所有年份
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

    //判断表是否为空
    public int tableIsNull(){
        return  paymentMapper.tableIsNull();
    }
}
//工具类
class PaymentUtil{
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

    //时间天数加一天处理
    public static String subDay(String date) throws ParseException {
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
    public static String subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, -1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    //list集合去重 返回的是list1
    public static List<String> removeAll(List<String> list1,List<String> list2){
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

}

