package com.fixora.controller;

import com.fixora.model.ServiceOffer;
import com.fixora.service.ServiceOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceOfferController {

    @Autowired
    private ServiceOfferService serviceOfferService;

    @PostMapping
    public ResponseEntity<?> createService(@RequestBody ServiceOffer serviceOffer) {
        try {
            ServiceOffer savedService = serviceOfferService.createService(serviceOffer);
            return ResponseEntity.ok(savedService);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ServiceOffer>> getAllServices() {
        return ResponseEntity.ok(serviceOfferService.getAllServices());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ServiceOffer>> getServicesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(serviceOfferService.getServicesByCategory(category));
    }
}