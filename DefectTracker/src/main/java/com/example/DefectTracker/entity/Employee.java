package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotNull(message = "Employee name cannot be null")
    private String name;

    private String designation;

    @NotNull(message = "Availability hours cannot be null")
    private int availabilityHours;

    @NotNull(message = "Availability percentage cannot be null")
    private int availabilityPercentage;
}
