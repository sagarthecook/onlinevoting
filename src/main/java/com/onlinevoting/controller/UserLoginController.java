package com.onlinevoting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.onlinevoting.dto.ApiResponse;
import com.onlinevoting.dto.UserLoginDTO;
import com.onlinevoting.dto.UserLoginInfo;
<<<<<<< HEAD
import com.onlinevoting.service.JwtService;
import com.onlinevoting.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
=======
import com.onlinevoting.service.LoginService;

>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserLoginController {

<<<<<<< HEAD
    private final LoginService loginService;
    private final JwtService jwtService;

    public UserLoginController(@Autowired LoginService loginService, @Autowired JwtService jwtService) {
        this.loginService = loginService;
        this.jwtService = jwtService;
    }
=======
    @Autowired
    private LoginService loginService;

>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc

    @PostMapping("/v1/user/generate_otp")
    public ResponseEntity<ApiResponse> genrateOtp(@RequestBody @Valid UserLoginInfo userLoginInfo) {
        loginService.generateOtp(userLoginInfo);
        return ResponseEntity.ok(new ApiResponse<>(true, "",null,"OTP Generate Successfully"));
    }

    @PostMapping("/v1/user/validate_otp") 
    public ResponseEntity<ApiResponse> loginUser(@RequestBody @Valid UserLoginDTO userLoginInfDto) {
        Boolean isLoginSuccess = loginService.loginUser(userLoginInfDto);
<<<<<<< HEAD
        if(isLoginSuccess) {
            String token = jwtService.generateToken(userLoginInfDto.getUserId());
            return ResponseEntity.ok(new ApiResponse<>(isLoginSuccess, token ,null,"Login Successfully..."));
        }
        return ResponseEntity.ok(new ApiResponse<>(isLoginSuccess,"" ,null,"Login Failed"));
=======
        return ResponseEntity.ok(new ApiResponse<>(isLoginSuccess,"token" ,null,"Login Successfully"));
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
    }
}
