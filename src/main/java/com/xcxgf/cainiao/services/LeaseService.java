package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.*;
import com.xcxgf.cainiao.mapper.LeaseMapper;
import com.xcxgf.cainiao.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 租赁管理，后端与数据库的逻辑处理层
 */
@Service
public class LeaseService {
    @Autowired
    private LeaseMapper lm;

    @Autowired
    private RoomMapper rm;

    /**
     * 查询满足查询条件的记录
     *
     * @param search 查询内容:楼栋名称（模糊查询），房间名称（精确查询），业主（模糊查询）
     * @param start  记录开始位置
     * @param count  需要返回的记录条数
     * @return
     */
    public DataReturn getSearchList(String search, String start, String count) {
        // 拼接查询字符串，limit字符串
        String searchStr = "".equals(search) ? "" : "where (buildingName like '%" + search + "%' or roomNumber = '" + search + "' or owner like '%" + search + "%')";
        String limitStr = "0".equals(start) && "0".equals(count) ? "" : "limit " + start + "," + count;

        DataReturn dataReturn = new DataReturn();
        dataReturn.setLeaseList(lm.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(lm.getSearchCount(searchStr));
        return dataReturn;
    }

    /**
     * 获取所有可用记录
     *
     * @return Lease类型的集合，所有可用记录
     */
    public List<Lease> getLeaseList() {
        return lm.getLeaseList();
    }

    /**
     * 删除记录
     *
     * @param lease 需要被删除的记录对象
     * @return int类型，0为删除失败，1为删除成功
     */
    public int deleteLeaseList(Lease lease) {
        int reqCode = 0;
        if (lm.deleteLeaseInfo(lease) > 0 && rm.deleteRoomInfoOwner(lease) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 插入记录（首租）
     *
     * @param lease 需要插入的记录对象
     * @return int类型，0为插入失败，1为插入成功，-1为存在重复数据
     */
    public int insertLeaseListFirst(Lease lease) {
        lease = leaseDataFormat(lease);
        int reqCode = 0;
        if (lm.insertSearchSame(lease) != 0) {
            reqCode = -1;
        } else if (lm.insertLeaseInfoFirst(lease) > 0 && rm.updateRoomInfoOwner(lease) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 更新记录
     *
     * @param lease 需要被更新的记录对象
     * @return int类型，0为更新失败，1为更新成功，-1为存在重复数据
     */
    public int updateLeaseList(Lease lease) {
        int reqCode = 0;
        if (lm.insertSearchSame(lease) != 0) {
            reqCode = -1;
        } else if (lm.updateLeaseInfo(lease) > 0 && rm.updateRoomInfoOwner(lease) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 批量插入记录
     *
     * @param leaseList 需要被插入的记录对象集合
     * @return int类型，插入操作的状态，-1为表内无数据，-2为全部重复，0为插入失败，否则返回成功条数
     */
    public int uploadLeaseList(List<Lease> leaseList) {
        int reqCode = 0;
        int sameCount = 0;
        // 先判空
        if (leaseList.size() != 0) {
            // 判断是否重复，再执行插入记录操作
            for (Lease lease : leaseList) {
                if (lm.insertSearchSame(lease) != 0) {
                    sameCount += 1;
                } else if (lm.insertLeaseInfo(lease) > 0 && rm.updateRoomInfoOwner(lease) > 0) {
                    reqCode += 1;
                }
            }
            if (sameCount == leaseList.size()) {
                reqCode = -2;
            }
        } else {
            reqCode = -1;
        }
        return reqCode;
    }

    /**
     * 更新记录（续租）
     *
     * @param lease      需要被更新的记录对象
     * @param rentNumber 续租的租期期数
     * @return int类型，0为更新失败，1为更新成功
     */
    public int insertLeaseListContinue(Lease lease, int rentNumber) {
        int reqCode = 0;
        switch (rentNumber) {
            case 2:
                if (lm.insertLeaseInfoContinueTwo(lease) > 0) {
                    reqCode = 1;
                }
                break;
            case 3:
                if (lm.insertLeaseInfoContinueThree(lease) > 0) {
                    reqCode = 1;
                }
                break;
            case 4:
                if (lm.insertLeaseInfoContinueFour(lease) > 0) {
                    reqCode = 1;
                }
                break;
            case 5:
                if (lm.insertLeaseInfoContinueFive(lease) > 0) {
                    reqCode = 1;
                }
                break;
            case 6:
                if (lm.insertLeaseInfoContinueSix(lease) > 0) {
                    reqCode = 1;
                }
                break;
            default:
                break;
        }

        return reqCode;
    }

    /**
     * 日期格式化
     *
     * @param lease 需要被格式化日期数据的记录对象
     * @return lease类型，日期格式化完成的记录对象
     */
    public Lease leaseDataFormat(Lease lease) {
        // 日期格式化的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(lease.getStartRentTime());
            Date end = dateFormat.parse(lease.getEndRentTime());
            lease.setStartRentTime(dateFormat.format(start));
            lease.setEndRentTime(dateFormat.format(end));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lease;
    }

    /**
     * 查询所有办公楼
     *
     * @return
     */
    public List<Building> getBuildingList() {
        return lm.getBuildingList();
    }

    /**
     * 获取所有未租赁的可用记录
     *
     * @return Room类型的集合，所有未租赁的可用记录
     */
    public List<Room> getEmptyRoomList() {
        return lm.getEmptyRoomList();
    }

    /**
     * 获取所有已租赁的可用记录
     *
     * @return Room类型的集合，所有已租赁的可用记录
     */
    public List<Room> getContinueRoomList() {
        return lm.getContinueRoomList();
    }

    /**
     * 获取所有可用数据
     * @return Setting类型，所有可用数据
     */
    public String getSettingList(){
        return lm.getSettingList();
    }
}
