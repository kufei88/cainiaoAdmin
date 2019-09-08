package com.xcxgf.cainiao.POJO;

import java.util.List;

public class ReturnData {
    private int dataCount; // 查询到的记录总条数
    private List<PaymentInfo> paymentInfos; // 办公室记录集合
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
