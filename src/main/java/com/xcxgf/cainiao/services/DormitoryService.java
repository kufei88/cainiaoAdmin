package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Dormitory;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.mapper.DormitoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DormitoryService {
    @Autowired
    DormitoryMapper dormitoryMapper;
    public List<Dormitory> getDormitoryList(){return dormitoryMapper.getDormitoryList();}
}
