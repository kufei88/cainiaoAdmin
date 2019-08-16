package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Dormitory;
import com.xcxgf.cainiao.services.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Dormitory")
public class DormitoryController {
    @Autowired
    DormitoryService dormitoryService;
    @RequestMapping(method = RequestMethod.GET,value="/getDormitoryList")
    public List<Dormitory> getAccountList(){return dormitoryService.getDormitoryList();}
}
