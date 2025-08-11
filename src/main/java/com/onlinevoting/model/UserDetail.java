package com.onlinevoting.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity

public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
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

    public UserDetail(String firstName, String lastName, String middleName, String emailId, String phoneNo, String address,
                      Date dob, Long aadharNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.address = address;
        this.dob = dob;
        this.aadharNumber = aadharNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public Long getAadharNumber() {
        return aadharNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public LocalDateTime getUpdatedBy() {
        return updatedBy;
    }

    public Boolean getActive() {
        return isActive;
    }
}
