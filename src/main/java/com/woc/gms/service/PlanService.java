package com.woc.gms.service;

import com.woc.gms.dao.PlanDao;
import com.woc.gms.dto.PlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {
    @Autowired
    private PlanDao planDao;


    public List<PlanDTO> getAllPlans() {
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        return planDao.getAllPlans();
    }
}
