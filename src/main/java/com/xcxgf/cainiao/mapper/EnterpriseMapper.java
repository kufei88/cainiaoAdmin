package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Enterprise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EnterpriseMapper {
    @Select("select * from enterpriseInfo where state != -1 ${search} ${limit}")
    public List<Enterprise> getSearchList(String search, String limit);

    @Select("SELECT count(*) FROM enterpriseInfo WHERE state !=-1 ${search}")
    public int getSearchCount(String search);

    @Select("select * from enterpriseInfo where state !=-1")
    public List<Enterprise> getEnterpriseList();

    @Update("UPDATE enterpriseInfo SET enterpriseName=#{enterpriseName},enterprisePerson=#{enterprisePerson},enterpriseTelphone=#{enterpriseTelphone} WHERE id =#{id}")
    public int updateEnterpriseInfo(Enterprise enterprise);

    @Update("UPDATE enterpriseInfo SET state=-1 WHERE id =#{id}")
    public int deleteEnterpriseInfo(Enterprise enterprise);

    @Insert("INSERT INTO enterpriseInfo(enterpriseName,enterprisePerson,enterpriseTelphone) VALUES(#{enterpriseName}, #{enterprisePerson}, #{enterpriseTelphone})")
    public int insertEnterpriseInfo(Enterprise enterprise);

    @Select("select count(*) from enterpriseInfo " +
            "where state != -1 " +
            "and enterpriseName = #{enterpriseName}")
    public int insertSearchSame(Enterprise enterprise);

    @Select("SELECT COUNT(*) FROM (SELECT * FROM enterpriseInfo WHERE id NOT in (SELECT id FROM enterpriseInfo WHERE state != -1 AND id = #{id})) AS temp WHERE state != -1 AND enterpriseName = #{enterpriseName}")
    public int updateSearchSame(Enterprise enterprise);

}
