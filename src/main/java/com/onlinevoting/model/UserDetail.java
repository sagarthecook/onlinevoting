package com.onlinevoting.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDetail extends AuditDetail{

    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String emailId;
    private String phoneNo;
    private String address;
    private Date dob;
    private Long  aadharNumber;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updateBy;
    private LocalDateTime updatedBy;
    private Boolean isActive;

    public UserDetail(String createdBy, LocalDateTime createdDate, String updateBy, LocalDateTime updatedBy, Boolean isActive) {
        super(createdBy, createdDate, updateBy, updatedBy, isActive);
    }
}
