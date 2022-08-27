package com.woc.gms.service;

import com.woc.gms.dto.CustomerDTO;
import com.woc.gms.dto.PlanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomerDataService {
    private CustomerService customerService;
    private PlanService planService;

    //@Autowired
    public CustomerDataService(CustomerService customerService, PlanService planService){
        this.customerService = customerService;
        this.planService = planService;
    }

    public Map<String, Object> getData(String email){
        Map<String, Object> data = new HashMap<>();
        CustomerDTO customer = customerService.getCustomerByEmail(email);
        List<PlanDTO> allPlans = planService.getAllPlans();
        data.put("customer", customer);
        data.put("allAvailablePlans", allPlans);
        return data;
    }


}
