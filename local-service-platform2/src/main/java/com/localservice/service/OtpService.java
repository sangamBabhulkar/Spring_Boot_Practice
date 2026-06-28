package com.localservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.localservice.model.UserOtp;
import com.localservice.repository.UserOtpRepository;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private UserOtpRepository repository;

    public void sendOtp(String mobile, String name, String email, String password) {

        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        UserOtp userOtp = new UserOtp();
        userOtp.setMobile(mobile);
        userOtp.setOtp(otp);
        userOtp.setExpiryTime(LocalDateTime.now().plusMinutes(5));

        // store user data temporarily
        userOtp.setName(name);
        userOtp.setEmail(email);
        userOtp.setPassword(password);

        repository.save(userOtp);

        // 👉 For now print OTP (later connect SMS API)
        System.out.println("OTP for " + mobile + " is: " + otp);
    }

    public boolean verifyOtp(String mobile, String otp) {
        UserOtp userOtp = repository.findByMobile(mobile);

        if (userOtp == null) return false;

        if (userOtp.getExpiryTime().isBefore(LocalDateTime.now())) {
            return false;
        }

        return userOtp.getOtp().equals(otp);
    }

    public UserOtp getUserData(String mobile) {
        return repository.findByMobile(mobile);
    }
}