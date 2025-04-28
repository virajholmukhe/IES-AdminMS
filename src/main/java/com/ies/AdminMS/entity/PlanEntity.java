package com.ies.AdminMS.entity;

import com.ies.AdminMS.utils.PlanId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PlanEntity {
    @Id
    @PlanId
    private String id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String category;
    private Boolean activeStatus;

}
