package com.ies.AdminMS.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Data
public class PlanDTO {

    private Long id;

    @NotNull(message = "{name.notnull.invalid}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{name.pattern.invalid}")
    private String name;

    @NotNull(message = "{startDate.notnull.invalid}")
    private LocalDate startDate;

    @NotNull(message = "{endDate.notnull.invalid}")
    private LocalDate endDate;

    @NotNull(message = "{category.notnull.invalid}")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "{category.pattern.invalid}")
    private String category;

    private boolean activeStatus;

}
