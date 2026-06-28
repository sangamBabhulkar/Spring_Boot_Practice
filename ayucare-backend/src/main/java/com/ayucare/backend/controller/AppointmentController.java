package com.ayucare.backend.controller;

import com.ayucare.backend.model.Appointment;
import com.ayucare.backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173") 
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/book")
    public ResponseEntity<Appointment> createAppointmentInquiry(@RequestBody Appointment appointment) {
        Appointment savedRecord = appointmentRepository.save(appointment);
        return ResponseEntity.ok(savedRecord);
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointmentsForReceptionDesk() {
        return appointmentRepository.findAll();
    }
}