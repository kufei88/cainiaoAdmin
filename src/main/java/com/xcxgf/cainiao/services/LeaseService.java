package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Lease;
import com.xcxgf.cainiao.mapper.LeaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseService {
    @Autowired
    private LeaseMapper lm;

    public List<Lease> getLeaseList(){
        return lm.getLeaseList();
    }

    public List<Lease> deleteLeaseList(Lease lease){
        lm.deleteLeaseInfo(lease);
        return lm.getLeaseList();
    }

    public List<Lease> insertLeaseList(Lease lease){
        lm.insertLeaseInfo(lease);
        return lm.getLeaseList();
    }

    public List<Lease> updateLeaseList(Lease lease){
        lm.updateLeaseInfo(lease);
        return lm.getLeaseList();
    }
    public List<Lease> uploadLeaseList(List<Lease> leaseList){
        for (Lease lease:leaseList) {
            lm.insertLeaseInfo(lease);
        }
        return lm.getLeaseList();
    }
}
