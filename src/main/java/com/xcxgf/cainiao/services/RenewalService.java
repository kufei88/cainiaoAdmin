package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Renewal;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.mapper.RenewalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Service
public class RenewalService {
    @Autowired
    RenewalMapper renewalMapper;

    @Autowired
    AccountMapper accountMapper;
    public List<Renewal> getRenewalList(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("nid"));
        return renewalMapper.getRenewalList(id);}


    public int getCount(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("nid"));
        //System.out.println(id);
        return renewalMapper.getCount(id);
    }

    public int insertRenewals(Renewal renewal) throws ParseException {
        //System.out.printf(renewal.getLeasePeriod());
        funhelper funh=new funhelper();
        int addNum=renewal.getContinuePeriod();
        int id=renewal.getContractId();
        renewal.setContinueEndTime(funh.addMounth(renewal.getContinueStartTime(),
                renewal.getContinuePeriod()));
        accountMapper.updateleasePeriod(addNum,id);
        return renewalMapper.insertRenewals(renewal);
    }
}
