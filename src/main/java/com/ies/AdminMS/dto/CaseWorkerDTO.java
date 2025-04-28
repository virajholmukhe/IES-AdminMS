package com.ies.AdminMS.dto;

import lombok.Data;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Data
public class CaseWorkerDTO {

    private String caseWorkerId;
    @Size(min = 3, max = 50, message = "{fullname.size.invalid}")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "{fullname.pattern.invalid}")
    private String fullname;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "{emailId.pattern.invalid}")
    private String emailId;

    @NotNull(message = "{mobileNumber.notnull.invalid}")
    @Pattern(regexp = "^[0-9]{10}$", message = "{phone.pattern.invalid}")
    private String mobileNumber;

    @Pattern(regexp = "Male|Female|Other", message = "{gender.pattern.invalid}")
    private String gender;

    @NotNull(message = "{dateOfBirth.notnull.invalid}")
    @Past(message = "{dateOfBirth.future.invalid}")
    private LocalDate dateOfBirth;

    @NotNull(message = "{aadharNumber.notnull.invalid}")
    @Pattern(regexp = "^[0-9]{10}$", message = "{aadharNumber.pattern.invalid}")
    private String aadharNumber;

    private boolean activeStatus;

}
