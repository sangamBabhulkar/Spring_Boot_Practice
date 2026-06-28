package com.hospital.management.controller;

import com.hospital.management.dto.AppointmentRequestDTO;
import com.hospital.management.entity.Appointment;
import com.hospital.management.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Constructor Injection
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody AppointmentRequestDTO request) {
        // Debug logs to see what Postman is sending into Eclipse
        System.out.println("=========================================");
        System.out.println("RECEIVED PATIENT FROM POSTMAN: " + request.getPatientName());
        System.out.println("RECEIVED DOCTOR FROM POSTMAN: " + request.getDoctorName());
        System.out.println("RECEIVED TIME FROM POSTMAN: " + request.getAppointmentTime());
        System.out.println("=========================================");

        Appointment savedAppointment = appointmentService.scheduleAppointment(request);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }
    
 // URL format: http://localhost:8080/api/v1/appointments/search?doctor=Dr. Sharma
    @GetMapping("/search")
    public ResponseEntity<List<Appointment>> getByDoctor(@RequestParam String doctor) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctor);
        return ResponseEntity.ok(appointments);
    }
    
 // ===================================================================
 // UPDATE: PUT http://localhost:8080/api/v1/appointments/{id}/status
 // ===================================================================
 @PutMapping("/{id}/status")
 public ResponseEntity<Appointment> updateStatus(@PathVariable Long id, @RequestParam String status) {
     Appointment updated = appointmentService.updateAppointmentStatus(id, status);
     return ResponseEntity.ok(updated);
 }

 // ===================================================================
 // DELETE: DELETE http://localhost:8080/api/v1/appointments/{id}
 // ===================================================================
 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
     appointmentService.deleteAppointment(id);
     return ResponseEntity.ok("Appointment with ID " + id + " has been successfully deleted.");
 }
 
 
}