package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoomMapper {
    @Select("select * from roomInfo where state !=-1")
    public List<Room> getRoomList();

    @Update("UPDATE roomInfo SET state=-1 WHERE id =#{id}")
    public void deleteRoomInfo(Room room);

    @Update("UPDATE roomInfo SET roomNumber=#{roomNumber},buildingNumber=#{buildingNumber},rentArea=#{rentArea},builtUpArea=#{builtUpArea},owner=#{owner} WHERE id =#{id}")
    public void updateRoomInfo(Room room);

    @Insert("INSERT INTO roomInfo(roomNumber,buildingNumber,rentArea,builtUpArea,owner) VALUES(#{roomNumber}, #{buildingNumber}, #{rentArea}, #{builtUpArea}, #{owner})")
    public void insertRoomInfo(Room room);

}
