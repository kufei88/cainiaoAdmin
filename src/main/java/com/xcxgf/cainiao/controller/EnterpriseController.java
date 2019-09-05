package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Enterprise;
import com.xcxgf.cainiao.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 园区企业管理，前端后台交互层
 */
@RestController
@RequestMapping("enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService es;

    /**
     * 获取符合查询条件的园区企业数据
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
        String searchStr = "".equals(search) ? "" : "and (enterpriseName like '%" + search + "%' or enterprisePerson like '%" + search + "%')";
        String limitStr = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return es.getSearchList(searchStr, limitStr);
    }

    /**
     * 获取所有的园区企业的数据
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getEnterpriseList")
    public List<Enterprise> getEnterpriseList() {
        return es.getEnterpriseList();
    }

    /**
     * 删除记录
     *
     * @param enterprise 需要被删除的数据
     * @return 删除结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/deleteEnterpriseList")
    public int deleteEnterpriseList(@RequestBody Enterprise enterprise) {
        return es.deleteEnterpriseList(enterprise);
    }

    /**
     * 更新记录
     *
     * @param enterprise 需要被更新的数据
     * @return 更新结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateEnterpriseList")
    public int updateEnterpriseList(@RequestBody Enterprise enterprise) {
        return es.updateEnterpriseList(enterprise);
    }

    /**
     * 插入记录
     *
     * @param enterprise 需要被插入的数据
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/insertEnterpriseList")
    public int insertEnterpriseList(@RequestBody Enterprise enterprise) {
        return es.insertEnterpriseList(enterprise);
    }

    /**
     * 批量插入数据（上传数据）
     *
     * @param enterpriseList 需要被插入的数据的集合
     * @return 插入结果的状态值
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadEnterpriseList")
    public int uploadEnterpriseList(@RequestBody List<Enterprise> enterpriseList) {
        return es.uploadEnterpriseList(enterpriseList);
    }

}
