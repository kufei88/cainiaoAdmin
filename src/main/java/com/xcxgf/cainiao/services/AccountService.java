package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;
    //数据查询
    public List<Account> getAccountList0(){ return accountMapper.getAccountList0();}

    public List<Account> getAccountList(HttpServletRequest request)
    {
        int start=(Integer.parseInt(request.getParameter("startnum"))-1)*10;
        //System.out.println(start);
        return accountMapper.getAccountList(start);
    }

    public List<Account> getAccountNameList(HttpServletRequest request){
        String name=request.getParameter("name");
        return accountMapper.getAccountNameList(name);
    }

    public List<Account> getAccountIdList(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("nid"));
        return accountMapper.getAccountIdList(id);
    }

    public int getAccountCount(){return accountMapper.getAccountCount();}
    //数据更新

    public int updateAccount(Account account) {


        return accountMapper.updateAccount(account);
    }

    //数据插入
    public int insertAccount(Account account) throws ParseException {
        funhelper funh=new funhelper();
        account.setEndDate(funh.addMounth(account.getStartDate(),Integer.parseInt(account.getLeasePeriod())));
        return accountMapper.insertAccount(account);
    }

    //数据删除
    public int deleteAccount(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        return accountMapper.deleteAccount(id);
    }

    //上传数据
    public int uploadAccount(HttpServletRequest request){
        Account entityAccount=new Account();
        entityAccount.setCompanyName(request.getParameter("公司名称"));
        entityAccount.setContact(request.getParameter("联系人"));
        entityAccount.setContactNumber(request.getParameter("联系电话"));
        entityAccount.setDormitoryNum(request.getParameter("宿舍楼号"));
        entityAccount.setContractSigning(request.getParameter("租赁合同签署日期"));
        entityAccount.setStartDate(request.getParameter("起始日期"));
        entityAccount.setEndDate(request.getParameter("结束日期"));
        entityAccount.setLeasePeriod(request.getParameter("租期"));
        entityAccount.setRemark(request.getParameter("租金"));
        return accountMapper.insertAccount(entityAccount);
    }


}
