package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.RoomType;
import com.xcxgf.cainiao.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("RoomType")
public class RoomTypeController {
    @Autowired
    RoomTypeService roomTypeService;
    @RequestMapping(method = RequestMethod.GET,value = "/getRoomTypes")
    public List<RoomType> getRoomType(){
        return roomTypeService.getRoomType();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertRoomType")
    public int insertRoomType(@RequestBody RoomType roomType){
        return roomTypeService.insertRoomType(roomType);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/deleteRoomType")
    public int deleteRoomType(@RequestBody RoomType roomType){
        return roomTypeService.deleteRoomType(roomType);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateMonthRent")
    public int updateMonthRent(@RequestBody RoomType roomType){
        return roomTypeService.updateMonthRent(roomType);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getMonthRent")
    public float getMonthRent(@RequestBody RoomType roomTypes){
        return roomTypeService.getMonthRent(roomTypes);
    }
}
