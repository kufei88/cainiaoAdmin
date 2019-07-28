package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
