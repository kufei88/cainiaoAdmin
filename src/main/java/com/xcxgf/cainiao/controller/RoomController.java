package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomService rs;

    @RequestMapping(method = RequestMethod.GET,value = "/getRoomList")
    public List<Room> getRoomList(){
        return rs.getRoomList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deleteRoomList")
    public List<Room> deleteRoomList(@RequestBody Room room){
        rs.deleteRoomList(room);
        return rs.getRoomList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertRoomList")
    public List<Room> insertRoomList(@RequestBody Room room){
        rs.insertRoomList(room);
        return rs.getRoomList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateRoomList")
    public List<Room> updateRoomList(@RequestBody Room room){
        rs.updateRoomList(room);
        return rs.getRoomList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/uploadRoomList")
    public List<Room> uploadRoomList(@RequestBody List<Room> roomList){
        rs.uploadRoomList(roomList);
        return rs.getRoomList();
    }

}
