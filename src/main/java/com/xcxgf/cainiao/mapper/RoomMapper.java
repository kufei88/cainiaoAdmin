package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Lease;
import com.xcxgf.cainiao.POJO.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoomMapper {

    @Select("select * from roomInfo where state != -1 ${search} ORDER BY CAST(buildingName AS DECIMAL),roomNumber ${limit}")
    public List<Room> getSearchList(String search, String limit);

    @Select("SELECT count(*) FROM roomInfo WHERE state !=-1 ${search}")
    public int getSearchCount(String search);

    @Select("select * from roomInfo where state !=-1")
    public List<Room> getRoomList();

    @Update("UPDATE roomInfo SET state=-1 WHERE id =#{id}")
    public int deleteRoomInfo(Room room);

    @Update("UPDATE roomInfo SET roomNumber=#{roomNumber},buildingName=#{buildingName},rentArea=#{rentArea},builtUpArea=#{builtUpArea},owner=#{owner} WHERE id =#{id}")
    public int updateRoomInfo(Room room);

    @Insert("INSERT INTO roomInfo(roomNumber,buildingName,rentArea,builtUpArea,owner) VALUES(#{roomNumber}, #{buildingName}, #{rentArea}, #{builtUpArea}, #{owner})")
    public int insertRoomInfo(Room room);

    @Update("UPDATE roomInfo SET owner=#{owner} WHERE roomNumber=#{roomNumber} and buildingName=#{buildingName}")
    public int updateRoomInfoOwner(Lease lease);

    @Update("UPDATE roomInfo SET owner=#{owner} WHERE roomNumber=#{roomNumber} and buildingName=#{buildingName}")
    public int deleteRoomInfoOwner(Lease lease);

    @Select("select count(*) from roomInfo " +
            "where state != -1 "+
            "and buildingName = #{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertSearchSame(Room room);

    @Select("SELECT COUNT(*) FROM (SELECT * FROM roomInfo WHERE id NOT in (SELECT id FROM roomInfo WHERE state != -1 AND id = #{id})) AS temp WHERE state != -1 AND roomNumber = #{roomNumber} AND buildingName = #{buildingName}")
    public int updateSearchSame(Room room);
}
