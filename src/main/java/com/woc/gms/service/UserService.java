package com.woc.gms.service;

import com.woc.gms.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public Boolean login(String username, String password) {
        return userDao.login(username, password);
    }
}
