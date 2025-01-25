package com.ies.AdminMS.dto;

import lombok.Data;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
public class CaseWorkerDTO {

    @Size(min = 3, max = 50, message = "{fullname.size.invalid}")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "{fullname.pattern.invalid}")
    private String fullname;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "{emailId.pattern.invalid}")
    private String emailId;

    @NotNull(message = "{mobileNumber.notnull.invalid}")
    @Range(min = 1000000000L, max = 9999999999L, message = "{mobileNumber.pattern.invalid}")
    private Long mobileNumber;

    @Pattern(regexp = "Male|Female|Other", message = "{gender.pattern.invalid}")
    private String gender;

    @NotNull(message = "{dateOfBirth.notnull.invalid}")
    @Past(message = "{dateOfBirth.future.invalid}")
    private LocalDate dateOfBirth;

    @NotNull(message = "{aadharNumber.notnull.invalid}")
    @Range(min = 100000000000L, max = 999999999999L, message = "{aadharNumber.pattern.invalid}")
    private Long aadharNumber;

    private boolean activeStatus;

}
