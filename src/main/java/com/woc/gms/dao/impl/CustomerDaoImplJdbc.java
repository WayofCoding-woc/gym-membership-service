package com.woc.gms.dao.impl;

import com.woc.gms.dao.CustomerDao;
import com.woc.gms.dto.CustomerDTO;
import com.woc.gms.dto.CustomerPlanDataForAlertDTO;
import com.woc.gms.dto.PlanSubscriptionDTO;
import com.woc.gms.dto.PlanSubscriptionPayloadDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Service("customerDaoV2")
public class CustomerDaoImplJdbc implements CustomerDao {
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return null;
    }

    @Override
    public List<PlanSubscriptionDTO> getAllPlanByCustomerId(Integer customerId) {
        return null;
    }

    @Override
    public PlanSubscriptionDTO subscribePlan(Integer customerId, Integer planId, PlanSubscriptionPayloadDTO planSubscriptionPayloadDTO) {
        return null;
    }

    @Override
    public List<CustomerPlanDataForAlertDTO> getAllCustomersWhoesPlansAreExpiring() {
        return null;
    }
}
