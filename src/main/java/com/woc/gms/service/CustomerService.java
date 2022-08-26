package com.woc.gms.service;

import com.woc.gms.cons.USER_ROLE;
import com.woc.gms.dao.CustomerDao;
import com.woc.gms.dao.UserDao;
import com.woc.gms.dto.CustomerDTO;
import com.woc.gms.dto.PlanSubscriptionDTO;
import com.woc.gms.dto.PlanSubscriptionPayloadDTO;
import com.woc.gms.dto.UserDTO;
import com.woc.gms.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

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
}
