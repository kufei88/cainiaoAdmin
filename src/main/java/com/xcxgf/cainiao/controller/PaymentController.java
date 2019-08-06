package com.xcxgf.cainiao.controller;


import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService ps;

    @PostMapping("/setPaymentData")
    public void put(HttpServletRequest request) {
        ps.put(request);
    }
    @PostMapping("/deletePaymentData")
    public void delete(HttpServletRequest request) {
        ps.delete(request);
    }

    @GetMapping("/getPaymentList")
    public List<PaymentInfo> getPaymentList(){
        return ps.getPaymentList();
    }

}
