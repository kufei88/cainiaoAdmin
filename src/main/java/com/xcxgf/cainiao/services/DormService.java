package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Dorms;
import com.xcxgf.cainiao.mapper.DormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class DormService {
    @Autowired
    DormMapper dormMapper;

    public List<Dorms> getDormList(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("dormid"));
        int page=(Integer.parseInt(request.getParameter("pagedom"))-1)*5;
        return dormMapper.getDormList(id,page);
    }

    public int getCountByDId(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("dormid"));
        return dormMapper.getCountByDId(id);
    }
    public int Updatedroms( Dorms dorms){
        return dormMapper.Updatedroms(dorms);
    }

    public List<Dorms>selectDroms(String htid,int domitoryId){
        return dormMapper.selectDroms(htid,domitoryId);
    }
    public int AddDorms(int domitoryId,String dormNum){
        return dormMapper.AddDorms(domitoryId,dormNum);
    }
}
