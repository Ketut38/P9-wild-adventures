package com.wildadventures.msreservations.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wildadventures.msreservations.bean.SessionBean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "order_date")
    private LocalDate date;
    @Column(name = "is_paid")
    private Boolean isPaid;
    @Column(name = "amount")
    private Double amount;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", targetEntity = OrderSession.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<OrderSession> orderSessions = new ArrayList<>(0);


    // TODO : Montant d'une commande : methode static
    // Stocker le montant en base

    public Order() {
    }


    public Order(Integer id, Integer userId, LocalDate date, Double amount, Boolean isPaid) {
        super();
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.amount = amount;
        this.isPaid = isPaid;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public Boolean getIsPaid() {
        return isPaid;
    }


    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public Order setPaid(Boolean paid) {
        isPaid = paid;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Order setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public List<OrderSession> getOrderSessions() {
        return orderSessions;
    }

    public Order setOrderSessions(List<OrderSession> orderSessions) {
        this.orderSessions = orderSessions;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", isPaid=" + isPaid +
                ", amount=" + amount +
                '}';
    }

    public static Double getTotalOrderAmount(List<SessionBean> sessionBeans){
        Double amount = null;
        if(!sessionBeans.isEmpty()){
            for (int i = 0; i <sessionBeans.size() ; i++) {
                amount = sessionBeans.get(i).getPrice();
            }
            return amount;
        }else{
            return null;
        }
    }
}
