package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Enterprise;
import com.xcxgf.cainiao.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService es;

    @RequestMapping(method = RequestMethod.GET,value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        String search = request.getParameter("search");
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        String searchStr = "".equals(search) ? "" : "and (enterpriseName like '%" + search +"%' or enterprisePerson like '%"+search+ "%')";
        String limitStr = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit "+start+","+end;

        return es.getSearchList(searchStr,limitStr);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getEnterpriseList")
    public List<Enterprise> getEnterpriseList(){
        return es.getEnterpriseList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deleteEnterpriseList")
    public int deleteEnterpriseList(@RequestBody Enterprise enterprise){
        return es.deleteEnterpriseList(enterprise);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateEnterpriseList")
    public int updateEnterpriseList(@RequestBody Enterprise enterprise){
        return es.updateEnterpriseList(enterprise);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertEnterpriseList")
    public int insertEnterpriseList(@RequestBody Enterprise enterprise){
        return es.insertEnterpriseList(enterprise);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/uploadEnterpriseList")
    public int uploadEnterpriseList(@RequestBody List<Enterprise> enterpriseList){
        return es.uploadEnterpriseList(enterpriseList);
    }

}
