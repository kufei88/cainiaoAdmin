package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper rm;

    public List<Room> getRoomList(){
        return rm.getRoomList();
    }

    public List<Room> deleteRoomList(Room room){
        rm.deleteRoomInfo(room);
        return rm.getRoomList();
    }

    public List<Room> insertRoomList(Room room){
        rm.insertRoomInfo(room);
        return rm.getRoomList();
    }

    public List<Room> updateRoomList(Room room){
        rm.updateRoomInfo(room);
        return rm.getRoomList();
    }
}
