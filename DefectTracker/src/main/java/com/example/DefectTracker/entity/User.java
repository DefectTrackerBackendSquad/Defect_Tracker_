package com.defecttracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 255)
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 255)
    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
