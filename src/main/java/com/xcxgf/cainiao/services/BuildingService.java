package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.mapper.BuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 办公楼管理，后端与数据库的逻辑处理层
 */
@Service
public class BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    /**
     * 获取所有可用记录
     *
     * @return Building类型的集合，所有可用记录
     */
    public List<Building> getBuildingList() {
        return buildingMapper.getBuildingList();
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
        dataReturn.setBuildingList(buildingMapper.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(buildingMapper.getSearchCount(searchStr));
        return dataReturn;
    }

    /**
     * 更新记录
     *
     * @param building 需要被更新的记录对象
     * @return int类型，更新操作的状态，0为更新失败，-1为存在重复数据，1为更新成功
     */
    public int updateBuildingList(Building building) {
        int reqCode = 0;
        if (buildingMapper.updateSearchSame(building) != 0) {
            reqCode = -1;
        } else if (buildingMapper.updateBuildingInfo(building) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 删除记录
     *
     * @param building 需要被删除的记录对象
     * @return int类型，删除操作的状态，0为删除失败，1为删除成功
     */
    public int deleteBuildingList(Building building) {
        int reqCode = 0;
        if (buildingMapper.deleteBuildingInfo(building) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 插入记录
     *
     * @param building 需要被插入的记录对象
     * @return int类型，插入操作的状态，0为插入失败，-1为存在重复数据，1为插入成功
     */
    public int insertBuildingList(Building building) {
        int reqCode = 0;
        if (buildingMapper.insertSearchSame(building) != 0) {
            reqCode = -1;
        } else if (buildingMapper.insertBuildingInfo(building) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    /**
     * 批量插入记录
     *
     * @param buildingList 需要被插入的记录对象集合
     * @return int类型，插入操作的状态，-1为表内无数据，-2为全部重复，0为插入失败，否则返回成功条数
     */
    public int insertBuildingListAll(List<Building> buildingList) {
        int reqCode = 0;
        int sameCount = 0;
        // 先判空
        if (buildingList.size() != 0) {
            // 判断是否重复，再执行插入记录操作
            for (Building building : buildingList) {
                if (buildingMapper.insertSearchSame(building) != 0) {
                    sameCount += 1;
                } else if (buildingMapper.insertBuildingInfo(building) > 0) {
                    reqCode += 1;
                }
            }
            if (sameCount == buildingList.size()) {
                reqCode = -2;
            }
        } else {
            reqCode = -1;
        }
        return reqCode;
    }
}
