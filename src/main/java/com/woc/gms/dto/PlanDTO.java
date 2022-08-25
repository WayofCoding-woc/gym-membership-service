package com.woc.gms.dto;

import com.woc.gms.cons.PLAN_NAME;

import java.io.Serializable;

public class PlanDTO implements Serializable {
    private static final long serialVersionUID = -6823613951274000291L;

    private Integer id;
    private PLAN_NAME name;
    private Integer validity;
    private Double price;
    private Double discount;
    private Double finalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PLAN_NAME getName() {
        return name;
    }

    public void setName(PLAN_NAME name) {
        this.name = name;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
