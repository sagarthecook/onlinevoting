package com.onlinevoting.controller;

import com.onlinevoting.model.UserDetail;
import com.onlinevoting.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @GetMapping("/v1/data")
    public String getData(){
        return "sss";
    }

    @PostMapping("/v1/user_detail")
    public void createUser(@RequestBody UserDetail userDetail) {
        UserDetail userDetail1 = new UserDetail(userDetail.getFirstName(),userDetail.getLastName(),
                userDetail.getMiddleName(),userDetail.getEmailId(),userDetail.getPhoneNo(),userDetail.getAddress(),
                userDetail.getDob(),userDetail.getAadharNumber());
        userDetailRepository.save(userDetail1);
    }
}
