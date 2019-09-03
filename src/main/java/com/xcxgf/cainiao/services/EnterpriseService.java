package com.xcxgf.cainiao.services;

import com.xcxgf.cainiao.POJO.DataReturn;
import com.xcxgf.cainiao.POJO.Enterprise;
import com.xcxgf.cainiao.mapper.EnterpriseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseMapper em;

    public DataReturn getSearchList(String searchStr, String limitStr) {
        DataReturn dataReturn = new DataReturn();
        dataReturn.setEnterpriseList(em.getSearchList(searchStr, limitStr));
        dataReturn.setDataCount(em.getSearchCount(searchStr));
        return dataReturn;
    }


    public List<Enterprise> getEnterpriseList() {
        return em.getEnterpriseList();
    }


    public int deleteEnterpriseList(Enterprise enterprise) {
        int reqCode = 0;
        if (em.deleteEnterpriseInfo(enterprise) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int updateEnterpriseList(Enterprise enterprise) {
        int reqCode = 0;
        if (em.updateSearchSame(enterprise) != 0) {
            reqCode = -1;
        } else if (em.updateEnterpriseInfo(enterprise) > 0) {
            reqCode = 1;
        }
        return reqCode;
    }

    public int insertEnterpriseList(Enterprise enterprise) {
        int reqCode = 0;
        if (em.insertSearchSame(enterprise) != 0) {
            reqCode = -1;
        } else if (em.insertEnterpriseInfo(enterprise) > 0) {
            reqCode = 1;
        }
        return reqCode;

    }

    public int uploadEnterpriseList(List<Enterprise> enterpriseList) {
        int reqCode = 0;
        for (Enterprise enterprise : enterpriseList) {
            if (em.insertEnterpriseInfo(enterprise) > 0) {
                reqCode += 1;
            }
            ;
        }
        return reqCode;
    }
}
