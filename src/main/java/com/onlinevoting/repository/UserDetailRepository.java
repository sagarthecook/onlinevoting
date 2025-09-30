package com.onlinevoting.repository;

import com.onlinevoting.model.UserDetail;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail findByEmailId(String emailId);
    Optional<UserDetail> findByIdAndIsActiveTrue(Long id);
    List<UserDetail> findByIsActiveFalse();
    
    @Query("SELECT u FROM UserDetail u WHERE u.isActive = :isActive AND u.status = :status")
    List<UserDetail> findByIsActiveAndStatus(Boolean isActive, String status);
}
