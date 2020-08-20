package com.wildadventures.mspayment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

    private String stripePublicKey = "pk_test_51H8625G3FbXArABCedsf92t6ip0afPkt1DSk1ZbDbIRbiUtpjJUQF7OwY1kNlv0J7apA8oCZkZSPoqzmnKS3UMxA00XQjtUVmP";

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}
