package com.woc.gms.api;

import com.woc.gms.dto.CustomerDTO;
import com.woc.gms.dto.PlanSubscriptionDTO;
import com.woc.gms.dto.PlanSubscriptionPayloadDTO;
import com.woc.gms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public CustomerDTO getCustomerByEmail(@RequestParam("email") String email){
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping("/customer/{customerId}/plan/all")
    public List<PlanSubscriptionDTO> getAllPlanSubscriptionOfCustomer(@PathVariable("customerId") Integer customerId){
        return customerService.getAllPlanSubscriptionOfCustomer(customerId);
    }

    @PostMapping("/customer/{customerId}/plan/{planId}")
    public PlanSubscriptionDTO subscribePlan(@PathVariable("customerId") Integer customerId,
                                                   @PathVariable("planId") Integer planId,
                                                   @RequestBody PlanSubscriptionPayloadDTO planSubscriptionPayloadDTO){
        return customerService.subscribePlan(customerId, planId, planSubscriptionPayloadDTO);
    }

    @PostMapping("/customer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createCustomer(customerDTO);
    }

}
