package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;
    public List<Account> getAccountList(){return accountMapper.getAccountList();}

    public List<Account> getAccountNameList(HttpServletRequest request){
        String name=request.getParameter("name");
        return accountMapper.getAccountNameList(name);
    }
    //数据更新
    public int updateAccount(HttpServletRequest request){
        Account entityAccount=new Account();
        entityAccount.setId(Integer.parseInt(request.getParameter("id")));
        entityAccount.setCompanyName(request.getParameter("companyName"));
        entityAccount.setContact(request.getParameter("contact"));
        entityAccount.setContactNumber(request.getParameter("contactNumber"));
        entityAccount.setDormitoryNum(request.getParameter("dormitoryNum"));
        entityAccount.setContractSigning(request.getParameter("contractSigning"));
        entityAccount.setLeasePeriod(request.getParameter("leasePeriod"));
        entityAccount.setRemark(request.getParameter("remark"));
        return accountMapper.updateAccount(entityAccount);
    }

    //数据插入
    public int insertAccount(HttpServletRequest request){
        Account entityAccount=new Account();
        entityAccount.setCompanyName(request.getParameter("companyName"));
        entityAccount.setContact(request.getParameter("contact"));
        entityAccount.setContactNumber(request.getParameter("contactNumber"));
        entityAccount.setDormitoryNum(request.getParameter("dormitoryNum"));
        entityAccount.setContractSigning(request.getParameter("contractSigning"));
        entityAccount.setLeasePeriod(request.getParameter("leasePeriod"));
        entityAccount.setRemark(request.getParameter("remark"));
        return accountMapper.insertAccount(entityAccount);
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
        entityAccount.setDormitoryNum(request.getParameter("租赁场地门牌号"));
        entityAccount.setContractSigning(request.getParameter("租赁合同签署情况"));
        entityAccount.setLeasePeriod(request.getParameter("租期"));
        entityAccount.setRemark(request.getParameter("备注"));
        return accountMapper.insertAccount(entityAccount);
    }

}
