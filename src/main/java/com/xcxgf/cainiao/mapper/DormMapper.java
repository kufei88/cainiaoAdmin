package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Dorms;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DormMapper {
    @Select("select * from dorms where isfull=false and domitoryId=#{domitoryId} limit #{start},5")
    public List<Dorms> getDormList(int domitoryId,int start);

    @Select("select count(*) from dorms where isfull=false and domitoryId=#{domitoryId}")
    public int getCountByDId(int domitoryId);

    @Update("update dorms set htId=#{htId},isfull=true where id=#{id}")
    public int Updatedroms(Dorms dorms);
}
