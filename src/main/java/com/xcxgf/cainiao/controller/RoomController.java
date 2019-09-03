package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomService rs;

    @RequestMapping(method = RequestMethod.GET, value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        String search = request.getParameter("search");
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        String searchStr = "".equals(search) ? "" : "and (buildingName like '%" + search + "%' or roomNumber like '%" + search + "%')";
        String limitStr = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return rs.getSearchList(searchStr, limitStr);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getRoomList")
    public List<Room> getRoomList() {
        return rs.getRoomList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteRoomList")
    public int deleteRoomList(@RequestBody Room room) {
        return rs.deleteRoomList(room);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertRoomList")
    public int insertRoomList(@RequestBody Room room) {
        return rs.insertRoomList(room);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateRoomList")
    public int updateRoomList(@RequestBody Room room) {
        return rs.updateRoomList(room);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uploadRoomList")
    public int uploadRoomList(@RequestBody List<Room> roomList) {
        return rs.uploadRoomList(roomList);
    }

}
