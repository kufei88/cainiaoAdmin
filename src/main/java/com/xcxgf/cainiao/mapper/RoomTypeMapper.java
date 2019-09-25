package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.RoomType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoomTypeMapper {
    @Select("select * from roomtypeinfo")
    public List<RoomType> getRoomType();

    @Select("select monthRent from roomtypeinfo where roomType=#{roomType}")
    public float getMonthRent(String roomType);

    @Insert("insert into roomtypeinfo(roomType,monthRent) values(#{roomType},#{monthRent})")
    public int insertRoomType(RoomType roomType);

    @Delete("delete from roomtypeinfo where id=#{id}")
    public int deleteRoomType(int id);

    @Update("update roomtypeinfo set monthRent=#{monthRent} where id=#{id}")
    public int updateMonthRent(RoomType roomType);
}
