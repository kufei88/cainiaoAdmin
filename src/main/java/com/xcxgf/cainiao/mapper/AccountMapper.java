package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Building;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    //查询
   @Select("select * from dormitorymanage where isdelete=false limit 0,10")
   public List<Account> getAccountList0();
    //分页查询
    @Select("select * from dormitorymanage where isdelete=false limit #{start},#{pagesize}")
    public List<Account> getAccountList(int start,int pagesize);

    @Select("select * from dormitorymanage where isdelete=false and companyName like CONCAT('%',#{name},'%')")
    public List<Account> getAccountNameList(String companyName);

    @Select("select * from dormitorymanage where id=#{id}")
    public List<Account> getAccountIdList(int id);

    @Select("select count(*) from dormitorymanage where isdelete=false")
    public int getAccountCount();
    //更新
    @Update("update dormitorymanage set companyName=#{companyName}," +
            "contact=#{contact}," +
            "contactNumber=#{contactNumber}," +
            "dormitoryNum=#{dormitoryNum}," +
            "contractSigning=#{contractSigning}," +
            "startDate=#{startDate}," +
            "endDate=#{endDate}," +
            "leasePeriod=#{leasePeriod}," +
            "remark=#{remark} where id=#{id}")
    public int updateAccount(Account entityAccount);

    //插入
    @Insert("insert into dormitorymanage(companyName,contact,contactNumber," +
            "dormitoryNum,startDate,endDate,leasePeriod,remark) values(#{companyName}," +
            "#{contact},#{contactNumber},#{dormitoryNum}," +
            "#{startDate}," +
            "#{endDate}," +
            "#{leasePeriod},#{remark})")
    public int insertAccount(Account entityAccount);

    @Delete("delete from dormitorymanage where id=#{id}")
    public int deleteAccount(int id);
}
