package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priorityId;

    @NotNull(message = "Priority name cannot be null")
    @Size(min = 3, max = 50)
    private String priorityName;

    private String description;
}
