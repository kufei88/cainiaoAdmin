package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Building;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    //查询
    @Select("select * from dormitorymanage where isdelete=false")
    public List<Account> getAccountList();

    @Select("select * from dormitorymanage where isdelete=false and companyName like CONCAT('%',#{name},'%')")
    public List<Account> getAccountNameList(String companyName);
    //更新
    @Update("update dormitorymanage set companyName=#{companyName},contact=#{contact}," +
            "contactNumber=#{contactNumber},dormitoryNum=#{dormitoryNum},contractSigning=#{contractSigning}," +
            "leasePeriod=#{leasePeriod},remark=#{remark} where id=#{id}")
    public int updateAccount(Account entityAccount);

    //插入
    @Insert("insert into dormitorymanage(companyName,contact,contactNumber," +
            "dormitoryNum,leasePeriod,remark) values(#{companyName}," +
            "#{contact},#{contactNumber},#{dormitoryNum}," +
            "#{leasePeriod},#{remark})")
    public int insertAccount(Account entityAccount);

    @Update("update dormitorymanage set isdelete=true where id=#{id}")
    public int deleteAccount(int id);
}
