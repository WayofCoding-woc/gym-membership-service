package com.woc.gms.dto;

import java.io.Serializable;
import java.util.Date;

public class PlanSubscriptionPayloadDTO implements Serializable {
    private static final long serialVersionUID = -7802899886755110459L;

    private Double paidAmount;
    private Date activatedDate;

    private String paymentMode;

    private String paymentRefNo;


    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
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

    @Override
    public String toString() {
        return "PlanSubscriptionPayloadDTO{" +
                "paidAmount=" + paidAmount +
                ", activatedDate=" + activatedDate +
                ", paymentMode=" + paymentMode +
                ", paymentRefNo=" + paymentRefNo +
                '}';
    }
}
