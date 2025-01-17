package com.ies.AdminMS.entity;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class CaseWorkerEntity {

    private String fullname;
    @Id
    private String emailId;
    private Long mobileNumber;
    private String gender;
    private Date dateOfBirth;
    private Double aadharNumber;
    private Boolean isActive;

}
