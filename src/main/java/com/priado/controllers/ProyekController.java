package com.priado.controllers;

import com.priado.models.entities.Proyek;
import com.priado.services.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyek")
@CrossOrigin(origins = "http://localhost")  // Mengizinkan akses CORS dari http://localhost
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    // Get all proyek
    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        List<Proyek> proyekList = proyekService.getAllProyek();
        return new ResponseEntity<>(proyekList, HttpStatus.OK);
    }

    // Get proyek by ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable("id") int id) {
        Optional<Proyek> proyek = proyekService.getProyekById(id);
        return proyek.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new proyek
    @PostMapping
    public ResponseEntity<Proyek> createProyek(@RequestBody Proyek proyek) {
        try {
            Proyek savedProyek = proyekService.saveProyek(proyek);
            return new ResponseEntity<>(savedProyek, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing proyek
    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable("id") int id, @RequestBody Proyek proyek) {
        Optional<Proyek> existingProyek = proyekService.getProyekById(id);
        if (existingProyek.isPresent()) {
            proyek.setId(id);
            Proyek updatedProyek = proyekService.saveProyek(proyek);
            return new ResponseEntity<>(updatedProyek, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a proyek
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable("id") int id) {
        Optional<Proyek> existingProyek = proyekService.getProyekById(id);
        if (existingProyek.isPresent()) {
            proyekService.deleteProyek(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
