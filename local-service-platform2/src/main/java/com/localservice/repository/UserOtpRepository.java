package com.localservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.localservice.model.UserOtp;

public interface UserOtpRepository extends JpaRepository<UserOtp, Long> {
    UserOtp findByMobile(String mobile);
}