package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Dormitory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DormitoryMapper {
    @Select("select * from dormitory where isfull=false")
    public List<Dormitory> getDormitoryList();

    @Select("select id from dormitory where dormitoryName=#{dormitoryName}")
    public int Selectid(String dormitoryName);

    @Select("select dormitoryName from dormitory where id=#{id}")
    public String SelectName(int id);

    @Insert("insert into dormitory(dormitoryName,money) " +
            "values(#{dormitoryName},#{money})")
    public int addNewDormitory(String dormitoryName,String money);
}
