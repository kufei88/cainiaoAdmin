package com.xcxgf.cainiao.services;


import com.xcxgf.cainiao.POJO.Hydropower;
import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;
    //新增
    public void insert(HttpServletRequest request){
        String water = request.getParameter("waterNumber");
        String electricity = request.getParameter("electricityNumber");
        String enterpriseNumber = request.getParameter("enterpriseNumber");
        System.out.println("insert");
        System.out.println(paymentMapper.insertPaymentInfo(water,electricity,enterpriseNumber));
    }
    //更新
    public void update(HttpServletRequest request){
        String id = request.getParameter("id");
        String water = request.getParameter("waterNumber");
        String electricity = request.getParameter("electricityNumber");
        String enterpriseNumber = request.getParameter("enterpriseNumber");
        System.out.println("update");
        System.out.println(paymentMapper.updatePaymentInfo(Integer.parseInt(id),water,electricity,enterpriseNumber));
    }
    //删除
    public void delete(HttpServletRequest request){
        System.out.println("delete");
        String id = request.getParameter("id");
        System.out.println(paymentMapper.deletePaymentInfo(Integer.parseInt(id)));
    }
    //删除全部
    public void deleteAll(){
        System.out.println("deleteAll");
        System.out.println(paymentMapper.deletePaymentInfoAll());
    }

    public void insertAll(){

    }
    //得到数据
    public List<PaymentInfo> getPaymentList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        return paymentMapper.getPaymentList(df.format(new Date()));
    }
    //得到上期数据
    public List<PaymentInfo> getPreviousPaymentList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        SimpleDateFormat mm = new SimpleDateFormat("MM");//设置月份格式
        int month = Integer.parseInt(mm.format(new Date()))-1;  //计算上月
        StringBuffer monthT = new StringBuffer(String.valueOf(month));
        StringBuffer years = new StringBuffer(df.format(new Date()));
        if (month<10){
            monthT.insert(0,"0");
        }
        years.replace(5, 8, monthT.toString());
//        System.out.println("时间："+years +"---"+monthT);// new Date()为获取当前系统时间
        return paymentMapper.getPaymentList(years.toString());
    }

    //得到水电价格数据
    public List<Hydropower> getHydropowerPaymentList(){
        return paymentMapper.getHydropowerPaymentList();
    }

    //更新水电价格数据
    public void updateHydropower(HttpServletRequest request){
        String water = request.getParameter("water");
        String electricity = request.getParameter("electricity");
        System.out.println("updateHydropower");
        System.out.println(paymentMapper.updateHydropowerPaymentInfo(Float.parseFloat(water),Float.parseFloat(electricity)));
    }

    //得到水电费数据
    public List<PaymentInfo> getHydropowerCost(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getPaymentList(df.format(new Date()));
    }

    //得到所有年份数据
    public List<Long> getYearsList(){
        return paymentMapper.getYearsList();
    }

    //得到年份水费数据
    public List<Long> getYearsWaterCostList(){
        return paymentMapper.getYearsWaterCostList();
    }

    //得到年份电费数据
    public List<Long> getYearsElectricityCostList(){
        return paymentMapper.getYearsElectricityCostList();
    }

    //得到本年月份
    public List<Long> getMonthList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getMonthList(df.format(new Date()));
    }

    //得到本年月份水费数据
    public List<Long> getMonthWaterCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getMonthWaterCostList(df.format(new Date()));
    }

    //得到本年月份电费数据
    public List<Long> getMonthElectricityCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getMonthElectricityCostList(df.format(new Date()));
    }

    //得到本年季度
    public List<Long> getQuarterList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getQuarterList(df.format(new Date()));
    }


    //得到本年季度月份水费数据
    public List<Long> getQuarterWaterCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getQuarterWaterCostList(df.format(new Date()));
    }

    //得到本年季度月份电费数据
    public List<Long> getQuarterElectricityCostList(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        return paymentMapper.getQuarterElectricityCostList(df.format(new Date()));
    }
}
