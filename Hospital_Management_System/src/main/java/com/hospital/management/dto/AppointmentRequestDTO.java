package com.hospital.management.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AppointmentRequestDTO {

    @NotBlank(message = "Patient name cannot be empty")
    private String patientName;

    @NotBlank(message = "Doctor name cannot be empty")
    private String doctorName;

    @NotNull(message = "Appointment time is required")
    @Future(message = "Appointment must be scheduled for a future date")
    private LocalDateTime appointmentTime;

    // ===================================================================
    // 1. DEFAULT NO-ARG CONSTRUCTOR (Required by Jackson for JSON mapping)
    // ===================================================================
    public AppointmentRequestDTO() {
    }

    // ===================================================================
    // 2. ALL-ARGUMENT CONSTRUCTOR
    // ===================================================================
    public AppointmentRequestDTO(String patientName, String doctorName, LocalDateTime appointmentTime) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
    }

    // ===================================================================
    // 3. GETTERS AND SETTERS (Must strictly match naming conventions)
    // ===================================================================
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}