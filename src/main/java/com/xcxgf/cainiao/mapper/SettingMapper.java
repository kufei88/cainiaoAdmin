package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Setting;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SettingMapper {
    @Select("select * from settingInfo where state != -1")
    public List<Setting> getSettingList();

    @Update("update settingInfo set rentUnitPrice=#{rentUnitPrice},manageExpense=#{manageExpense} where id=#{id}")
    public void updateSettingList(Setting setting);
}
