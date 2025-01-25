package com.ies.AdminMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class CaseWorkerEntity {

    private String fullname;
    @Id
    private String emailId;
    private Long mobileNumber;
    private String gender;
    private LocalDate dateOfBirth;
    private Long aadharNumber;
    @Builder.Default
    private boolean activeStatus = false;

}
