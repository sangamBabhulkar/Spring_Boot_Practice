package com.hospital.management.service;

import com.hospital.management.dto.AppointmentRequestDTO;
import com.hospital.management.entity.Appointment;
import com.hospital.management.exception.ResourceNotFoundException;
import com.hospital.management.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    // Constructor Injection (Industry Best Practice)
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    
    public List<Appointment> getAppointmentsByDoctor(String doctorName) {
        return appointmentRepository.findByDoctorName(doctorName);
    }

    @Transactional
    public Appointment scheduleAppointment(AppointmentRequestDTO dto) {
        Appointment appointment = Appointment.builder()
                .patientName(dto.getPatientName())
                .doctorName(dto.getDoctorName())
                .appointmentTime(dto.getAppointmentTime())
                .status("SCHEDULED")
                .build();

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
 // ===================================================================
 // UPDATE: Change appointment details or status
 // ===================================================================
 @Transactional
 public Appointment updateAppointmentStatus(Long id, String newStatus) {
     // Find the appointment first. If it doesn't exist, throw an exception
     Appointment appointment = appointmentRepository.findById(id)
    		// Change your .orElseThrow line to look like this:
    		 .orElseThrow(() -> new ResourceNotFoundException("Appointment record missing for ID: " + id));
     
     // Update the status
     appointment.setStatus(newStatus);
     
     // Save it back to the database
     return appointmentRepository.save(appointment);
 }

 // ===================================================================
 // DELETE: Remove an appointment from the database
 // ===================================================================
 @Transactional
 public void deleteAppointment(Long id) {
     if (!appointmentRepository.existsById(id)) {
         throw new RuntimeException("Cannot delete. Appointment not found with id: " + id);
     }
     appointmentRepository.deleteById(id);
 }
}