package com.xcxgf.cainiao.mapper;


import com.xcxgf.cainiao.POJO.PaymentInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PaymentMapper {
    @Select("select * from paymentInfo")
    public List<PaymentInfo> getPaymentList();

    @Insert("insert into paymentInfo( WaterNumber, ElectricityNumber) values(#{WaterNumber}, #{ElectricityNumber})")
    public int insertPaymentInfo(@Param("WaterNumber")String WaterNumber,@Param("ElectricityNumber")String ElectricityNumber);

    @Update({"update paymentInfo set WaterNumber = #{WaterNumber},ElectricityNumber = #{ElectricityNumber} where id = #{id}"})
    public int updatePaymentInfo(@Param("id")int id,@Param("WaterNumber")String WaterNumber,@Param("ElectricityNumber")String ElectricityNumber);

    @Delete({"delete from paymentInfo where id = #{id}"})
    public int deletePaymentInfo(@Param("id")int id);
}
