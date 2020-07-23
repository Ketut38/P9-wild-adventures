package com.wildadventures.msreservations.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_session")
@IdClass(OrderSessionKey.class)
public class OrderSession implements Serializable {

    @JsonBackReference
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Id
    @Column(name = "session_id")
    private Integer sessionId;

    public OrderSession() {
    }

    public Order getOrder() {
        return order;
    }

    public OrderSession setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderSession setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public OrderSession setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }
}
