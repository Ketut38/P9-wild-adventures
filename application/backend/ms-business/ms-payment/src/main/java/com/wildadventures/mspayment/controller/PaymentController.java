package com.wildadventures.mspayment.controller;

import com.stripe.model.Charge;

import javax.servlet.http.HttpServletRequest;

import com.wildadventures.mspayment.service.StripeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PaymentController {

    private StripeClient stripeClient;

    @Autowired
    PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public Charge chargeCard(HttpServletRequest request) throws Exception {
        //String token = request.getHeader("token");
        String token = "tok_1HCv5qG3FbXArABCilMfTcV6";
        //Double amount = Double.parseDouble(request.getHeader("amount"));
        Double amount = Double.valueOf(150);
        return this.stripeClient.chargeCreditCard(token, amount);
    }


}

