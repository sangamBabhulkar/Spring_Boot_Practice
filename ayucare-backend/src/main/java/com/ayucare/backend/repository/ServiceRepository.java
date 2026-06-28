package com.ayucare.backend.repository;

import com.ayucare.backend.model.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceItem, Long> {
    // Custom finder method to filter by 'ayurvedic' or 'cosmetic-hair'
    List<ServiceItem> findByType(String type);
}