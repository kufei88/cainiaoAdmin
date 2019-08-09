package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Setting;
import com.xcxgf.cainiao.services.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("setting")
public class SettingController {
    @Autowired
    private SettingService ss;

    @RequestMapping(method = RequestMethod.GET,value = "/getSettingList")
    public List<Setting> getSettingList(){
        return ss.getSettingList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateSettingList")
    public List<Setting> updateSettingList(@RequestBody Setting setting){
        ss.updateSettingList(setting);
        return ss.getSettingList();
    }
}
