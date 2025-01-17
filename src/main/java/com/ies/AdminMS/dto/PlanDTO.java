package com.ies.AdminMS.dto;

import com.ies.AdminMS.entity.PlanEntity;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class PlanDTO {

    private Long id;
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{name.pattern.invalid}")
    private String name;
    private Date startDate;
    private Date endDate;
    private String category;
    private Boolean isActive;

    public static PlanDTO prepareDTO(PlanEntity entity) {
        PlanDTO dto = new PlanDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setCategory(entity.getCategory());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public static PlanEntity prepareEntity(PlanDTO dto) {
        PlanEntity entity = new PlanEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCategory(dto.getCategory());
        entity.setIsActive(dto.getIsActive());
        return entity;
    }
}
