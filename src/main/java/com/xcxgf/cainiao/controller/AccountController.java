package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.*;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.services.AccountService;
import com.xcxgf.cainiao.services.GetFormatDate;
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

    //获取公司信息
    @RequestMapping(method = RequestMethod.GET,value="/getOwnerList")
    public List<Enterprise> getOwnerList(HttpServletRequest request){
        return accountService.getOwnerList(request);
    }
    //获取首租合同的信息
    @RequestMapping(method = RequestMethod.GET,value="/getAccountList")
    public List<Account> getAccountList(HttpServletRequest request) throws ParseException
    {return accountService.getAccountList(request);}
    //获取第一页首租合同的信息
    @RequestMapping(method = RequestMethod.GET,value="/getAccountList0")
    public List<Account> getAccountList0() {return accountService.getAccountList0();}


    @RequestMapping(method = RequestMethod.POST,value = "/getAccountCount")
    public int getAccountCount(){return accountService.getAccountCount();}

    @RequestMapping(method = RequestMethod.POST,value="/updateAccount")
    public int updateAccount(@RequestBody Account account) throws ParseException
    { return accountService.updateAccount(account);}

    //插入合同信息
    @RequestMapping(method = RequestMethod.POST,value="/insertAccount")
    public int insertAccount(HttpServletRequest request) throws ParseException {
        int Status=1;
        Account account=new Account();
        Room room=new Room();
        Renewal renewal=new Renewal();
        GetFormatDate getFormatDate=new GetFormatDate();
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
            account.setOwner(jsonObject.getString("companyName"));
            renewal.setOwner(jsonObject.getString("companyName"));
//            account.setContact(jsonObject.getString("contact"));
//            account.setContactNumber(jsonObject.getLong("contactNumber")+"");
            account.setBuildingName(jsonObject.getString("buildingName"));

            account.setStartRentTime(jsonObject.getString("startDate"));
            renewal.setContinueStartTime(jsonObject.getString("startDate"));

            account.setRentPeriod(jsonObject.getInt("leasePeriod"));
            renewal.setContinuePeriod(jsonObject.getInt("leasePeriod"));

            account.setTotalCost((float) jsonObject.getDouble("remark"));
            renewal.setTotalCost((float) jsonObject.getDouble("remark"));


            account.setInsertTime(jsonObject.getString("insertTime"));
            renewal.setInsertTime(jsonObject.getString("insertTime"));
            //dorms.setHtId(jsonObject.getString("companyName"));

            room.setOwner(jsonObject.getString("companyName"));
            room.setBuildingName(jsonObject.getString("buildingName"));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String  roomNumber = jsonObject1.getString("roomNumber");
                String contractId=getFormatDate.getNowDate()+roomNumber;
                account.setContractId(contractId);
                renewal.setContractId(contractId);

                account.setRoomNumber(roomNumber);
                room.setRoomNumber(roomNumber);
                int t= accountService.updateRoom(room);
                int a=accountService.insertAccount(account);
                int c=accountService.insertRenewals(renewal);

                if(a!=1||t!=1||c!=1){
                    Status=0;
                }
                //System.out.println("id:"+id);
            }
            //System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status;
    }

    //删除
    @RequestMapping(method = RequestMethod.POST,value="/deleteAccount")
    public int deleteAccount(@RequestBody Account account){
        return accountService.deleteAccount(account);}
    //excel上传
    @RequestMapping(method = RequestMethod.POST,value="/uploadAccount")
    public int uploadAccount(@RequestBody List<ExcelData> excelDataList) throws ParseException {
        //System.out.println(excelDataList.get(0).getCompanyName());
        //System.out.println(excelDataList.get(1).getDromNum().split(",")[0]);

        return accountService.uploadAccount(excelDataList);
    }


    //获取全部符合搜索条件的合同
    @RequestMapping(method = RequestMethod.GET,value="/getNameList")
    public List<Account> getAccountNameList(HttpServletRequest request){
        return accountService.getAccountNameList(request);
    }
    //获取全部符合搜索条件的合同的总条数
    @RequestMapping(method = RequestMethod.GET,value="/getNameCount")
    public int getAccountNameCount(HttpServletRequest request){
        return accountService.getAccountNameCount(request);
    }

    //获取寝室楼栋
    @RequestMapping(method = RequestMethod.GET,value = "/getBuildingList")
    public List<Building> getBuildingList(){
        return accountService.getBuildingList();
    }


    @RequestMapping(method = RequestMethod.GET,value = "/getRoomList")
    public List<Room> getRoomList(HttpServletRequest request){
        return accountService.getRoomList(request);
    }

    //获取选择的楼栋的空闲房间的数量
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomListCount")
    public int getRoomListCount(HttpServletRequest request){

        return accountService.getRoomListCount(request);
    }

    //获取该合同中的具体租赁房间
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomListCount2")
    public int getRoomListCount2(HttpServletRequest request){
        return accountService.getRoomListCount2(request);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getRoomList2")
    public List<Room> getRoomList2(HttpServletRequest request){
        return accountService.getRoomList2(request);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getCompanyName")
    public int getCompanyName(HttpServletRequest request){
        return accountService.getCompanyName(request);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getRoomType")
    public String getRoomType(@RequestBody Account account){
        return accountService.getRoomType(account);
    }
}
