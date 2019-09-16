package com.xcxgf.cainiao.controller;

import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.POJO.ReturnData;
import com.xcxgf.cainiao.POJO.SystemInfo;
import com.xcxgf.cainiao.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import java.util.List;


@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService ps;


    //新增
    @GetMapping("/addHydropowerPaymentData")
    public int insertHydropowerPaymentData(@RequestBody SystemInfo systemInfo){
        return ps.insertHydropowerPaymentData(systemInfo);
    }

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
//        System.out.println(ps.getRoomList(building));
        return ps.getRoomList(building);
    }

    //查询楼栋
    @GetMapping("/getBuildingList")
    public List<String> BuilingList(){
       return ps.getBuilingList();
    }

    //更新
    @PostMapping("/updatePaymentData")
    public int update(@RequestBody PaymentInfo paymentInfo) {
       return ps.update(paymentInfo);
    }


    //增加
    @PostMapping("/insertPaymentData")
    public int insert(@RequestBody PaymentInfo paymentInfo) {return ps.insert(paymentInfo); }


    //增加
    @PostMapping("/insertPaymentDataExcel")
    public ReturnData insertExcel(@RequestBody List<PaymentInfo> paymentInfo) {
        int flag=0,i=0,j=0;
        ReturnData returnData = new ReturnData();
        for (PaymentInfo pi:paymentInfo)
        {
            i++;
            if (ps.insert(pi)==1){
                if (i==paymentInfo.size()){
                    flag=1;
                    returnData.setExcelFlag(flag);
                }
            }
            if(ps.insert(pi)==0){
                j++;
                if (i==paymentInfo.size()){
                    returnData.setErrorCount(j);
                }
            }
            if (ps.insert(pi)==2){
                j++;
                if (i==paymentInfo.size()){
                    flag=2;
                    returnData.setErrorCount(j);
                    returnData.setExcelFlag(flag);
                }
            }
        }
        return returnData;
    }


    //删除
    @PostMapping("/deletePaymentData")
    public int delete(@RequestBody PaymentInfo paymentInfo) {
       return ps.delete(paymentInfo);
    }
    //删除all
    @PostMapping("/deletePaymentDataAll")
    public void deleteAll() {
        ps.deleteAll();
    }

    //查询上期
    @GetMapping("/getPreviousPaymentList")
    public ReturnData getPreviousPaymentList(HttpServletRequest request){
        // 从request中获取各参数
        String startStr = request.getParameter("dataStart");
        String endStr = request.getParameter("dataEnd");
        int start = Integer.parseInt(startStr);
        int end = Integer.parseInt(endStr);
        // 拼接查询字符串，limit字符串
        String limit = "0".equals(startStr) && "0".equals(endStr) ? "" : "limit " + start + "," + end;
        return ps.getPreviousPaymentList(limit);
    }

    //查询水电价格
    @GetMapping("/getHydropowerPaymentList")
    public List<SystemInfo> getHydropowerPaymentList(){
        return ps.getHydropowerPaymentList();
    }

    //更新水电价格
    @PostMapping("/updateHydropowerPaymentData")
    public int updateHydropower(@RequestBody SystemInfo systemInfo) {
        return ps.updateHydropower(systemInfo);
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
     *
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
