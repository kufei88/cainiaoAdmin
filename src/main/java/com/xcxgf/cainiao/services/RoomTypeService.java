package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.POJO.RoomType;
import com.xcxgf.cainiao.mapper.RoomTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    RoomTypeMapper roomTypeMapper;
    public List<RoomType> getRoomType(){
        return roomTypeMapper.getRoomType();
    }
    public int insertRoomType(RoomType roomType){
        return roomTypeMapper.insertRoomType(roomType);
    }

    public int deleteRoomType(RoomType roomType){
        int id=roomType.getId();
        return roomTypeMapper.deleteRoomType(id);
    }

    public int updateMonthRent(RoomType roomType){
        return roomTypeMapper.updateMonthRent(roomType);
    }
    public float getMonthRent(RoomType roomType){
        String roomTypes=roomType.getRoomType();
        return roomTypeMapper.getMonthRent(roomTypes);
    }
}
