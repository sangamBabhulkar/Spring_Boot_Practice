package com.example.paymentservice;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping("/process")
    public Map<String, Object> processPayment(@RequestBody Map<String, Object> paymentRequest) {
        // Extract the amount sent by the order service
        Object amount = paymentRequest.get("amount");
        
        // Simulate successful payment processing
        return Map.of(
            "paymentId", "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(),
            "status", "SUCCESS",
            "amount", amount
        );
    }
}