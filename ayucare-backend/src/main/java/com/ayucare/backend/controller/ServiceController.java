package com.ayucare.backend.controller;

import com.ayucare.backend.model.ServiceItem;
import com.ayucare.backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    // 1. Get services filtered by type (used by public Ayurvedic/Cosmetic pages)
    @GetMapping("/type/{type}")
    public List<ServiceItem> getServicesByType(@PathVariable String type) {
        return serviceRepository.findByType(type);
    }

    // 2. Get ALL services (used by the Admin Dashboard management list)
    @GetMapping("/all")
    public List<ServiceItem> getAllServices() {
        return serviceRepository.findAll();
    }

    // 3. Add a brand new treatment service
    @PostMapping("/add")
    public ResponseEntity<ServiceItem> addService(@RequestBody ServiceItem serviceItem) {
        ServiceItem savedItem = serviceRepository.save(serviceItem);
        return ResponseEntity.ok(savedItem);
    }

    // 4. Update an existing treatment's text details
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceItem> updateService(@PathVariable Long id, @RequestBody ServiceItem updatedDetails) {
        Optional<ServiceItem> existingService = serviceRepository.findById(id);
        
        if (existingService.isPresent()) {
            ServiceItem item = existingService.get();
            item.setTitle(updatedDetails.getTitle());
            item.setDesc(updatedDetails.getDesc());
            item.setBenefits(updatedDetails.getBenefits());
            item.setIcon(updatedDetails.getIcon());
            item.setType(updatedDetails.getType());
            
            return ResponseEntity.ok(serviceRepository.save(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. Delete a treatment completely
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return ResponseEntity.ok("Service dropped successfully from database.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}