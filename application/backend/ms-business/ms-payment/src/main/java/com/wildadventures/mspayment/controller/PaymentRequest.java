package com.wildadventures.mspayment.controller;

public class PaymentRequest {
    private String token;
    private String amount;

    public PaymentRequest() {
    }

    public String getToken() {
        return token;
    }

    public PaymentRequest setToken(String token) {
        this.token = token;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public PaymentRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "token='" + token + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
