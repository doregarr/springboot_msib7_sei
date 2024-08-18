package com.priado.services;

import com.priado.models.entities.ProyekLokasi;
import com.priado.models.entities.ProyekLokasiId;
import com.priado.models.repositories.ProyekLokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekLokasiService {

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    // Mengambil semua ProyekLokasi
    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }

    // Mengambil ProyekLokasi berdasarkan ID
    public Optional<ProyekLokasi> getProyekLokasiById(ProyekLokasiId id) {
        return proyekLokasiRepository.findById(id);
    }

    // Menyimpan atau memperbarui ProyekLokasi
    public ProyekLokasi saveProyekLokasi(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }

    // Menghapus ProyekLokasi berdasarkan ID
    public void deleteProyekLokasi(ProyekLokasiId id) {
        proyekLokasiRepository.deleteById(id);
    }

    // Menambahkan metode untuk mengambil lokasi berdasarkan ID proyek
    public List<ProyekLokasi> getLokasiByProyekId(int proyekId) {
        return proyekLokasiRepository.findByProyekId(proyekId);
    }
}
