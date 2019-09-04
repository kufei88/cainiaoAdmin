package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Room;
import com.xcxgf.cainiao.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 办公室管理，后端与数据库的逻辑处理层
 */
@Service
public class RoomService {
    @Autowired
    private RoomMapper rm;

    /**
     * 获取所有未租赁的可用记录
     * @return Room类型的集合，所有未租赁的可用记录
     */
    public List<Room> getRoomList() {
        return rm.getRoomList();
    }

    /**
     * 获取所有已租赁的可用记录
     * @return Room类型的集合，所有已租赁的可用记录
     */
    public List<Room> getRoomListContinue() {
        return rm.getRoomListContinue();
    }

    /**
     * 获取指定位置的满足查询条件的可用记录
     *
     * @param searchStr 查询条件
     * @param limitStr  指定位置
     * @return DataReturn类型的对象，满足条件的记录的数据包装
     */
    public DataReturn getSearchList(String searchStr, String limitStr) {
        DataReturn dataReturn = new DataReturn();
        dataReturn.setRoomList(rm.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(rm.getSearchCount(searchStr));
        return dataReturn;
    }

    /**
     * 删除记录
     * @param room 需要被删除的记录对象
     * @return int类型，0为删除失败，1为删除成功
     */
    public int deleteRoomList(Room room) {
        int reqCode = 0;
        if (rm.deleteRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 插入记录
     * @param room 需要被插入的记录对象
     * @return int类型，0为插入失败，1为插入成功
     */
    public int insertRoomList(Room room) {
        int reqCode = 0;
        if (rm.insertSearchSame(room) != 0) {
            reqCode = -1;
        } else if (rm.insertRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 更新记录
     * @param room 需要被更新的记录对象
     * @return int类型，0为更新失败，-1为已存在重复数据，1为更新成功
     */
    public int updateRoomList(Room room) {
        int reqCode = 0;
        if (rm.updateSearchSame(room) != 0) {
            reqCode = -1;
        } else if (rm.updateRoomInfo(room) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }
    /**
     * 批量插入记录
     *
     * @param roomList 需要被插入的记录对象集合
     * @return int类型，插入操作的状态，-1为表内无数据，-2为全部重复，0为插入失败，否则返回成功条数
     */
    public int uploadRoomList(List<Room> roomList) {
        int reqCode = 0;
        int sameCount = 0;
        // 先判空
        if (roomList.size() != 0) {
            // 判断是否重复，再执行插入记录操作
            for (Room room : roomList) {
                if (rm.insertSearchSame(room) != 0) {
                    sameCount += 1;
                } else if (rm.insertRoomInfo(room) > 0) {
                    reqCode += 1;
                }
            }
            if (sameCount == roomList.size()) {
                reqCode = -2;
            }
        } else {
            reqCode = -1;
        }
        return reqCode;
    }
}
