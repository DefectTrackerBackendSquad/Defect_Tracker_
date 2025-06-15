package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
public class Submodule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submoduleId;

    @NotNull(message = "Submodule name cannot be null")
    @Size(min = 3, max = 255)
    private String submoduleName;

    private String description;
}
