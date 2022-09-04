package com.woc.gms.service;

import com.woc.gms.cons.USER_ROLE;
import com.woc.gms.dao.UserDao;
import com.woc.gms.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    public Boolean login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userDao.findByUsername(username);
        USER_ROLE role = userDTO.getRole();
        List<SimpleGrantedAuthority> authority = new LinkedList<>();
        authority.add(new SimpleGrantedAuthority(role.name()));
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), authority);
        return user;
    }
}
