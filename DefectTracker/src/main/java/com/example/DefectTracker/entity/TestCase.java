package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testCaseId;

    @NotNull(message = "Test case name cannot be null")
    @Size(min = 3, max = 255)
    private String testCaseName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "submodule_id")
    private Submodule submodule;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    private String status;
    private String severity;
    private String priority;
    private String testerName;
    private String comments;
    private String environment;
    private String releaseNumber;
}
