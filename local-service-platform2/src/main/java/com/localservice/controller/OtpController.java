package com.localservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.localservice.model.UserOtp;
import com.localservice.service.OtpService;

@Controller
public class OtpController {

    @Autowired
    private OtpService otpService;

    // Step 1: Send OTP
    @PostMapping("/send-otp")
    public String sendOtp(
            @RequestParam String mobile,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        otpService.sendOtp(mobile, name, email, password);
        return "otp"; // open otp.html
    }

    // Step 2: Verify OTP
    @PostMapping("/verify-otp")
    public String verifyOtp(
            @RequestParam String mobile,
            @RequestParam String otp
    ) {
        boolean isValid = otpService.verifyOtp(mobile, otp);

        if (isValid) {
            UserOtp user = otpService.getUserData(mobile);

            // 👉 HERE you will save user in real User table (later)
            System.out.println("User Registered: " + user.getName());

            return "login"; // success
        } else {
            return "otp"; // retry
        }
    }
}
