package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
public class Defect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long defectId;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @NotNull(message = "Defect title cannot be null")
    private String defectTitle;

    private String description;

    @NotNull(message = "Severity cannot be null")
    @Enumerated(EnumType.STRING)
    private Severity severity;

    @NotNull(message = "Priority cannot be null")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotNull(message = "Defect status cannot be null")
    @Enumerated(EnumType.STRING)
    private DefectStatus defectStatus;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "reported_by")
    private User reportedBy;

    private String resolution;
    private String environment;
    private String releaseNumber;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name = "submodule_id")
    private Submodule submodule;

    private String comments;
    private String attachments;
    private Integer reopenCount;

    @Enumerated(EnumType.STRING)
    private DefectType defectType;
}
