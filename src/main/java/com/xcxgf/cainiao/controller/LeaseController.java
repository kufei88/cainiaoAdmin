package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.Lease;
import com.xcxgf.cainiao.services.LeaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lease")
public class LeaseController {

    private LeaseService ls;

    @RequestMapping(method = RequestMethod.GET,value = "/getLeaseList")
    public List<Lease> getLeaseList(){
        return ls.getLeaseList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/deleteLeaseList")
    public List<Lease> deleteLeaseList(Lease lease){
        ls.deleteLeaseList(lease);
        return ls.getLeaseList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateLeaseList")
    public List<Lease> updateLeaseList(Lease lease){
        ls.updateLeaseList(lease);
        return ls.getLeaseList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/insertLeaseList")
    public List<Lease> insertLeaseList(Lease lease){
        ls.insertLeaseList(lease);
        return ls.getLeaseList();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/uploadLeaseList")
    public List<Lease> uploadLeaseList(List<Lease> lease){
        ls.uploadLeaseList(lease);
        return ls.getLeaseList();
    }
}
