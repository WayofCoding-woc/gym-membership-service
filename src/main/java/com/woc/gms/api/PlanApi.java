package com.woc.gms.api;

import com.woc.gms.dto.PlanDTO;
import com.woc.gms.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class PlanApi {

    @Autowired
    private PlanService planService;

    @GetMapping("/plan/all")
    public List<PlanDTO> getAllPlans(){
        return planService.getAllPlans();
    }


    
}
