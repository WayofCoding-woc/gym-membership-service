package com.woc.gms.dto;

import com.woc.gms.cons.PLAN_NAME;
import com.woc.gms.cons.SUBSCRIPTION_STATUS;

import java.io.Serializable;
import java.util.Date;

public class PlanSubscriptionDTO implements Serializable {
    private static final long serialVersionUID = -6823613951274000291L;

    private PLAN_NAME plan;
    private Integer validity;
    private Date activatedDate;
    private SUBSCRIPTION_STATUS status;

    private Double paidAmount;
    private String paymentMode;

    private String paymentRefNo;

    public PLAN_NAME getPlan() {
        return plan;
    }

    public void setPlan(PLAN_NAME plan) {
        this.plan = plan;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public Date getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
    }

    public SUBSCRIPTION_STATUS getStatus() {
        return status;
    }

    public void setStatus(SUBSCRIPTION_STATUS status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentRefNo() {
        return paymentRefNo;
    }

    public void setPaymentRefNo(String paymentRefNo) {
        this.paymentRefNo = paymentRefNo;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Override
    public String toString() {
        return "PlanSubscriptionDTO{" +
                "plan='" + plan + '\'' +
                ", validity=" + validity +
                ", activatedDate=" + activatedDate +
                ", status=" + status +
                ", paymentMode=" + paymentMode +
                ", paymentRefNo=" + paymentRefNo +
                ", paidAmount=" + paidAmount +
                '}';
    }
}
