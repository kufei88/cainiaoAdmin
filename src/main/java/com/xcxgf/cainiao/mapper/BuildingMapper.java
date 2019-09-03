package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Building;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BuildingMapper {

    //查找所有可用记录
    @Select("select * from buildingInfo where state != -1")
    public List<Building> getBuildingList();

    //查询满足条件的可用记录
    //search为查询条件，limit为查询需要返回的位置
    @Select("select * from buildingInfo where state != -1 ${search} ORDER BY CAST(buildingNumber AS DECIMAL) ${limit}")
    public List<Building> getSearchList(String search, String limit);

    //查询满足条件的可用记录的条数
    // search为查询条件
    @Select("SELECT count(*) FROM buildingInfo WHERE state !=-1 ${search}")
    public int getSearchCount(String search);

    //更新记录
    //字段buildingNumber（办公楼楼号）、buildingName（办公楼名称）
    @Update("UPDATE buildingInfo SET buildingNumber=#{buildingNumber},buildingName=#{buildingName} WHERE id =#{id}")
    public int updateBuildingInfo(Building building);

    //删除记录
    @Update("UPDATE buildingInfo SET state=-1 WHERE id =#{id}")
    public int deleteBuildingInfo(Building building);

    //插入记录
    @Insert("INSERT INTO buildingInfo(buildingNumber,buildingName) VALUES(#{buildingNumber}, #{buildingName})")
    public int insertBuildingInfo(Building building);

    //查询是否存在重复记录
    @Select("select count(*) from buildingInfo " +
            "where state != -1 " +
            "and (buildingName = #{buildingName} or buildingNumber = #{buildingNumber})")
    public int insertSearchSame(Building building);

    @Select("SELECT COUNT(*) FROM (SELECT * FROM buildingInfo WHERE id NOT in (select id from buildingInfo where state != -1 AND id=#{id})) AS temp WHERE state != -1 AND (buildingName = #{buildingName} or buildingNumber = #{buildingNumber})")
    public int updateSearchSame(Building building);

}