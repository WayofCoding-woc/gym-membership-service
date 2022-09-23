package com.woc.gms.api;

import com.woc.gms.dto.LoggedInUserDTO;
import com.woc.gms.dto.LoginCredentialsDTO;
import com.woc.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoggedInUserDTO login(@RequestBody LoginCredentialsDTO loginCredentialsDTO){
        LoggedInUserDTO loggedInUserDTO = userService.login(loginCredentialsDTO.getUsername(), loginCredentialsDTO.getPassword());
        return loggedInUserDTO;
    }


    
}
