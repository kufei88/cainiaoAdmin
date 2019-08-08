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
}
