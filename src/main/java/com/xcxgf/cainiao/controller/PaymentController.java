package com.xcxgf.cainiao.controller;


import com.xcxgf.cainiao.POJO.Hydropower;
import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService ps;
    //更新
    @PostMapping("/updatePaymentData")
    public void update(HttpServletRequest request) {
        ps.update(request);
    }
    //增加
    @PostMapping("/insertPaymentData")
    public void insert(HttpServletRequest request) { ps.insert(request); }
    //删除
    @PostMapping("/deletePaymentData")
    public void delete(HttpServletRequest request) {
        ps.delete(request);
    }
    //删除所有数据
    @PostMapping("/deletePaymentDataAll")
    public List<PaymentInfo> deleteAll() {
        ps.deleteAll();
        return ps.getPaymentList();
    }
    //查询
    @GetMapping("/getPaymentList")
    public List<PaymentInfo> getPaymentList(){
        return ps.getPaymentList();
    }

    //查询上期
    @GetMapping("/getPreviousPaymentList")
    public List<PaymentInfo> getPreviousPaymentList(){
        return ps.getPreviousPaymentList();
    }

    //查询水电价格
    @GetMapping("/getHydropowerPaymentList")
    public List<Hydropower> getHydropowerPaymentList(){
        return ps.getHydropowerPaymentList();
    }
    //更新水电费
    @PostMapping("/updateHydropowerPaymentData")
    public void updateHydropower(HttpServletRequest request) {
        ps.updateHydropower(request);
    }

    //查询所有年份
    @GetMapping("/getYearsList")
    public List<Long> getYearsList(){
        return ps.getYearsList();
    }

    //查询年份水费
    @GetMapping("/getYearsWaterCostList")
    public List<Long> getYearsWaterCostList(){
//        System.out.println("年水"+ps.getYearsWaterCostList());

        return ps.getYearsWaterCostList();
    }

    //查询年份电费
    @GetMapping("/getYearsElectricityCostList")
    public List<Long> getYearsElectricityCostList(){
//        System.out.println("年电"+ps.getYearsElectricityCostList());
        return ps.getYearsElectricityCostList();
    }

    //查询本年月份
    @GetMapping("/getMonthList")
    public List<Long> getMonthList(){
//        System.out.println(ps.getMonthList());
        return ps.getMonthList();
    }


    //查询本年月份水费
    @GetMapping("/getMonthWaterCostList")
    public List<Long> getMonthWaterCostList(){
//        System.out.println("月水"+ps.getMonthWaterCostList());
        return ps.getMonthWaterCostList();
    }

    //查询本年月份电费
    @GetMapping("/getMonthElectricityCostList")
    public List<Long> getMonthElectricityCostList(){
//        System.out.println("月电"+ps.getMonthElectricityCostList());
        return ps.getMonthElectricityCostList();
    }

    //查询本年季度
    @GetMapping("/getQuarterList")
    public List<Long> getQuarterList(){
        return ps.getQuarterList();
    }

    //查询本年季度水费
    @GetMapping("/getQuarterWaterCostList")
    public List<Long> getQuarterWaterCostList(){
//        System.out.println("月水"+ps.getMonthWaterCostList());
        return ps.getMonthWaterCostList();
    }

    //查询本年季度电费
    @GetMapping("/getQuarterElectricityCostList")
    public List<Long> getQuarterElectricityCostList(){
//        System.out.println("月电"+ps.getQuarterElectricityCostList());
        return ps.getQuarterElectricityCostList();
    }
}
