package com.onlinevoting.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevoting.dto.UserLoginInfo;
import com.onlinevoting.exception.UserNotFoundException;
import com.onlinevoting.model.UserDetail;
import com.onlinevoting.repository.UserDetailRepository;

@Service
public class LoginService {

    @Autowired
    private UserDetailRepository userDetailRepository;
    /**
     * Generate OTP for the given user login info.
     * @param userLoginInfo
     * @throws IllegalArgumentException if the userId is not a valid email format. 
     * UserId not found in database throw custom exception (UserNotFoundException)
     * if user is found, generate OTP and send it to the user's email address.
     */
    public void generateOtp(UserLoginInfo userLoginInfo) {
    
     UserDetail userDetail = userDetailRepository.findByEmailId(userLoginInfo.getUserId());
        if (userDetail == null) {
            throw new UserNotFoundException("User not found with email: " + userLoginInfo.getUserId());
        }

        
    }
}
