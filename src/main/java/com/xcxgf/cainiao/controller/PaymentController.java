package com.xcxgf.cainiao.controller;


import com.xcxgf.cainiao.POJO.Hydropower;
import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.POJO.ReturnData;
import com.xcxgf.cainiao.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import java.util.List;


@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService ps;
    //更新
    @PostMapping("/updatePaymentData")
    public int update(@RequestBody PaymentInfo paymentInfo) {
       return ps.update(paymentInfo);
    }
    //增加
    @PostMapping("/insertPaymentData")
    public int insert(@RequestBody PaymentInfo paymentInfo) {return ps.insert(paymentInfo); }
    //删除
    @PostMapping("/deletePaymentData")
    public int delete(@RequestBody PaymentInfo paymentInfo) {
       return ps.delete(paymentInfo);
    }
    //删除all
    @PostMapping("/deletePaymentDataAll")
    public void deleteAll() {
        ps.deleteAll();
    }

    //查询上期
    @GetMapping("/getPreviousPaymentList")
    public ReturnData getPreviousPaymentList(HttpServletRequest request){
        // 从request中获取各参数
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String limit = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;
        return ps.getPreviousPaymentList(limit);
    }

    //查询水电价格
    @GetMapping("/getHydropowerPaymentList")
    public List<Hydropower> getHydropowerPaymentList(){
        return ps.getHydropowerPaymentList();
    }

    //更新水电费
    @PostMapping("/updateHydropowerPaymentData")
    public int updateHydropower(@RequestBody Hydropower hydropower) {
        return ps.updateHydropower(hydropower);
    }

    //查询所有年份
    @GetMapping("/getYearsList")
    public List<Long> getYearsList(){
        return ps.getYearsList();
    }

    //查询年份水费
    @GetMapping("/getYearsWaterCostList")
    public List<Float> getYearsWaterCostList(){
        return ps.getYearsWaterCostList();
    }

    //查询年份电费
    @GetMapping("/getYearsElectricityCostList")
    public List<Float> getYearsElectricityCostList(){
        return ps.getYearsElectricityCostList();
    }

    //查询本年月份
    @GetMapping("/getMonthList")
    public List<Long> getMonthList(){
        return ps.getMonthList();
    }


    //查询本年月份水费
    @GetMapping("/getMonthWaterCostList")
    public List<Float> getMonthWaterCostList(){

        return ps.getMonthWaterCostList();
    }

    //查询本年月份电费
    @GetMapping("/getMonthElectricityCostList")
    public List<Float> getMonthElectricityCostList(){

        return ps.getMonthElectricityCostList();
    }

    //查询本年季度
    @GetMapping("/getQuarterList")
    public List<Long> getQuarterList(){
        return ps.getQuarterList();
    }

    //查询本年季度水费
    @GetMapping("/getQuarterWaterCostList")
    public List<Float> getQuarterWaterCostList(){
        return ps.getMonthWaterCostList();
    }

    //查询本年季度电费
    @GetMapping("/getQuarterElectricityCostList")
    public List<Float> getQuarterElectricityCostList(){
        return ps.getQuarterElectricityCostList();
    }

    /**
     * 获取符合查询条件的办公室数据
     * @param request request中包含3个参数，dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @GetMapping("/getPaymentList")
    public ReturnData getSearchList(HttpServletRequest request) {
        // 从request中获取各参数
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String limit = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return ps.getPaymentList(limit);
    }
}
