package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Setting;
import com.xcxgf.cainiao.mapper.SettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {
    @Autowired
    private SettingMapper sm;

    public List<Setting> getSettingList(){
        return sm.getSettingList();
    }

    public List<Setting> updateSettingList(Setting setting){
        sm.updateSettingList(setting);
        return sm.getSettingList();
    }
}
