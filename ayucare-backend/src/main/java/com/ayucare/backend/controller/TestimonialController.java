package com.ayucare.backend.controller;

import com.ayucare.backend.model.Testimonial;
import com.ayucare.backend.repository.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
@CrossOrigin(origins = "http://localhost:5173")
public class TestimonialController {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @GetMapping
    public List<Testimonial> getVerifiedPatientReviews() {
        return testimonialRepository.findAll();
    }

    @PostMapping("/submit")
    public ResponseEntity<Testimonial> submitPatientReview(@RequestBody Testimonial testimonial) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        testimonial.setDate(LocalDateTime.now().format(formatter));
        
        Testimonial savedReview = testimonialRepository.save(testimonial);
        return ResponseEntity.ok(savedReview);
    }
    
 // Add this inside your TestimonialController class
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatientReview(@PathVariable Long id) {
        if (testimonialRepository.existsById(id)) {
            testimonialRepository.deleteById(id);
            return ResponseEntity.ok("Testimonial review deleted successfully from database.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}