package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Building;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BuildingMapper {
    @Select("select * from buildingInfo")
    public List<Building> getBuildingList();
}
