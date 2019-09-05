package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Dormitory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DormitoryMapper {
<<<<<<< HEAD
    @Select("select * from dormitory where isdelete=false")
=======
    @Select("select * from dormitory where isfull=false")
>>>>>>> 8ce3b59e0e10b66368e77315b5469cea0f70bbf4
    public List<Dormitory> getDormitoryList();

}
