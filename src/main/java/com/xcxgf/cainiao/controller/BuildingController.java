package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("building")
public class BuildingController {
    @Autowired
    private BuildingService bs;

    @RequestMapping(method = RequestMethod.GET, value = "/getBuildingList")
    public List<Building> getBuildingList() {
        return bs.getBuildingList();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/updateBuildingList")
    public List<Building> updateBuildingList(@RequestBody Building building) {
        return bs.updateBuildingList(building);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteBuildingList")
    public List<Building> deleteBuildingList(@RequestBody Building building) {
        return bs.deleteBuildingList(building);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertBuildingList")
    public List<Building> insertBuildingList(@RequestBody Building building) {
        return bs.insertBuildingList(building);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertBuildingListAll")
    public List<Building> insertBuildingListAll(@RequestBody List<Building> buildingList) {
        return bs.insertBuildingListAll(buildingList);
    }
}
