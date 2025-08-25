package com.onlinevoting.controller;

import com.onlinevoting.model.UserDetail;
import com.onlinevoting.service.UserDetailService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;
import com.onlinevoting.dto.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/v1/user_detail")
    public ResponseEntity<ApiResponse<UserDetail>> createUser(@Valid @RequestBody UserDetail userDetail) {
        UserDetail savedUser = userDetailService.saveUser(userDetail);
        ApiResponse<UserDetail> response = new ApiResponse<>(true, savedUser, null);
        return ResponseEntity.ok(response);
    }
}
