package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping(method = RequestMethod.GET,value="/getAccountList")
    public List<Account> getAccountList(){return accountService.getAccountList();}

    @RequestMapping(method = RequestMethod.POST,value="/updateAccount")
    public int updateAccount(HttpServletRequest request){ return accountService.updateAccount(request);}

    @RequestMapping(method = RequestMethod.POST,value="/insertAccount")
    public int insertAccount(HttpServletRequest request){return accountService.insertAccount(request);}

    @RequestMapping(method = RequestMethod.POST,value="/deleteAccount")
    public int deleteAccount(HttpServletRequest request){ return accountService.deleteAccount(request);}

    @RequestMapping(method = RequestMethod.POST,value="/upload")
    public void upload(HttpServletRequest request){

    }
}
