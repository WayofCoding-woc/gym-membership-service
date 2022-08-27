package com.woc.gms.dao.impl;

import com.woc.gms.cons.SUBSCRIPTION_STATUS;
import com.woc.gms.dao.CustomerDao;
import com.woc.gms.dto.CustomerDTO;
import com.woc.gms.dto.CustomerPlanDataForAlertDTO;
import com.woc.gms.dto.PlanSubscriptionDTO;
import com.woc.gms.dto.PlanSubscriptionPayloadDTO;
import com.woc.gms.jpa.entity.Customer;
import com.woc.gms.jpa.entity.Plan;
import com.woc.gms.jpa.entity.PlanSubscription;
import com.woc.gms.jpa.repo.CustomerRepository;
import com.woc.gms.jpa.repo.PlanRepository;
import com.woc.gms.jpa.repo.PlanSubscriptionRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanSubscriptionRepository planSubscriptionRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobile(customerDTO.getMobile());
        customer.setAddress(customerDTO.getAddress());
        customer.setCreatedDate(new Date());

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO dto = getCustomerDTO(savedCustomer);

        return dto;
    }

    private static CustomerDTO getCustomerDTO(Customer entity) {
        if(entity == null){
            return null;
        }
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setMobile(entity.getMobile());
        dto.setAddress(entity.getAddress());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        CustomerDTO customerDTO = getCustomerDTO(customer);
        return customerDTO;
    }

    @Override
    public List<PlanSubscriptionDTO> getAllPlanByCustomerId(Integer customerId) {
        Optional<Customer> optionalResult = customerRepository.findById(customerId);
        if(optionalResult.isPresent()){
            Customer customer = optionalResult.get();
            List<PlanSubscription> planSubscriptions = customer.getPlanSubscriptions();
            return planSubscriptions
                    .stream()
                    .map(e->{
                        PlanSubscriptionDTO dto = new PlanSubscriptionDTO();
                        Plan plan = e.getPlan();
                        dto.setPlan(plan.getName());
                        dto.setValidity(plan.getValidity());
                        dto.setStatus(e.getStatus());
                        dto.setActivatedDate(e.getCreatedDate());
                        return dto;
                    })
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public PlanSubscriptionDTO subscribePlan(Integer customerId, Integer planId, PlanSubscriptionPayloadDTO planSubscriptionPayloadDTO) {
        Optional<Customer> optionalResultCustomer = customerRepository.findById(customerId);
        Optional<Plan> optionalResultPlan = planRepository.findById(planId);
        if(optionalResultCustomer.isPresent()){
            Customer customer = optionalResultCustomer.get();
            if(optionalResultPlan.isPresent()){
                Plan plan = optionalResultPlan.get();

                PlanSubscription planSubscription = new PlanSubscription();
                planSubscription.setCustomer(customer);
                planSubscription.setPlan(plan);
                planSubscription.setPaidAmount(planSubscriptionPayloadDTO.getPaidAmount());
                planSubscription.setCreatedDate(planSubscriptionPayloadDTO.getActivatedDate());
                planSubscription.setStatus(SUBSCRIPTION_STATUS.ACTIVE);

                PlanSubscription savedPlanSubscription = planSubscriptionRepository.save(planSubscription);

                PlanSubscriptionDTO planSubscriptionDTO = new PlanSubscriptionDTO();
                Plan linkedPlan = savedPlanSubscription.getPlan();
                planSubscriptionDTO.setPlan(linkedPlan.getName());
                planSubscriptionDTO.setValidity(linkedPlan.getValidity());
                planSubscriptionDTO.setActivatedDate(savedPlanSubscription.getCreatedDate());
                planSubscriptionDTO.setStatus(planSubscription.getStatus());

                return planSubscriptionDTO;
            }
        }
        return null;
    }

    @Override
    public List<CustomerPlanDataForAlertDTO> getAllCustomersWhoesPlansAreExpiring() {
        List<PlanSubscription> planSubscriptions = planSubscriptionRepository.findByStatus(SUBSCRIPTION_STATUS.ACTIVE);
        List<CustomerPlanDataForAlertDTO> customerPlanDataForAlertDTOS = new LinkedList<>();
        for(PlanSubscription planSubscription : planSubscriptions){
            Plan plan = planSubscription.getPlan();
            Integer planValidity = plan.getValidity();
            Date createdDate = planSubscription.getCreatedDate();

            Date expiryOn = new DateTime(createdDate).plusDays(planValidity).toDate();
            Date currentDate = new Date();
            if(isAlertCriteriaEligible(currentDate, expiryOn)) {
                CustomerPlanDataForAlertDTO customerPlanDataForAlertDTO = new CustomerPlanDataForAlertDTO();
                Customer customer = planSubscription.getCustomer();
                customerPlanDataForAlertDTO.setCustomerName(customer.getName());
                customerPlanDataForAlertDTO.setEmail(customer.getEmail());
                customerPlanDataForAlertDTO.setPlanName(plan.getName());
                customerPlanDataForAlertDTO.setPlanExpireOn(expiryOn);
                customerPlanDataForAlertDTOS.add(customerPlanDataForAlertDTO);
            }
        }

        return customerPlanDataForAlertDTOS;
    }

    private boolean isAlertCriteriaEligible(Date currentDate, Date expiryOn) {
        if(currentDate.after(expiryOn)){
            return false;
        }
        long daysBetween = ChronoUnit.DAYS.between(currentDate.toInstant(), expiryOn.toInstant());
        if(daysBetween <= 5){
            return true;
        }

        return false;
    }
}
