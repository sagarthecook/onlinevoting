package com.onlinevoting.service;

import com.onlinevoting.model.UserDetail;
import com.onlinevoting.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    public UserDetail saveUser(UserDetail userDetail) {
        UserDetail userDetail1 = new UserDetail(userDetail.getFirstName(),userDetail.getLastName(),
                userDetail.getMiddleName(),userDetail.getEmailId(),userDetail.getPhoneNo(),userDetail.getAddress(),
                userDetail.getDob(),userDetail.getAadharNumber());
       return userDetailRepository.save(userDetail1);
    }
}
