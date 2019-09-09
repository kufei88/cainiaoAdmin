package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Dormitory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DormitoryMapper {
    @Select("select * from dormitory limit 0,10")
    public List<Dormitory> getDormitoryList0();

    @Select("select * from dormitory limit #{start},#{pagesize}")
    public List<Dormitory> getDormitoryList(int start,int pagesize);

    @Select("select id from dormitory where dormitoryName=#{dormitoryName}")
    public int Selectid(String dormitoryName);

    @Select("select dormitoryName from dormitory where id=#{id}")
    public String SelectName(int id);

    @Insert("insert into dormitory(dormitoryName,money) " +
            "values(#{dormitoryName},#{money})")
    public int addNewDormitory(String dormitoryName,String money);

    @Update("update dormitory set dormitoryName=#{dormitoryName},money=#{money} where id=#{id}")
    public int updateDormitory(Dormitory dormitory);

    @Delete("delete from dormitory where id=#{id}")
    public int deleteRow(int id);

    @Select("select count(*) from dormitory where isdelete=false")
    public int getDormitoryCount();
}
