package com.xcxgf.cainiao.controller;


import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(method = RequestMethod.GET, value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        String search = request.getParameter("search");
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        String searchStr = "".equals(search) ? "" : "and (buildingName like '%" + search + "%' or buildingNumber = '%"+search+"%')";
        String limitStr = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return bs.getSearchList(searchStr, limitStr);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteBuildingList")
    public int deleteBuildingList(@RequestBody Building building) {
        return bs.deleteBuildingList(building);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateBuildingList")
    public int updateBuildingList(@RequestBody Building building) {
        return bs.updateBuildingList(building);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertBuildingList")
    public int insertBuildingList(@RequestBody Building building) {
        return bs.insertBuildingList(building);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uploadBuildingList")
    public int insertBuildingListAll(@RequestBody List<Building> building) {
        return bs.insertBuildingListAll(building);
    }

}
