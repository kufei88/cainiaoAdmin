package com.xcxgf.cainiao.controller;



import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@RestController
@RequestMapping("building")
public class BuildingController {
    @Autowired
    private BuildingService bs;


    @RequestMapping(method = RequestMethod.GET,value="/getBuildingList")
    public List<Building> getBuildingList(){
        return bs.getBuildingList();
    }

    @RequestMapping(method = RequestMethod.POST,value="/deleteBuildingList")
    public List<Building> deleteBuildingList(@RequestBody Building building){
        bs.deleteBuildingList(building);
        return bs.getBuildingList();
    }

    @RequestMapping(method = RequestMethod.POST,value="/updateBuildingList")
    public List<Building> updateBuildingList(@RequestBody Building building){
        bs.updateBuildingList(building);
        return bs.getBuildingList();
    }

    @RequestMapping(method = RequestMethod.POST,value="/insertBuildingList")
    public List<Building> insertBuildingList(@RequestBody Building building){
        bs.insertBuildingList(building);
        return bs.getBuildingList();
    }

}
