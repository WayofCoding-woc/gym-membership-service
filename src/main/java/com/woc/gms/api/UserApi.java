package com.woc.gms.api;

import com.woc.gms.dto.LoginCredentialsDTO;
import com.woc.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private UserService userService;

    /*@PostMapping("/login")
    public Boolean login(@RequestBody LoginCredentialsDTO loginCredentialsDTO){
        return userService.login(loginCredentialsDTO.getUsername(), loginCredentialsDTO.getPassword());
    }*/


    
}
