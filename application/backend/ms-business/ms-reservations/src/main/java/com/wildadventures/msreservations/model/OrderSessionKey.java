package com.wildadventures.msreservations.model;

import java.io.Serializable;

public class OrderSessionKey implements Serializable {
    private Integer orderId;
    private Integer sessionId;

    public OrderSessionKey() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderSessionKey setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public OrderSessionKey setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
        return this;
    }
}

