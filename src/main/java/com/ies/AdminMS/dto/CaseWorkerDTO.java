package com.ies.AdminMS.dto;

import com.ies.AdminMS.entity.CaseWorkerEntity;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class CaseWorkerDTO {
    @Size(min = 3, max = 50, message = "{fullname.size.invalid}")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "{fullname.pattern.invalid}")
    private String fullname;
    @Email(message = "{email.pattern.invalid}")
    private String emailId;
    @Pattern(regexp = "^[0-9]{10}$", message = "{mobileNumber.pattern.invalid}")
    private Long mobileNumber;
    @Pattern(regexp = "Male|Female|Other", message = "{gender.pattern.invalid}")
    private String gender;
    @Past(message = "{dateOfBirth.future.invalid}")
    private Date dateOfBirth;
    @Pattern(regexp = "^[0-9]{12}$", message = "{aadharNumber.pattern.invalid}")
    private Double aadharNumber;
    private Boolean isActive;

    public static CaseWorkerDTO prepareDTO(CaseWorkerEntity entity) {
        CaseWorkerDTO dto = new CaseWorkerDTO();
        dto.setFullname(entity.getFullname());
        dto.setEmailId(entity.getEmailId());
        dto.setMobileNumber(entity.getMobileNumber());
        dto.setGender(entity.getGender());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setAadharNumber(entity.getAadharNumber());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public static CaseWorkerEntity prepareEntity(CaseWorkerDTO dto) {
        CaseWorkerEntity entity = new CaseWorkerEntity();
        entity.setFullname(dto.getFullname());
        entity.setEmailId(dto.getEmailId());
        entity.setMobileNumber(dto.getMobileNumber());
        entity.setGender(dto.getGender());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setAadharNumber(dto.getAadharNumber());
        entity.setIsActive(dto.getIsActive());
        return entity;
    }
}
