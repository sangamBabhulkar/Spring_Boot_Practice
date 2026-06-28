package com.fixora.repository;

import com.fixora.model.ServiceOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceOffer, Long> {
    // Custom finder method to filter by category type
    List<ServiceOffer> findByCategoryIgnoreCase(String category);
}