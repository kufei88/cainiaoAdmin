package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Dorms;
import com.xcxgf.cainiao.POJO.ExcelData;
import com.xcxgf.cainiao.POJO.SelectDatas;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.services.AccountService;
import com.xcxgf.cainiao.services.DormService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("Account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    DormService dormService;

    @RequestMapping(method = RequestMethod.GET,value="/getAccountList")
    public List<Account> getAccountList(HttpServletRequest request) {return accountService.getAccountList(request);}

    @RequestMapping(method = RequestMethod.GET,value="/getAccountList0")
    public List<Account> getAccountList0() {return accountService.getAccountList0();}

    @RequestMapping(method = RequestMethod.GET,value="/getIdList")
    public List<Account> getAccountIdList(HttpServletRequest request){
        return accountService.getAccountIdList(request);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getAccountCount")
    public int getAccountCount(){return accountService.getAccountCount();}

    @RequestMapping(method = RequestMethod.POST,value="/updateAccount")
    public int updateAccount(@RequestBody Account account) throws ParseException
    { return accountService.updateAccount(account);}

    @RequestMapping(method = RequestMethod.POST,value="/insertAccount")
    public int insertAccount(HttpServletRequest request) throws ParseException {
        Account account=new Account();
        Dorms dorms=new Dorms();
        try {
            InputStream is = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line = null;
            StringBuffer content = new StringBuffer();
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
            String reqStr = content.toString().trim();
            //json解析处理
            //System.out.println(reqStr);
            JSONObject jsonObject = new JSONObject(reqStr);
            JSONArray jsonArray = jsonObject.getJSONArray("selectdatas");
            account.setCompanyName(jsonObject.getString("companyName"));
            account.setContact(jsonObject.getString("contact"));
            account.setContactNumber(jsonObject.getLong("contactNumber")+"");
            account.setDormitoryNum(jsonObject.getString("dormitoryNum"));
            account.setStartDate(jsonObject.getString("startDate"));
            account.setLeasePeriod(jsonObject.getString("leasePeriod"));
            account.setRemark(jsonObject.getInt("remark")+"");
            dorms.setHtId(jsonObject.getString("companyName"));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int id = jsonObject1.getInt("id");
                dorms.setId(id);
                dormService.Updatedroms(dorms);
                //System.out.println("id:"+id);
            }
            //System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountService.insertAccount(account);
    }

    @RequestMapping(method = RequestMethod.POST,value="/deleteAccount")
    public int deleteAccount(@RequestBody Account account){
        return accountService.deleteAccount(account);}

    @RequestMapping(method = RequestMethod.POST,value="/uploadAccount")
    public int uploadAccount(@RequestBody List<ExcelData> excelDataList) throws ParseException {
        //System.out.println(excelDataList.get(0).getCompanyName());
        //System.out.println(excelDataList.get(1).getDromNum().split(",")[0]);

        return accountService.uploadAccount(excelDataList);
    }


    @RequestMapping(method = RequestMethod.GET,value="/getNameList")
    public List<Account> getAccountNameList(HttpServletRequest request){
        return accountService.getAccountNameList(request);
    }
}
