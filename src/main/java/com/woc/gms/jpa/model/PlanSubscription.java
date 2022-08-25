package com.woc.gms.jpa.model;

import com.woc.gms.cons.SUBSCRIPTION_STATUS;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "plan_subscription")
public class PlanSubscription implements Serializable {

    private static final long serialVersionUID = 1397059776602703289L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SUBSCRIPTION_STATUS status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public SUBSCRIPTION_STATUS getStatus() {
        return status;
    }

    public void setStatus(SUBSCRIPTION_STATUS status) {
        this.status = status;
    }
}
