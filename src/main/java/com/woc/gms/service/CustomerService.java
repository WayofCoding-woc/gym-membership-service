package com.woc.gms.service;

import com.woc.gms.cons.USER_ROLE;
import com.woc.gms.dao.CustomerDao;
import com.woc.gms.dao.UserDao;
import com.woc.gms.dto.*;
import com.woc.gms.util.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.Date;
import java.util.List;

//@Component
//@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

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
        String password = AppUtil.generatePassword();//random string password
        logger.debug("username = " + customer.getEmail() + ", password = " + password);
        String encodedPassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password);
        userDTO.setPassword(encodedPassword);
        userDTO.setRole(USER_ROLE.CUSTOMER);
        userDTO.setCreatedDate(new Date());

        userDao.createUser(userDTO);

        emailService.sendMailToUser(userDTO, password, customer.getName());

        return customer;
    }

    public List<CustomerPlanDataForAlertDTO> getAllCustomersWhoesPlansAreExpiring(){
        return customerDao.getAllCustomersWhoesPlansAreExpiring();
    }
}
