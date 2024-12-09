package org.example.jeremairlines.controller;

import org.example.jeremairlines.model.Aircraft;
import org.example.jeremairlines.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {

    @Autowired
    private AircraftRepository repository;

    // Récupérer tous les avions
    @GetMapping
    public List<Aircraft> getAllAircrafts() {
        return repository.findAll();
    }

    // Ajouter un nouvel avion
    @PostMapping
    public Aircraft addAircraft(@RequestBody Aircraft aircraft) {
        return repository.save(aircraft);
    }

    // Récupérer un avion par ID
    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Supprimer un avion par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAircraft(@PathVariable Long id) {
        return repository.findById(id)
                .map(aircraft -> {
                    repository.delete(aircraft);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
