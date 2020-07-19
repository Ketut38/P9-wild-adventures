package com.wildadventures.msreservations.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "order_date")
    private LocalDate date;
    @Column(name = "is_paid")
    private Boolean isPaid;

    public Order() {
    }


    public Order(Integer id, Integer userId, Integer sessionId, LocalDate date, Boolean isPaid) {
        super();
        this.id = id;
        this.userId = userId;
        this.sessionId = sessionId;
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


    public Integer getSessionId() {
        return sessionId;
    }


    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
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


    @Override
    public String toString() {
        return String.format("Order[id=%d, user_id='%s', session_id='%s', date='%s', isPaid='%s']", id, userId, sessionId, date, isPaid);
    }

}
