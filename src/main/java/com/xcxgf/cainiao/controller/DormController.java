package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Dorms;
import com.xcxgf.cainiao.services.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("Dorms")
public class DormController {
    @Autowired
    DormService dormService;
    @RequestMapping(method = RequestMethod.POST,value = "/getDormsData")
    public List<Dorms> getDormList(HttpServletRequest request){
        return dormService.getDormList(request);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getDormsCount")
    public int getCountByDId(HttpServletRequest request){
        return dormService.getCountByDId(request);
    }


}
