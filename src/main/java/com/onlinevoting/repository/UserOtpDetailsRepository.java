package com.onlinevoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinevoting.model.UserOtpDetails;

public interface UserOtpDetailsRepository extends JpaRepository<UserOtpDetails, Long> {
}
