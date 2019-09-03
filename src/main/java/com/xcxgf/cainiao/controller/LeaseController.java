package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Lease;
import com.xcxgf.cainiao.services.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("lease")
public class LeaseController {

    @Autowired
    private LeaseService ls;

    @RequestMapping(method = RequestMethod.GET,value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        String search = request.getParameter("search");
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        String searchStr = "".equals(search) ? "" : "and (buildingName like '%" + search +"%' or roomNumber like '%"+search+"%' or owner like '%"+search+ "%')";
        String limitStr = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit "+start+","+end;

        return ls.getSearchList(searchStr,limitStr);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLeaseList")
    public List<Lease> getLeaseList() {
        return ls.getLeaseList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteLeaseList")
    public int deleteLeaseList(@RequestBody Lease lease) {

        return ls.deleteLeaseList(lease);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateLeaseList")
    public int updateLeaseList(@RequestBody Lease lease) {
        return ls.updateLeaseList(lease);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insertLeaseList")
    public int insertLeaseList(@RequestBody Lease lease) {
        return ls.insertLeaseList(lease);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uploadLeaseList")
    public int uploadLeaseList(@RequestBody List<Lease> lease) {
        return ls.uploadLeaseList(lease);
    }
}
