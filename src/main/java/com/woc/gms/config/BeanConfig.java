package com.woc.gms.config;

import com.woc.gms.service.CustomerService;
import com.woc.gms.service.PlanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public CustomerService customerService(){
        return new CustomerService();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

   /* @Bean
    public PlanService planService(){
        return new PlanService();
    }*/

}
