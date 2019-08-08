package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Building;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BuildingMapper {
    @Select("select * from buildingInfo")
    public List<Building> getBuildingList();
<<<<<<< HEAD

    @Update("UPDATE buildingInfo SET buildingNumber=#{buildingNumber},buildingName=#{buildingName} WHERE id =#{id}")
    public void updateBuildingInfo(Building building);

    @Update("UPDATE buildingInfo SET state=-1 WHERE id =#{id}")
    public void deleteBuildingInfo(Building building);

    @Insert("INSERT INTO buildingInfo(buildingNumber,buildingName) VALUES(#{buildingNumber}, #{buildingName})")
    public void insertBuildingInfo(Building building);
=======
>>>>>>> 9f07f288bd3fe2e3312284a8dfc4e6dbd4c3250c
}
