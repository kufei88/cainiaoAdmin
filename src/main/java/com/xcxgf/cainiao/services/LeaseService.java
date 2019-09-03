package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Lease;
import com.xcxgf.cainiao.mapper.LeaseMapper;
import com.xcxgf.cainiao.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseService {
    @Autowired
    private LeaseMapper lm;

    @Autowired
    private RoomMapper rm;

    public DataReturn getSearchList(String searchStr, String limitStr) {
        DataReturn dataReturn = new DataReturn();
        dataReturn.setLeaseList(lm.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(lm.getSearchCount(searchStr));
        return dataReturn;
    }

    public List<Lease> getLeaseList() {
        return lm.getLeaseList();
    }

    public int deleteLeaseList(Lease lease) {
        int reqCode = 0;
        if (lm.deleteLeaseInfo(lease) > 0 && rm.deleteRoomInfoOwner(lease) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int insertLeaseList(Lease lease) {
        int reqCode = 0;
        if (lm.insertSearchSame(lease) != 0) {
            reqCode = -1;
        } else if (lm.insertLeaseInfo(lease) > 0 && rm.updateRoomInfoOwner(lease) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int updateLeaseList(Lease lease) {
        int reqCode = 0;
        if (lm.insertSearchSame(lease) != 0) {
            reqCode = -1;
        } else if (lm.updateLeaseInfo(lease) > 0 && rm.updateRoomInfoOwner(lease) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int uploadLeaseList(List<Lease> leaseList) {
        int reqCode = 0;
        for (Lease lease : leaseList) {
            if (lm.insertLeaseInfo(lease) > 0 && rm.updateRoomInfoOwner(lease) > 0) {
                reqCode = 1;
            }
        }
        return reqCode;
    }
}
