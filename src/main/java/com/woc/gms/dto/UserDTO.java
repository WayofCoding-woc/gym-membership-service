package com.woc.gms.dto;

import com.woc.gms.cons.USER_ROLE;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = -8038272430772368312L;

    private String username;

    private String password;

    private USER_ROLE role;

    private Date createdDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
