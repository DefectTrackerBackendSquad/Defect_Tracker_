package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class DefectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long defectStatusId;

    @NotNull(message = "Defect status name cannot be null")
    @Size(min = 3, max = 50)
    private String defectStatusName;

    private String description;
}
