package com.woc.gms.service;

import com.woc.gms.dto.CustomerPlanDataForAlertDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@EnableScheduling
@Configuration
public class SchedulerJob {
    private static final Logger logger = LoggerFactory.getLogger(SchedulerJob.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "${gym.subscription.expiry.alert.cron}")
    public void gymSubscriptionExpiryNotificationJob(){
        logger.info("gymSubscriptionExpiryNotificationJob started");
        List<CustomerPlanDataForAlertDTO> allCustomersWhoesPlansAreExpiring = customerService.getAllCustomersWhoesPlansAreExpiring();
        for(CustomerPlanDataForAlertDTO customerPlanDataForAlertDTO: allCustomersWhoesPlansAreExpiring){
            emailService.sendPlanExpiryMail(customerPlanDataForAlertDTO);
        }
        logger.info("gymSubscriptionExpiryNotificationJob completed");
    }
}
