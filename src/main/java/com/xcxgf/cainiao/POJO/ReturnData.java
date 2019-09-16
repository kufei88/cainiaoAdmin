package com.xcxgf.cainiao.POJO;

import java.util.List;

public class ReturnData {
    private int dataCount; // 查询到的记录总条数
    private List<PaymentInfo> paymentInfos; //水电读数集合
    private int errorCount;//错误条数
    private int excelFlag;//Excel状态

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public int getExcelFlag() {
        return excelFlag;
    }

    public void setExcelFlag(int excelFlag) {
        this.excelFlag = excelFlag;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public List<PaymentInfo> getPaymentInfos() {
        return paymentInfos;
    }

    public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
        this.paymentInfos = paymentInfos;
    }


}
