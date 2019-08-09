package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.mapper.BuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    public List<Building> getBuildingList(){
        return buildingMapper.getBuildingList();
    }

    public List<Building> updateBuildingList(Building building){
        buildingMapper.updateBuildingInfo(building);
        return buildingMapper.getBuildingList();
    }

    public List<Building> deleteBuildingList(Building building){
        buildingMapper.deleteBuildingInfo(building);
        return buildingMapper.getBuildingList();
    }

    public List<Building> insertBuildingList(Building building){
        buildingMapper.insertBuildingInfo(building);
        return buildingMapper.getBuildingList();
    }

    public List<Building> insertBuildingListAll(List<Building> buildingList){
        for (Building building: buildingList) {
            buildingMapper.insertBuildingInfo(building);
        }
        return buildingMapper.getBuildingList();
    }
}
