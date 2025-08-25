package com.onlinevoting.controller;

import com.onlinevoting.model.UserDetail;
import com.onlinevoting.repository.UserDetailRepository;
import com.onlinevoting.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/v1/user_detail")
    public ResponseEntity createUser(@RequestBody UserDetail userDetail) {
        return new ResponseEntity(userDetailService.saveUser(userDetail),HttpStatus.CREATED);
    }
}
