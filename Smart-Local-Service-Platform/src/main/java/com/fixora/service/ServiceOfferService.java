package com.fixora.service;

import com.fixora.model.ServiceOffer;
import com.fixora.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ServiceOfferService {

    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceOffer createService(ServiceOffer serviceOffer) {
        // Business logic rule: Price cannot be free or negative
        if (serviceOffer.getPrice() == null || serviceOffer.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        return serviceRepository.save(serviceOffer);
    }

    public List<ServiceOffer> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<ServiceOffer> getServicesByCategory(String category) {
        return serviceRepository.findByCategoryIgnoreCase(category);
    }
}