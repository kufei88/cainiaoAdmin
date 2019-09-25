package com.xcxgf.cainiao.controller;


import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.POJO.ReturnData;
import com.xcxgf.cainiao.POJO.SystemInfo;
import com.xcxgf.cainiao.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService ps;


    //查询公司
    @GetMapping("/getEnterpriseNumber")
    public String getEnterpriseNumber(HttpServletRequest request){
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        return ps.getEnterpriseNumber(building,room);
    }

    //查询房间
    @GetMapping("/getRoomList")
    public List<Long> RoomList(HttpServletRequest request){
        String building = request.getParameter("building");
        return ps.getRoomList(building);
    }

    //查询楼栋
    @GetMapping("/getBuildingList")
    public List<String> BuilingList(){
       return ps.getBuilingList();
    }

    //增加表格数据
    @PostMapping("/insertPaymentData")
    public int insert(@RequestBody PaymentInfo paymentInfo) {
        float water,electricity;
        SystemInfo systemInfo= ps.getSystemInfo();
        water = systemInfo.getWaterUnitPrice();
        electricity = systemInfo.getElectricityUnitPrice();
        return ps.insert(paymentInfo,water,electricity);
    }

    //导入Excel
    @PostMapping("/insertPaymentDataExcel")
    public ReturnData insertExcel(@RequestBody List<PaymentInfo> paymentInfo) {
        int flag=0,i=0,j=0;
        int T;
        float water,electricity;
        ReturnData returnData = new ReturnData();
        List<PaymentInfo> addList = new ArrayList<>();
        List<PaymentInfo> updateList=new ArrayList<>();

        SystemInfo systemInfo= ps.getSystemInfo();
        water = systemInfo.getWaterUnitPrice();
        electricity = systemInfo.getElectricityUnitPrice();
        if (ps.tableIsNull()>=1){

            for (PaymentInfo pi:paymentInfo)
            {
                T = ps.insert(pi,water,electricity);
                i++;
                if (T==1){
                    if (i==paymentInfo.size()){
                        flag=1;
                        returnData.setExcelFlag(flag);
                    }
                }
                if(T==0){
                    j++;
                    if (i==paymentInfo.size()){
                        returnData.setErrorCount(j);
                    }
                }
            }
        }else {
            ps.batInfoAdd(paymentInfo);
        }

        return returnData;
    }

    //系统设置是否有数据
    @GetMapping("/systemInfoIsNull")
    public int systemInfoIsNull(){
        return ps.systemInfoIsNull();
    }

    //新增系统设置单价
    @PostMapping("/addSystemInfo")
    public int insertSystemInfo(@RequestBody SystemInfo systemInfo){
        return ps.insertSystemInfo(systemInfo);
    }

    //查询系统设置单价
    @GetMapping("/getSystemInfoList")
    public List<SystemInfo> getSystemInfoList(){
        return ps.getSystemInfoList();
    }

    //更新系统设置单价
    @PostMapping("/updateSystemInfo")
    public int updateSystemInfo(@RequestBody SystemInfo systemInfo) {
        return ps.updateSystemInfo(systemInfo);
    }

    //查询所有年份
    @GetMapping("/getYearsList")
    public List<Long> getYearsList(){
        return ps.getYearsList();
    }

    //查询年份水费
    @GetMapping("/getYearsWaterCostList")
    public List<Float> getYearsWaterCostList(){
        return ps.getYearsWaterCostList();
    }

    //查询年份电费
    @GetMapping("/getYearsElectricityCostList")
    public List<Float> getYearsElectricityCostList(){
        return ps.getYearsElectricityCostList();
    }

    //查询本年月份
    @GetMapping("/getMonthList")
    public List<Long> getMonthList(){
        return ps.getMonthList();
    }

    //查询本年月份水费
    @GetMapping("/getMonthWaterCostList")
    public List<Float> getMonthWaterCostList(){

        return ps.getMonthWaterCostList();
    }

    //查询本年月份电费
    @GetMapping("/getMonthElectricityCostList")
    public List<Float> getMonthElectricityCostList(){

        return ps.getMonthElectricityCostList();
    }

    //查询本年季度
    @GetMapping("/getQuarterList")
    public List<Long> getQuarterList(){
        return ps.getQuarterList();
    }

    //查询本年季度水费
    @GetMapping("/getQuarterWaterCostList")
    public List<Float> getQuarterWaterCostList(){
        return ps.getMonthWaterCostList();
    }

    //查询本年季度电费
    @GetMapping("/getQuarterElectricityCostList")
    public List<Float> getQuarterElectricityCostList(){
        return ps.getQuarterElectricityCostList();
    }

    /**
     *查询表格数据
     * @param request request中包含3个参数，dataStart（返回数据的起始位置），dataEnd（返回数据的终止位置）
     * @return
     */
    @GetMapping("/getPaymentList")
    public ReturnData getSearchList(HttpServletRequest request) {
        // 从request中获取各参数
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String limit = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;

        return ps.getPaymentList(limit);
    }
}
