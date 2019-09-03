package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper rm;

    public List<Room> getRoomList() {
        return rm.getRoomList();
    }

    public DataReturn getSearchList(String searchStr, String limitStr) {
        DataReturn dataReturn = new DataReturn();
        dataReturn.setRoomList(rm.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(rm.getSearchCount(searchStr));
        return dataReturn;
    }

    public int deleteRoomList(Room room) {
        int reqCode = 0;
        if (rm.deleteRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int insertRoomList(Room room) {
        int reqCode = 0;
        if (rm.insertSearchSame(room) != 0) {
            reqCode = -1;
        } else if (rm.insertRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int updateRoomList(Room room) {
        int reqCode = 0;
        if (rm.updateSearchSame(room) != 0) {
            reqCode = -1;
        } else if (rm.updateRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int uploadRoomList(List<Room> roomList) {
        int reqCode = 0;
        for (Room room : roomList) {
            if (rm.insertRoomInfo(room) > 0) {
                reqCode += 1;
            }
        }
        return reqCode;
    }
}
