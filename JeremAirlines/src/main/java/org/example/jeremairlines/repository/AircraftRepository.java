package org.example.jeremairlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.jeremairlines.model.Aircraft;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    // Trouver les avions par marque
    List<Aircraft> findByBrand(String brand);

    // Trouver les avions par statut
    List<Aircraft> findByStatus(String status);

    // Trouver les avions avec une capacité supérieure à une certaine valeur
    List<Aircraft> findByCapacityGreaterThan(int capacity);
}
