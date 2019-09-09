package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.AddDomitory;
import com.xcxgf.cainiao.POJO.Dormitory;
import com.xcxgf.cainiao.mapper.AccountMapper;
import com.xcxgf.cainiao.mapper.DormitoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class DormitoryService {
    @Autowired
    DormitoryMapper dormitoryMapper;

    public List<Dormitory> getDormitoryList0(){
        return dormitoryMapper.getDormitoryList0();
    }

    public List<Dormitory> getDormitoryList(HttpServletRequest request){
        int start=(Integer.parseInt(request.getParameter("startpage"))-1)*10;
        //System.out.println(start);
        int pagesize=Integer.parseInt(request.getParameter("pagecount"));
        return dormitoryMapper.getDormitoryList(start,pagesize);
    }

    public int addNewDormitory(String dormitoryName,String money){
        return dormitoryMapper.addNewDormitory(dormitoryName,money);
    }

    public int Selectid(AddDomitory addDomitory){
        String dormitoryName=addDomitory.getDormitoryName();
        return dormitoryMapper.Selectid(dormitoryName);
    }

    public int updateDormitory(Dormitory dormitory){
        return dormitoryMapper.updateDormitory(dormitory);
    }

    public int deleteRow(Dormitory dormitory){
        int id=dormitory.getId();
        System.out.println(id);
        return dormitoryMapper.deleteRow(id);
    }

    public int getDormitoryCount(){
        return dormitoryMapper.getDormitoryCount();
    }
}
