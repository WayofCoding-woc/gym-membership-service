package com.woc.gms.dto;

import java.io.Serializable;

public class LoggedInUserDTO implements Serializable {
    private static final long serialVersionUID = 3545452502447793178L;

    private String username;
    private String role;
    private Integer customerId;
    private boolean authenticated;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    @Override
    public String toString() {
        return "LoggedInUserDTO{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", customerId=" + customerId +
                ", authenticated=" + authenticated +
                '}';
    }
}
