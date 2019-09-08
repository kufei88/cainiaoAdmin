package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Dorms;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DormMapper {
    @Select("select * from dorms where isfull=false and domitoryId=#{domitoryId} limit #{start},5")
    public List<Dorms> getDormList(int domitoryId,int start);

    @Select("select count(*) from dorms where isfull=false and domitoryId=#{domitoryId}")
    public int getCountByDId(int domitoryId);

    @Select("select count(*) from dorms where isfull=false and domitoryId=#{domitoryId} and dromNum=#{dromNum}")
    public int selectRepeat(int domitoryId,String dromNum);

    @Select(("select * from dorms where htid=#{htid} and domitoryId=#{domitoryId}"))
    public List<Dorms> selectDroms(String htid,int domitoryId);

    @Update("update dorms set htId=#{htId},isfull=true where id=#{id}")
    public int Updatedroms(Dorms dorms);

    @Update("update dorms set htId=#{htId},isfull=true where domitoryId=#{domitoryId} and dromNum=#{dromNum}")
    public int Updatedroms2(String htId,int domitoryId,String dromNum);

    @Update("update dorms set htId=0,isfull=false where domitoryId=#{domitoryId} and htId=#{htId}")
    public int Updatedroms3(int domitoryId,String htId);

    @Insert("insert into dorms(domitoryId,dromNum) " +
            "values(#{domitoryId},#{dormNum})")
    public int AddDorms(int domitoryId,String dormNum);


}
