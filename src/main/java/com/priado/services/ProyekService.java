package com.priado.services;

import com.priado.models.entities.Proyek;
import com.priado.models.repositories.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    // Mendapatkan semua data proyek
    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    // Mendapatkan data proyek berdasarkan ID
    public Optional<Proyek> getProyekById(int id) {
        return proyekRepository.findById(id);
    }

    // Menyimpan data proyek
    public Proyek saveProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    // Menghapus data proyek berdasarkan ID
    public void deleteProyek(int id) {
        if (proyekRepository.existsById(id)) {
            proyekRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Proyek with id " + id + " does not exist");
        }
    }
}
