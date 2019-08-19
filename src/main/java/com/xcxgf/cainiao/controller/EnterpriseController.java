package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Enterprise;
import com.xcxgf.cainiao.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService es;

    @RequestMapping(method = RequestMethod.GET,value = "/getEnterpriseList")
    public List<Enterprise> getEnterpriseList(){
        return es.getEnterpriseList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deleteEnterpriseList")
    public List<Enterprise> deleteEnterpriseList(@RequestBody Enterprise enterprise){
        return es.deleteEnterpriseList(enterprise);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateEnterpriseList")
    public List<Enterprise> updateEnterpriseList(@RequestBody Enterprise enterprise){
        return es.updateEnterpriseList(enterprise);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertEnterpriseList")
    public List<Enterprise> insertEnterpriseList(@RequestBody Enterprise enterprise){
        return es.insertEnterpriseList(enterprise);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/uploadEnterpriseList")
    public List<Enterprise> uploadEnterpriseList(@RequestBody List<Enterprise> enterpriseList){
        return es.uploadEnterpriseList(enterpriseList);
    }

}
