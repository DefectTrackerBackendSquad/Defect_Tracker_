package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Severity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long severityId;

    @NotNull(message = "Severity name cannot be null")
    @Size(min = 3, max = 50)
    private String severityName;

    private String description;
}
