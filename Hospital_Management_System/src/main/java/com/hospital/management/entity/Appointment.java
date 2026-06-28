package com.hospital.management.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
//UPDATE THIS ANNOTATION:
@Table(
 name = "appointments",
 uniqueConstraints = {
     @UniqueConstraint(
         name = "uk_patient_appointment_time", 
         columnNames = {"patientName", "appointmentTime"}
     )
 }
)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(nullable = false)
    private String status; // e.g., SCHEDULED, CANCELED, COMPLETED

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // ===================================================================
    // 1. NO-ARGUMENT CONSTRUCTOR (Required by JPA)
    // ===================================================================
    public Appointment() {
    }

    // ===================================================================
    // 2. ALL-ARGUMENT CONSTRUCTOR
    // ===================================================================
    public Appointment(Long id, String patientName, String doctorName, LocalDateTime appointmentTime, String status, LocalDateTime createdAt) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.createdAt = createdAt;
    }

    // ===================================================================
    // 3. GETTERS AND SETTERS
    // ===================================================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ===================================================================
    // 4. CUSTOM BUILDER PATTERN (Replaces Lombok's @Builder)
    // ===================================================================
    public static AppointmentBuilder builder() {
        return new AppointmentBuilder();
    }

    public static class AppointmentBuilder {
        private Long id;
        private String patientName;
        private String doctorName;
        private LocalDateTime appointmentTime;
        private String status;
        private LocalDateTime createdAt;

        public AppointmentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AppointmentBuilder patientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public AppointmentBuilder doctorName(String doctorName) {
            this.doctorName = doctorName;
            return this;
        }

        public AppointmentBuilder appointmentTime(LocalDateTime appointmentTime) {
            this.appointmentTime = appointmentTime;
            return this;
        }

        public AppointmentBuilder status(String status) {
            this.status = status;
            return this;
        }

        public AppointmentBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Appointment build() {
            return new Appointment(id, patientName, doctorName, appointmentTime, status, createdAt);
        }
    }
}