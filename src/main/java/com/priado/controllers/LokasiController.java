package com.priado.controllers;

import com.priado.models.entities.Lokasi;
import com.priado.services.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lokasi")
@CrossOrigin(origins = "http://localhost") 
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    // Get all lokasi
    @GetMapping
    public ResponseEntity<List<Lokasi>> getAllLokasi() {
        List<Lokasi> lokasiList = lokasiService.getAllLokasi();
        return new ResponseEntity<>(lokasiList, HttpStatus.OK);
    }

    // Get lokasi by ID
    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable("id") int id) { 
        Optional<Lokasi> lokasi = lokasiService.getLokasiById(id);
        if (lokasi.isPresent()) {
            return new ResponseEntity<>(lokasi.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new lokasi
    @PostMapping
    public ResponseEntity<Lokasi> createLokasi(@RequestBody Lokasi lokasi) {
        Lokasi savedLokasi = lokasiService.saveLokasi(lokasi);
        return new ResponseEntity<>(savedLokasi, HttpStatus.CREATED);
    }

    // Update an existing lokasi
    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable("id") int id, @RequestBody Lokasi lokasi) {
        if (lokasiService.getLokasiById(id).isPresent()) {
            lokasi.setId(id);
            Lokasi updatedLokasi = lokasiService.saveLokasi(lokasi);
            return new ResponseEntity<>(updatedLokasi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a lokasi
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable("id") int id) {
        if (lokasiService.getLokasiById(id).isPresent()) {
            lokasiService.deleteLokasi(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
