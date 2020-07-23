package com.wildadventures.msreservations.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "order", targetEntity = OrderSession.class, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<OrderSession> orderSessions = new ArrayList<>(0);

    public Order() {
    }


    public Order(Integer id, Integer userId, LocalDate date, Boolean isPaid) {
        super();
        this.id = id;
        this.userId = userId;
        this.date = date;
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

    public List<OrderSession> getOrderSessions() {
        return orderSessions;
    }

    public Order setOrderSessions(List<OrderSession> orderSessions) {
        this.orderSessions = orderSessions;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Order[id=%d, user_id='%s', session_id='%s', date='%s', isPaid='%s']", id, userId, date, isPaid);
    }

}
