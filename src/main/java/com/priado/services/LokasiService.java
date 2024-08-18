package com.priado.services;

import com.priado.models.entities.Lokasi;
import com.priado.models.repositories.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    // Mendapatkan semua data lokasi
    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    // Mendapatkan data lokasi berdasarkan ID
    public Optional<Lokasi> getLokasiById(int id) {
        return lokasiRepository.findById(id);
    }

    // Menyimpan data lokasi
    public Lokasi saveLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    // Menghapus data lokasi berdasarkan ID
    public void deleteLokasi(int id) {
        if (lokasiRepository.existsById(id)) {
            lokasiRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Lokasi with id " + id + " does not exist");
        }
    }
}
