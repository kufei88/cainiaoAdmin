package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Building;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    //查询
    @Select("select * from businessaccount where isdelete=false")
    public List<Account> getAccountList();

    //更新
    @Update("update businessaccount set companyName=#{companyName},contact=#{contact}," +
            "contactNumber=#{contactNumber},venueNumber=#{venueNumber},contractSigning=#{contractSigning}," +
            "leasePeriod=#{leasePeriod},remark=#{remark} where id=#{id}")
    public int updateAccount(Account entityAccount);

    //插入
    @Insert("insert into businessaccount(companyName,contact,contactNumber," +
            "venueNumber,contractSigning,leasePeriod,remark) values(#{companyName}," +
            "#{contact},#{contactNumber},#{venueNumber}," +
            "#{contractSigning},#{leasePeriod},#{remark})")
    public int insertAccount(Account entityAccount);

    @Update("update businessaccount set isdelete=true where id=#{id}")
    public int deleteAccount(int id);
}
