package com.woc.gms.api;

import com.woc.gms.dto.CustomerDTO;
import com.woc.gms.dto.PlanSubscriptionDTO;
import com.woc.gms.dto.PlanSubscriptionPayloadDTO;
import com.woc.gms.service.CustomerDataService;
import com.woc.gms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerApi {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDataService customerDataService;

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

    @GetMapping("/thirdparty/details")
    public String getThirdpartyApiData(){
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://catfact.ninja/fact",
                HttpMethod.GET,
                null,
                String.class);

        String response = responseEntity.getBody();
        return response;
    }

    @GetMapping("/customerDataDetails")
    public Map<String, Object> getCustomerDataDetails(@RequestParam("email") String email){
        Map<String, Object> data = customerDataService.getData(email);
        return data;
    }

}
