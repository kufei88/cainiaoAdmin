package com.xcxgf.cainiao.services;


import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public void put(HttpServletRequest request){
        String id = request.getParameter("id");
        String water = request.getParameter("waterNumber");
        String electricity = request.getParameter("electricityNumber");
        if (id!=null){
            System.out.println("update");
            update(id,water,electricity);
        }else{
            System.out.println("insert");
            insert(water,electricity);
        }
    }

    public void delete(HttpServletRequest request){
        String id = request.getParameter("id");
        paymentMapper.deletePaymentInfo(Integer.parseInt(id));
    }

    public void update(String id,String water,String electricity){
        System.out.println(paymentMapper.updatePaymentInfo(Integer.parseInt(id),water,electricity));
    }

    public void insert(String water,String electricity){
        System.out.println(paymentMapper.insertPaymentInfo(water,electricity));
    }
    public List<PaymentInfo> getPaymentList(){
        return paymentMapper.getPaymentList();
    }

}
