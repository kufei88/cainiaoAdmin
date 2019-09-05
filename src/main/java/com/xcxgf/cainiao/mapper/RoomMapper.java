package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Lease;
import com.xcxgf.cainiao.POJO.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对数据库中roomInfo表（办公室管理表）的增删改查操作
 */
public interface RoomMapper {
    /**
     * 查询满足条件的可用记录
     *
     * @param search 查询条件
     * @param limit  需要返回的记录的起始位置和终止位置
     * @return Room类型的集合，满足条件的可用记录
     */
    @Select("select * from roomInfo where state != -1 ${search} ORDER BY CAST(buildingName AS DECIMAL),roomNumber ${limit}")
    public List<Room> getSearchList(String search, String limit);
    /**
     * 查询满足条件的可用记录的条数
     *
     * @param search 查询条件
     * @return int类型，满足条件的记录条数
     */
    @Select("SELECT count(*) FROM roomInfo WHERE state !=-1 ${search}")
    public int getSearchCount(String search);
    /**
     * 查找所有房间租赁状态为空闲的记录
     *
     * @return Room类型的集合，所有房间租赁状态为空闲的记录
     */
    @Select("select * from roomInfo where state !=-1 and owner = '空闲' ORDER BY CAST(buildingName AS DECIMAL),roomNumber")
    public List<Room> getRoomList();
    /**
     * 查找所有房间租赁状态不为空闲的记录
     *
     * @return Room类型的集合，所有房间租赁状态不为空闲的记录
     */
    @Select("select * from roomInfo where state !=-1 and owner != '空闲' ORDER BY CAST(buildingName AS DECIMAL),roomNumber")
    public List<Room> getRoomListContinue();
    /**
     * 删除记录
     *
     * @param room 需要删除的记录对象
     * @return int类型，删除操作影响的记录条数，为0时删除失败，否则删除成功
     */
    @Delete("DELETE FROM roomInfo WHERE id =#{id}")
    public int deleteRoomInfo(Room room);
    /**
     * 更新记录
     *
     * @param room 需要更新的记录对象
     * @return int类型，更新操作影响的记录条数，为0时更新失败，否则更新成功
     */
    @Update("UPDATE roomInfo SET roomNumber=#{roomNumber},buildingName=#{buildingName},rentArea=#{rentArea},builtUpArea=#{builtUpArea},owner=#{owner} WHERE id =#{id}")
    public int updateRoomInfo(Room room);
    /**
     * 插入新记录
     *
     * @param room 需要插入的记录对象
     * @return int类型，插入记录影响的记录条数，为0时插入失败，否则插入成功
     */
    @Insert("INSERT INTO roomInfo(roomNumber,buildingName,rentArea,builtUpArea,owner) VALUES(#{roomNumber}, #{buildingName}, #{rentArea}, #{builtUpArea}, #{owner})")
    public int insertRoomInfo(Room room);
    /**
     * 更新记录（根据租赁信息更新房间的业主）
     *
     * @param lease 需要更新的记录对象
     * @return int类型，更新操作影响的记录条数，为0时更新失败，否则更新成功
     */
    @Update("UPDATE roomInfo SET owner=#{owner} WHERE roomNumber=#{roomNumber} and buildingName=#{buildingName}")
    public int updateRoomInfoOwner(Lease lease);
    /**
     * 更新记录（更新房间的业主为空闲）
     *
     * @param lease 需要更新的记录对象
     * @return int类型，更新操作影响的记录条数，为0时更新失败，否则更新成功
     */
    @Update("UPDATE roomInfo SET owner=#{owner} WHERE roomNumber=#{roomNumber} and buildingName=#{buildingName}")
    public int deleteRoomInfoOwner(Lease lease);
    /**
     * 查询是否存在重复记录（执行插入记录操作时）
     *
     * @param room 需要查询是否存在的记录对象
     * @return int类型，满足查询条件的记录条数，为0时不存在重复记录，否则存在重复记录
     */
    @Select("select count(*) from roomInfo " +
            "where state != -1 " +
            "and buildingName = #{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertSearchSame(Room room);
    /**
     * 查询是否存在重复记录（执行更新记录操作时）
     * @param room 需要查询是否存在的记录对象
     * @return int类型，满足查询条件的记录条数，为0时不存在重复记录，否则存在重复记录
     */
    @Select("SELECT COUNT(*) FROM (SELECT * FROM roomInfo WHERE id NOT in (SELECT id FROM roomInfo WHERE state != -1 AND id = #{id})) AS temp WHERE state != -1 AND roomNumber = #{roomNumber} AND buildingName = #{buildingName}")
    public int updateSearchSame(Room room);
}
