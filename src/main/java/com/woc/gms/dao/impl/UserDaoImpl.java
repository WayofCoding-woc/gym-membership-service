package com.woc.gms.dao.impl;

import com.woc.gms.dao.UserDao;
import com.woc.gms.dto.UserDTO;
import com.woc.gms.jpa.entity.User;
import com.woc.gms.jpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return (user != null);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setCreatedDate(userDTO.getCreatedDate());
        user.setRole(userDTO.getRole());

        userRepository.save(user);
    }
}
