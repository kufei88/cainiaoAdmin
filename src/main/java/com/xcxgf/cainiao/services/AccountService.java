package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.*;
import com.xcxgf.cainiao.mapper.AccountMapper;
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
    //业主信息查询
    public List<Enterprise> getOwnerList(HttpServletRequest request){
        String enterpriseName=request.getParameter("owner");
        return accountMapper.getOwnerList(enterpriseName);
    }
    //数据查询
    public List<Account> getAccountList0(){ return accountMapper.getAccountList0();}

    public List<Account> getAccountList(HttpServletRequest request) throws ParseException {
        funhelper funh=new funhelper();
        int start=(Integer.parseInt(request.getParameter("startnum"))-1)*10;
        //System.out.println(start);
        int pagesize=Integer.parseInt(request.getParameter("pagecount"));
        List<Account> accounts=accountMapper.getAccountList(start,pagesize);
        for(int i=0;i<accounts.toArray().length;i++){
            String startdate=accounts.get(i).getStartRentTime();
            int totalLeasePeriod=accounts.get(i).getTotalPeriod();
            accounts.get(i).setEndRentTime(funh.addMounth(startdate,totalLeasePeriod));
        }
        return accounts;
    }

    public List<Account> getAccountNameList(HttpServletRequest request){
        String name=request.getParameter("name");
        int spg1=Integer.parseInt(request.getParameter("spg"));
        int spg=(spg1-1)*5;
        int spgsize=Integer.parseInt(request.getParameter("spgsize"));
        return accountMapper.getAccountNameList(name,spg,spgsize);
    }

    public int getAccountNameCount(HttpServletRequest request){
        String name=request.getParameter("name");
        return accountMapper.getAccountNameCount(name);
    }



    public int getAccountCount(){return accountMapper.getAccountCount();}
    //数据更新

    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }
    //数据插入
    public int insertAccount(Account account) throws ParseException {
        funhelper funh=new funhelper();
        account.setEndRentTime(funh.addMounth(account.getStartRentTime(),account.getRentPeriod()));
        return accountMapper.insertAccount(account);
    }

    //
    public int insertRenewals(Renewal renewal) throws ParseException {
        //System.out.printf(renewal.getLeasePeriod());
        funhelper funh=new funhelper();
        renewal.setContractType("首租");
        renewal.setContinueEndTime(funh.addMounth(renewal.getContinueStartTime(),
                renewal.getContinuePeriod()));
        return accountMapper.insertRenewals(renewal);
    }

    //数据删除
    public int deleteAccount(Account account){
        Room room=new Room();
        String contractId=account.getContractId();
        String buildingName=account.getBuildingName();
        String owner=account.getOwner();
        room.setRoomNumber(account.getRoomNumber());
        room.setOwner(owner);
        room.setBuildingName(buildingName);

        accountMapper.updateRoom2(room);
        accountMapper.deleteAccount2(contractId);
        return accountMapper.deleteAccount(contractId);
    }

    //上传数据
    public int uploadAccount(List<ExcelData> excelDataList) throws ParseException {
        funhelper fhp=new funhelper();
        int status=1;

        for(int i=0;i<excelDataList.toArray().length;i++){
            Account entityAccount=new Account();
            String [] strarr=excelDataList.get(i).getRoomNumber().split(",");
            String buildingName=excelDataList.get(i).getBuildingName();
            int c=accountMapper.getBuildingListCount(buildingName);
            if(c==0){
                return -4;
            }
            for(int j=0;j<strarr.length;j++){

                int count=accountMapper.getRoomListCount3(strarr[j],buildingName);
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
            entityAccount.setOwner(excelDataList.get(i).getCompanyName());

            if(excelDataList.get(i).getStartDate().split("/").length>1){
                entityAccount.setStartRentTime(dateFormat(excelDataList.get(i).getStartDate()));
                entityAccount.setEndRentTime(fhp.addMounth(dateFormat(excelDataList.get(i).getStartDate()),lsp));
            }
            else{
                entityAccount.setStartRentTime(excelDataList.get(i).getStartDate());
                entityAccount.setEndRentTime(fhp.addMounth(excelDataList.get(i).getStartDate(),lsp));
            }
            entityAccount.setRentPeriod(Integer.parseInt(excelDataList.get(i).getLeasePeriod()));

            entityAccount.setBuildingName(buildingName);

            entityAccount.setTotalCost(Float.parseFloat(excelDataList.get(i).getRemark()));
            entityAccount.setInsertTime(excelDataList.get(i).getInsertTime());
            if(status==1){
                accountMapper.insertAccount(entityAccount);
                for(int n=0;n<strarr.length;n++){
                    Room room=new Room();
                    room.setOwner(excelDataList.get(i).getCompanyName());
                    room.setRoomNumber(strarr[n]);
                    room.setBuildingName(buildingName);
                    accountMapper.updateRoom(room);
                }
            }

        }
        return status;
    }


    public List<Building> getBuildingList(){
        return accountMapper.getBuildingList();
    };

    public List<Room> getRoomList(HttpServletRequest request){
        String roomType=request.getParameter("roomtype");
        String buildingName=request.getParameter("buildingName");
        int page=(Integer.parseInt(request.getParameter("pagedom"))-1)*5;
        return accountMapper.getRoomList(roomType,buildingName,page);
    };

    public int getRoomListCount(HttpServletRequest request){
        String roomType=request.getParameter("roomtype");
        String buildingName=request.getParameter("buildingName");
        return accountMapper.getRoomListCount(roomType,buildingName);
    };

    //更新房间信息
    public int updateRoom(Room room){
        return accountMapper.updateRoom(room);
    }

    //
    public List<Room> getRoomList2(HttpServletRequest request){
        String owner=request.getParameter("owner");
        String buildingName=request.getParameter("buildingName");
        int start=(Integer.parseInt(request.getParameter("startpage"))-1)*5;
        return accountMapper.getRoomList2(owner,buildingName,start);
    };

    public int getRoomListCount2(HttpServletRequest request){
        String owner=request.getParameter("owner");
        String buildingName=request.getParameter("buildingName");
        return accountMapper.getRoomListCount2(owner,buildingName);
    };

    public String dateFormat(String date) throws ParseException {
        SimpleDateFormat sdf1=new SimpleDateFormat("MM/dd/yy");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String outDate=sdf.format(sdf1.parse(date));

        return outDate;
    }

    //查询公司是否存在
    public int getCompanyName(HttpServletRequest request){
        String enterpriseName=request.getParameter("companyName");
        return accountMapper.getCompanyName(enterpriseName);
    }

    public String getRoomType(Account account){
        return accountMapper.getRoomType(account);
    }
}
