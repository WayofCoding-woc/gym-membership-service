package com.woc.gms.jpa.entity;

import com.woc.gms.cons.PLAN_NAME;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plan")
public class Plan implements Serializable {
    private static final long serialVersionUID = 7808339409910173112L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private PLAN_NAME name;

    @Column(name = "validity")
    private Integer validity;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "finalPrice")
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
