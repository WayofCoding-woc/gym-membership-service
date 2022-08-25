package com.woc.gms.dao;

import com.woc.gms.dto.CustomerDTO;
import com.woc.gms.dto.PlanSubscriptionDTO;
import com.woc.gms.dto.PlanSubscriptionPayloadDTO;

import java.util.List;

public interface CustomerDao {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerByEmail(String email);
    List<PlanSubscriptionDTO> getAllPlanByCustomerId(Integer customerId);
    PlanSubscriptionDTO subscribePlan(Integer customerId, Integer planId, PlanSubscriptionPayloadDTO planSubscriptionPayloadDTO);

}
