package com.woc.gms.service;

import com.woc.gms.cons.USER_ROLE;
import com.woc.gms.dao.CustomerDao;
import com.woc.gms.dao.UserDao;
import com.woc.gms.dto.*;
import com.woc.gms.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

//@Component
//@Service
public class CustomerService {

    //@Qualifier("customerDaoV2")
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmailService emailService;


    public CustomerDTO getCustomerByEmail(String email) {
        return customerDao.getCustomerByEmail(email);
    }

    public List<PlanSubscriptionDTO> getAllPlanSubscriptionOfCustomer(Integer customerId) {
        return customerDao.getAllPlanByCustomerId(customerId);
    }

    public PlanSubscriptionDTO subscribePlan(Integer customerId, Integer planId, PlanSubscriptionPayloadDTO planSubscriptionPayloadDTO) {
        return customerDao.subscribePlan(customerId, planId, planSubscriptionPayloadDTO);
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerDTO customer = customerDao.createCustomer(customerDTO);

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(customer.getEmail());
        userDTO.setPassword(AppUtil.generatePassword());//random string password
        userDTO.setRole(USER_ROLE.CUSTOMER);
        userDTO.setCreatedDate(new Date());

        userDao.createUser(userDTO);

        emailService.sendMailToUser(userDTO, customer.getName());

        return customer;
    }

    public List<CustomerPlanDataForAlertDTO> getAllCustomersWhoesPlansAreExpiring(){
        return customerDao.getAllCustomersWhoesPlansAreExpiring();
    }
}
