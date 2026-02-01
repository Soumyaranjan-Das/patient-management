package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatientRequestDto {
    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is require")
    @Email(message = "Not a valid Email")
    private String email;

    @NotBlank(message = "adrress is required")
    private String address;

    @NotBlank(message = "date of birth is required")
    private String dateOfBirth;

    @NotBlank(message = "registered date is required")
    private String registeredDate;
}
