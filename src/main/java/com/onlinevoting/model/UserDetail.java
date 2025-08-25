package com.onlinevoting.model;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class UserDetail extends AuditDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String middleName;
    private String emailId;
    private String phoneNo;
    private String address;
    private Date dob;
    private Long  aadharNumber;


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

    
}
