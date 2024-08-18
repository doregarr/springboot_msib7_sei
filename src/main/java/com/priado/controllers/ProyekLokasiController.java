package com.priado.controllers;

import com.priado.models.entities.ProyekLokasi;
import com.priado.models.entities.ProyekLokasiId;
import com.priado.services.ProyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyek-lokasi")
@CrossOrigin(origins = "http://localhost")
public class ProyekLokasiController {

    @Autowired
    private ProyekLokasiService proyekLokasiService;

    // Get all ProyekLokasi
    @GetMapping
    public ResponseEntity<?> getAllProyekLokasi() {
        try {
            List<ProyekLokasi> proyekLokasiList = proyekLokasiService.getAllProyekLokasi();
            if (proyekLokasiList.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(proyekLokasiList);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Gagal mengambil data: " + e.getMessage());
        }
    }

    // Get ProyekLokasi by ID
    @GetMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<?> getProyekLokasiById(@PathVariable int proyekId, @PathVariable int lokasiId) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        Optional<ProyekLokasi> proyekLokasi = proyekLokasiService.getProyekLokasiById(id);
        if (proyekLokasi.isPresent()) {
            return ResponseEntity.ok(proyekLokasi.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Data tidak ditemukan!");
        }
    }

    // Create new ProyekLokasi
    @PostMapping
    public ResponseEntity<?> createProyekLokasi(@RequestBody ProyekLokasi proyekLokasi) {
        try {
            ProyekLokasi createdProyekLokasi = proyekLokasiService.saveProyekLokasi(proyekLokasi);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProyekLokasi);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Gagal menambahkan data: " + e.getMessage());
        }
    }

    // Update existing ProyekLokasi
    @PutMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<?> updateProyekLokasi(@PathVariable int proyekId, @PathVariable int lokasiId,
                                                @RequestBody ProyekLokasi proyekLokasi) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        if (proyekLokasiService.getProyekLokasiById(id).isPresent()) {
            proyekLokasi.setProyek(proyekLokasi.getProyek());
            proyekLokasi.setLokasi(proyekLokasi.getLokasi());
            ProyekLokasi updatedProyekLokasi = proyekLokasiService.saveProyekLokasi(proyekLokasi);
            return ResponseEntity.ok(updatedProyekLokasi);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Data tidak ditemukan untuk diperbarui!");
        }
    }

    // Delete ProyekLokasi
    @DeleteMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<?> deleteProyekLokasi(@PathVariable int proyekId, @PathVariable int lokasiId) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        if (proyekLokasiService.getProyekLokasiById(id).isPresent()) {
            proyekLokasiService.deleteProyekLokasi(id);
            return ResponseEntity.ok("Data berhasil dihapus!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Data tidak ditemukan untuk dihapus!");
        }
    }

    // Get locations by project ID
    @GetMapping("/proyek/{proyekId}/lokasi")
    public ResponseEntity<?> getLokasiByProyekId(@PathVariable int proyekId) {
        try {
            List<ProyekLokasi> lokasiList = proyekLokasiService.getLokasiByProyekId(proyekId);
            if (lokasiList.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(lokasiList);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Gagal mengambil data: " + e.getMessage());
        }
    }
}
