package com.priado.controllers;

import com.priado.models.entities.ProyekLokasi;
import com.priado.models.entities.ProyekLokasiId;
import com.priado.services.ProyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiService.getAllProyekLokasi();
    }

    // Get ProyekLokasi by ID
    @GetMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<ProyekLokasi> getProyekLokasiById(@PathVariable int proyekId, @PathVariable int lokasiId) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        Optional<ProyekLokasi> proyekLokasi = proyekLokasiService.getProyekLokasiById(id);
        return proyekLokasi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new ProyekLokasi
    @PostMapping
    public ResponseEntity<ProyekLokasi> createProyekLokasi(@RequestBody ProyekLokasi proyekLokasi) {
        ProyekLokasi createdProyekLokasi = proyekLokasiService.saveProyekLokasi(proyekLokasi);
        return ResponseEntity.ok(createdProyekLokasi);
    }

    // Update existing ProyekLokasi
    @PutMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<ProyekLokasi> updateProyekLokasi(@PathVariable int proyekId, @PathVariable int lokasiId,
                                                            @RequestBody ProyekLokasi proyekLokasi) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        if (proyekLokasiService.getProyekLokasiById(id).isPresent()) {
            proyekLokasi.setProyek(proyekLokasi.getProyek());
            proyekLokasi.setLokasi(proyekLokasi.getLokasi());
            ProyekLokasi updatedProyekLokasi = proyekLokasiService.saveProyekLokasi(proyekLokasi);
            return ResponseEntity.ok(updatedProyekLokasi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete ProyekLokasi
    @DeleteMapping("/{proyekId}/{lokasiId}")
    public ResponseEntity<Void> deleteProyekLokasi(@PathVariable int proyekId, @PathVariable int lokasiId) {
        ProyekLokasiId id = new ProyekLokasiId(proyekId, lokasiId);
        if (proyekLokasiService.getProyekLokasiById(id).isPresent()) {
            proyekLokasiService.deleteProyekLokasi(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get locations by project ID
    @GetMapping("/proyek/{proyekId}/lokasi")
    public ResponseEntity<List<ProyekLokasi>> getLokasiByProyekId(@PathVariable int proyekId) {
        List<ProyekLokasi> lokasiList = proyekLokasiService.getLokasiByProyekId(proyekId);
        if (lokasiList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lokasiList);
        }
    }
}
