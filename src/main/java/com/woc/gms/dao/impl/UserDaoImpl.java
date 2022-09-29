package com.woc.gms.dao.impl;

import com.woc.gms.dao.UserDao;
import com.woc.gms.dto.ResetPasswordDTO;
import com.woc.gms.dto.UserDTO;
import com.woc.gms.jpa.entity.User;
import com.woc.gms.jpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        return PasswordEncoderFactories.createDelegatingPasswordEncoder().matches(password, user.getPassword());
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreatedDate(user.getCreatedDate());
        userDTO.setRole(user.getRole());
        return userDTO;
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

    @Override
    public Boolean resetPassword(ResetPasswordDTO resetPasswordDTO) {
        User user = userRepository.findByUsername(resetPasswordDTO.getUsername());
        if(user == null){
            throw new IllegalArgumentException("No such user exits in our system with username="+resetPasswordDTO.getUsername());
        }

        if(!PasswordEncoderFactories.createDelegatingPasswordEncoder().matches(resetPasswordDTO.getCurrentPassword(), user.getPassword())){
            throw new IllegalArgumentException("Credentials does not match, please try again");
        }

        String encodedNewPassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(resetPasswordDTO.getNewPassword());
        user.setPassword(encodedNewPassword);

        userRepository.save(user);

        return true;
    }
}
