package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.mapper.BuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    public List<Building> getBuildingList() {
        return buildingMapper.getBuildingList();
    }

    public DataReturn getSearchList(String searchStr, String limitStr) {
        DataReturn dataReturn = new DataReturn();
        dataReturn.setBuildingList(buildingMapper.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(buildingMapper.getSearchCount(searchStr));
        return dataReturn;
    }

    public int updateBuildingList(Building building) {
        int reqCode = 0;
        if (buildingMapper.updateSearchSame(building)!=0) {
            reqCode = -1;
        } else if (buildingMapper.updateBuildingInfo(building) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int deleteBuildingList(Building building) {
        int reqCode = 0;
        if (buildingMapper.deleteBuildingInfo(building) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int insertBuildingList(Building building) {
        int reqCode = 0;
        if (buildingMapper.insertSearchSame(building) != 0) {
            reqCode = -1;
        } else if (buildingMapper.insertBuildingInfo(building) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int insertBuildingListAll(List<Building> buildingList) {
        int reqCode = 0;
        for (Building building : buildingList) {
            if (buildingMapper.insertBuildingInfo(building) > 0) {
                reqCode += 1;
            }
        }
        return reqCode;
    }
}
