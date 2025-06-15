package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Bench {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long benchId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private int availabilityHours;
    private int availabilityPercentage;
}
