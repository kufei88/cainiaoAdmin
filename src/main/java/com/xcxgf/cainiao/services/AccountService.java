package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Dormitory;
import com.xcxgf.cainiao.POJO.ExcelData;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.mapper.DormMapper;
import com.xcxgf.cainiao.mapper.DormitoryMapper;
import com.xcxgf.cainiao.mapper.RenewalMapper;
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

    @Autowired
    DormMapper dormMapper;


    @Autowired
    DormitoryMapper dormitoryMapper;

    @Autowired
    RenewalMapper renewalMapper;
    //数据查询
    public List<Account> getAccountList0(){ return accountMapper.getAccountList0();}

    public List<Account> getAccountList(HttpServletRequest request)
    {
        int start=(Integer.parseInt(request.getParameter("startnum"))-1)*10;
        //System.out.println(start);
        int pagesize=Integer.parseInt(request.getParameter("pagecount"));

        return accountMapper.getAccountList(start,pagesize);
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
    public int deleteAccount(Account account){
        int id=account.getId();

        String dormitoryName=account.getDormitoryNum();

        int domitoryId=dormitoryMapper.Selectid(dormitoryName);

        String htid=account.getCompanyName();

        dormMapper.Updatedroms3(domitoryId,htid);

        return accountMapper.deleteAccount(id);
    }

    //上传数据
    public int uploadAccount(List<ExcelData> excelDataList) throws ParseException {
        funhelper fhp=new funhelper();
        int status=1;
        for(int i=0;i<excelDataList.toArray().length;i++){
            Account entityAccount=new Account();
            String [] strarr=excelDataList.get(i).getDromNum().split(",");
            int dormitoryid=Integer.parseInt(excelDataList.get(i).getDormitoryId());
            for(int j=0;j<strarr.length;j++){

                int count=dormMapper.selectRepeat(dormitoryid,strarr[j]);
                if(count==0){
                    status=-1;
                    return status;
                }
                if(count>1){
                    status=-3;
                    return status;
                }

            }
            int lsp=Integer.parseInt(excelDataList.get(i).getLeasePeriod());
            entityAccount.setCompanyName(excelDataList.get(i).getCompanyName());
            entityAccount.setContact(excelDataList.get(i).getContact());
            entityAccount.setContactNumber(excelDataList.get(i).getContactNumber());
            entityAccount.setStartDate(excelDataList.get(i).getStartDate());
            entityAccount.setLeasePeriod(excelDataList.get(i).getLeasePeriod());
            entityAccount.setEndDate(fhp.addMounth(excelDataList.get(i).getStartDate(),lsp));
            entityAccount.setDormitoryNum(dormitoryMapper.SelectName(dormitoryid));
            entityAccount.setRemark(excelDataList.get(i).getRemark());
            if(status==1){
                accountMapper.insertAccount(entityAccount);
                for(int n=0;n<strarr.length;n++){
                    String htid=excelDataList.get(i).getCompanyName();
                    String dromNum=strarr[n];
                    dormMapper.Updatedroms2(htid,dormitoryid,dromNum);
                }
            }

        }
        return status;
    }


}
