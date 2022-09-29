package com.woc.gms.dto;

import java.io.Serializable;

public class ResetPasswordDTO implements Serializable {
    private static final long serialVersionUID = -7106228016555824832L;

    private String username;

    private String currentPassword;

    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ResetPasswordDTO{" +
                "username='" + username + '\'' +
                ", currentPassword='" + currentPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
