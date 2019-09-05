package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Dormitory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DormitoryMapper {
    @Select("select * from dormitory where isdelete=false")
    public List<Dormitory> getDormitoryList();

}
