package com.xcxgf.cainiao.services;



import com.xcxgf.cainiao.POJO.Hydropower;
import com.xcxgf.cainiao.POJO.HydropowerCost;
import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.POJO.ReturnData;
import com.xcxgf.cainiao.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    //新增
    public int insert(PaymentInfo paymentInfo){
        int flag = 0,flagTwo = 0;
        HydropowerCost hc =  new HydropowerCost();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        StringBuffer startTime = paymentInfo.getStartTime();
        StringBuffer endTime = paymentInfo.getEndTime();
        String start;
        String end;
        if(paymentInfo.getStartTime().length()==11 && paymentInfo.getEndTime().length()==11){
            start = startTime.delete(10,30).toString();
            end = endTime.delete(10,30).toString();
        }else {
             start =  df.format(new Date(String.valueOf(startTime)));
             end = df.format(new Date(String.valueOf(endTime)));
        }
        flag = paymentMapper.insertPaymentInfo(paymentInfo.getWaterNumber(),paymentInfo.getElectricityNumber(),paymentInfo.getEnterpriseNumber(),paymentInfo.getRoomNumber(),start,end,df.format(new Date()));
        if (flag == 1){
          hc = paymentMapper.selectPaymentInfoId(paymentInfo.getEnterpriseNumber(),paymentInfo.getRoomNumber(),start,end);
          flagTwo = paymentMapper.insertCost(hc.getId());
          if (flagTwo==0){
              paymentMapper.deletePaymentInfo(hc.getId());
          }
        }
        return flagTwo;
    }
    //更新
    public int update(PaymentInfo paymentInfo){
        int flag = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        flag = paymentMapper.updatePaymentInfo(paymentInfo.getId(),paymentInfo.getWaterNumber(),paymentInfo.getElectricityNumber(),df.format(new Date()));
        if (flag == 1){
            paymentMapper.insertCost(paymentInfo.getId());
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

    public void insertAll(){

    }
    //得到数据
    public ReturnData getPaymentList(String limit){
        ReturnData dataReturn = new ReturnData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        dataReturn.setDataCount(paymentMapper.getCount(df.format(new Date())));
        dataReturn.setPaymentInfos(paymentMapper.getPaymentList(df.format(new Date()),limit));
        return dataReturn;
    }
    //得到上期数据
    public ReturnData getPreviousPaymentList(String limit){
        ReturnData dataReturn = new ReturnData();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        SimpleDateFormat mm = new SimpleDateFormat("MM");//设置月份格式
        int month = Integer.parseInt(mm.format(new Date()))-1;  //计算上月
        StringBuffer monthT = new StringBuffer(String.valueOf(month));
        StringBuffer years = new StringBuffer(df.format(new Date()));
        if (month<10){
            monthT.insert(0,"0");
        }
        years.replace(5, 8, monthT.toString());
        dataReturn.setDataCount(paymentMapper.getCount(years.toString()));
        dataReturn.setPaymentInfos(paymentMapper.getPaymentList(years.toString(),limit));
        return dataReturn;
    }

    //得到水电价格数据
    public List<Hydropower> getHydropowerPaymentList(){
        return paymentMapper.getHydropowerPaymentList();
    }

    //更新水电价格数据
    public int updateHydropower(Hydropower hydropower){
        return paymentMapper.updateHydropowerPaymentInfo(hydropower.getWater(),hydropower.getElectricity());
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
