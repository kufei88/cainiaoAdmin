package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Enterprise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EnterpriseMapper {
    @Select("select * from enterpriseInfo where state !=-1")
    public List<Enterprise> getEnterpriseList();

    @Update("UPDATE enterpriseInfo SET enterpriseName=#{enterpriseName},enterprisePerson=#{enterprisePerson},enterpriseTelphone=#{enterpriseTelphone} WHERE id =#{id}")
    public void updateEnterpriseInfo(Enterprise enterprise);

    @Update("UPDATE enterpriseInfo SET state=-1 WHERE id =#{id}")
    public void deleteEnterpriseInfo(Enterprise enterprise);

    @Insert("INSERT INTO enterpriseInfo(enterpriseName,enterprisePerson,enterpriseTelphone) VALUES(#{enterpriseName}, #{enterprisePerson}, #{enterpriseTelphone})")
    public void insertEnterpriseInfo(Enterprise enterprise);

}
