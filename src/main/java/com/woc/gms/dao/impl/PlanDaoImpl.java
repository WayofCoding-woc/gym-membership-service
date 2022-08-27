package com.woc.gms.dao.impl;

import com.woc.gms.dao.PlanDao;
import com.woc.gms.dto.PlanDTO;
import com.woc.gms.jpa.entity.Plan;
import com.woc.gms.jpa.repo.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanDaoImpl implements PlanDao {

    @Autowired
    private PlanRepository planRepository;
    @Override
    public List<PlanDTO> getAllPlans() {
        List<Plan> allPlans = planRepository.findAll();
        return allPlans
                .stream()
                .map(e->{
                        PlanDTO dto = new PlanDTO();
                        dto.setId(e.getId());
                        dto.setName(e.getName());
                        dto.setValidity(e.getValidity());
                        dto.setPrice(e.getPrice());
                        dto.setDiscount(e.getDiscount());
                        dto.setFinalPrice(e.getFinalPrice());
                        return dto;
                     })
                .collect(Collectors.toList());
    }
}
