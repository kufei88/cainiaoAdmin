package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.Enterprise;
import com.xcxgf.cainiao.mapper.EnterpriseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseMapper em;

    public List<Enterprise> getEnterpriseList(){
        return em.getEnterpriseList();
    }

    public List<Enterprise> deleteEnterpriseList(Enterprise enterprise){
        em.deleteEnterpriseInfo(enterprise);
        return em.getEnterpriseList();
    }

    public List<Enterprise> updateEnterpriseList(Enterprise enterprise){
        em.updateEnterpriseInfo(enterprise);
        return em.getEnterpriseList();
    }

    public List<Enterprise> insertEnterpriseList(Enterprise enterprise){
        em.insertEnterpriseInfo(enterprise);
        return em.getEnterpriseList();
    }
}
