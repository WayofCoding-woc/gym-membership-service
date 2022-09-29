package com.woc.gms.dao;

import com.woc.gms.dto.ResetPasswordDTO;
import com.woc.gms.dto.UserDTO;

public interface UserDao {
    boolean login(String username, String password);
    UserDTO findByUsername(String username);

    void createUser(UserDTO userDTO);

    Boolean resetPassword(ResetPasswordDTO resetPasswordDTO);
}
