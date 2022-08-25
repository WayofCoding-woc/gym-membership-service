package com.woc.gms.dao;

import com.woc.gms.dto.UserDTO;

public interface UserDao {
    boolean login(String username, String password);

    void createUser(UserDTO userDTO);
}
