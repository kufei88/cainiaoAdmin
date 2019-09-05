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

/**
 * 租赁管理，前端后台交互层
 */
@RestController
@RequestMapping("lease")
public class LeaseController {

    @Autowired
    private LeaseService ls;

    /**
     * 获取符合查询条件的租赁信息数据
     *
     * @param request request中包含3个参数，search（查询内容），dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getSearchList")
    public DataReturn getSearchList(HttpServletRequest request) {
        // 从request中获取各参数
        String search = request.getParameter("search");
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String searchStr = "".equals(search) ? "" : "and (buildingName like '%" + search + "%' or roomNumber like '%" + search + "%' or owner like '%" + search + "%')";
        String limitStr = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return ls.getSearchList(searchStr, limitStr);
    }

    /**
     * 获得所有的租赁信息数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getLeaseList")
    public List<Lease> getLeaseList() {
        return ls.getLeaseList();
    }

    /**
     * 删除记录
     *
     * @param lease 需要被删除的数据
     * @return 删除结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/deleteLeaseList")
    public int deleteLeaseList(@RequestBody Lease lease) {

        return ls.deleteLeaseList(lease);
    }

    /**
     * 更新记录
     * @param lease 需要被更新的数据
     * @return 更新结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateLeaseList")
    public int updateLeaseList(@RequestBody Lease lease) {
        return ls.updateLeaseList(lease);
    }

    /**
     * 插入记录
     * @param lease 需要插入的数据
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insertLeaseList")
    public int insertLeaseList(@RequestBody Lease lease) {
        return ls.insertLeaseListFirst(lease);
    }

    /**
     * 插入记录（续租），根据数据中携带的rentNumber（租期期数）的值来分别进行插入操作
     * @param lease 需要被插入的数据
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insertLeaseListContinue")
    public int insertLeaseListContinue(@RequestBody Lease lease) {
        int reqCode = 0;
        switch (lease.getRentNumber()) {
            case "第2期":
                reqCode = ls.insertLeaseListContinue(lease, 2);
                break;
            case "第3期":
                reqCode = ls.insertLeaseListContinue(lease, 3);
                break;
            case "第4期":
                reqCode = ls.insertLeaseListContinue(lease, 4);
                break;
            case "第5期":
                reqCode = ls.insertLeaseListContinue(lease, 5);
                break;
            case "第6期":
                reqCode = ls.insertLeaseListContinue(lease, 6);
                break;
            default:
                break;
        }
        return reqCode;
    }

    /**
     * 批量插入记录（上传数据）
     * @param lease 需要被插入的数据的集合
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadLeaseList")
    public int uploadLeaseList(@RequestBody List<Lease> lease) {
        return ls.uploadLeaseList(lease);
    }
}
