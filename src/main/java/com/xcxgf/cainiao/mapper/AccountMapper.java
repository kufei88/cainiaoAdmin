package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {
    //查询
   @Select("select * from dormitoryfirstinfo limit 0,10")
   public List<Account> getAccountList0();
    //分页查询
    @Select("select * from dormitoryfirstinfo limit #{start},#{pagesize}")
    public List<Account> getAccountList(int start,int pagesize);

    //搜索
    @Select("select * from dormitoryfirstinfo where owner like CONCAT('%',#{name},'%') " +
            "limit #{spg},#{spgsize}")
    public List<Account> getAccountNameList(String name,int spg,int spgsize);

    @Select("select count(*) from dormitoryfirstinfo where owner like CONCAT('%',#{name},'%')")
    public int getAccountNameCount(String name);


    @Select("select * from enterpriseinfo where enterpriseName=#{enterpriseName}")
    public List<Enterprise> getOwnerList(String enterpriseName);
    //根据合同号查询
    @Select("select * from dormitoryfirstinfo where id=#{id}")
    public List<Account> getAccountIdList(int id);

    //查询合同总条数
    @Select("select count(*) from dormitoryfirstinfo")
    public int getAccountCount();
    //更新
    @Update("update dormitoryfirstinfo set " +
            "owner=#{owner}," +
            "buildingName=#{buildingName}," +
            "insertTime=#{insertTime}," +
            "startRentTime=#{startRentTime}," +
            "endRentTime=#{endRentTime}," +
            "totalPeriod=#{totalPeriod}," +
            "totalCost=#{totalCost} " +
            "where id=#{id}")
    public int updateAccount(Account entityAccount);

    //插入
    @Insert("insert into dormitoryfirstinfo(owner," +
            "buildingName," +
            "startRentTime," +
            "endRentTime," +
            "rentPeriod," +
            "totalCost," +
            "totalPeriod," +
            "insertTime) " +
            "values(#{owner}," +
            "#{buildingName}," +
            "#{startRentTime}," +
            "#{endRentTime}," +
            "#{rentPeriod}," +
            "#{totalCost}," +
            "#{rentPeriod}," +
            "#{insertTime})")
    public int insertAccount(Account entityAccount);

    @Delete("delete from dormitoryfirstinfo where id=#{id}")
    public int deleteAccount(int id);

    @Update("update dormitoryfirstinfo set totalPeriod=totalPeriod+#{addNum} where id=#{id}")
    public int updateleasePeriod(int addNum,int id);

    //查询宿舍楼栋
    @Select("select * from buildingInfo where buildingType='宿舍'")
    public List<Building> getBuildingList();

    //查询房间号
    @Select("select * from roominfo where owner='空闲' and buildingName=#{buildingName} limit #{start},5")
    public List<Room> getRoomList(String buildingName, int start);

    @Select("select count(*) from roominfo where owner='空闲' and buildingName=#{buildingName}")
    public int getRoomListCount(String buildingName);
    //合同新增更新
    @Update("update roominfo set owner=#{owner} where buildingName=#{buildingName} and roomNumber=#{roomNumber}")
    public int updateRoom(Room room);

    //删除更新
    @Update("update roominfo set owner='空闲' where buildingName=#{buildingName} and owner=#{owner}")
    public int updateRoom2(Room room);

    @Select("select * from roominfo where owner=#{owner} and buildingName=#{buildingName} limit #{start},5")
    public List<Room> getRoomList2(String owner,String buildingName, int start);

    @Select("select count(*) from roominfo where owner=#{owner} and buildingName=#{buildingName}")
    public int getRoomListCount2(String owner,String buildingName);
    //查询宿舍
    @Select("select count(*) from buildinginfo where buildingType='宿舍' and buildingName=#{buildingName}")
    public int getBuildingListCount(String buildingName);
    //
    @Select("select count(*) from roominfo where roomNumber=#{roomNumber} and buildingName=#{buildingName}")
    public int getRoomListCount3(String roomNumber,String buildingName);

}


