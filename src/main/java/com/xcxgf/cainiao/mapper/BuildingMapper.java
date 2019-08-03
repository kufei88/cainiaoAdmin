package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Building;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BuildingMapper {
    @Select("select * from buildingInfo where state !=-1")
    public List<Building> getBuildingList();

    @Update("UPDATE buildingInfo SET buildingNumber=#{buildingNumber},buildingName=#{buildingName},roomArea=#{roomArea},hardwareSituation=#{hardwareSituation},rent=#{rent},additionalConditions=#{additionalConditions} WHERE id =#{id}")
    public void updateBuildingInfo(Building building);

    @Update("UPDATE buildingInfo SET state=-1 WHERE id =#{id}")
    public void deleteBuildingInfo(Building building);

    @Insert("INSERT INTO buildingInfo(buildingNumber,buildingName,roomArea,hardwareSituation,rent,additionalConditions) VALUES(#{buildingNumber}, #{buildingName}, #{roomArea},#{hardwareSituation},#{rent},#{additionalConditions})")
    public void insertBuildingInfo(Building building);
}
