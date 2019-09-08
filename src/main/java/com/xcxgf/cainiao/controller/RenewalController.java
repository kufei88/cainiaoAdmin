package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Dorms;
import com.xcxgf.cainiao.POJO.Renewal;
import com.xcxgf.cainiao.POJO.fangjian;
import com.xcxgf.cainiao.mapper.DormitoryMapper;
import com.xcxgf.cainiao.services.DormService;
import com.xcxgf.cainiao.services.RenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("Renewal")
public class RenewalController {
    @Autowired
    RenewalService renewalService;

    @Autowired
    DormitoryMapper dormitoryMapper;
    @Autowired
    DormService dormService;

    @RequestMapping(method= RequestMethod.GET,value = "/getRenewalList")
    public List<Renewal> getRenewalList(HttpServletRequest request){return renewalService.getRenewalList(request);}

    @RequestMapping(method =RequestMethod.GET,value = "/getCount")
    public int getCount(HttpServletRequest request){return  renewalService.getCount(request);}

    @RequestMapping(method =RequestMethod.POST,value = "/insertRenewals")
    public int insertRenewals(@RequestBody Renewal renewal) throws ParseException {
        //System.out.printf(renewal.getLeasePeriod());
        return renewalService.insertRenewals(renewal);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/selectDroms")
    public List<Dorms> selectDroms(@RequestBody fangjian fj){
        String companyName=fj.getCompanyName();
        int id=dormitoryMapper.Selectid(fj.getDormitoryNum());
        return dormService.selectDroms(companyName,id);
    }

}

