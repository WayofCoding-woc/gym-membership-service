package com.woc.gms.dto;

import com.woc.gms.cons.PLAN_NAME;

import java.io.Serializable;
import java.util.Date;

public class CustomerPlanDataForAlertDTO implements Serializable {
    private static final long serialVersionUID = -7600349166570491791L;

    private String customerName;
    private String email;
    private PLAN_NAME planName;
    private Date planExpireOn;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PLAN_NAME getPlanName() {
        return planName;
    }

    public void setPlanName(PLAN_NAME planName) {
        this.planName = planName;
    }

    public Date getPlanExpireOn() {
        return planExpireOn;
    }

    public void setPlanExpireOn(Date planExpireOn) {
        this.planExpireOn = planExpireOn;
    }

    @Override
    public String toString() {
        return "CustomerPlanDataForAlertDTO{" +
                "customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", planName='" + planName + '\'' +
                ", planExpireOn=" + planExpireOn +
                '}';
    }
}
