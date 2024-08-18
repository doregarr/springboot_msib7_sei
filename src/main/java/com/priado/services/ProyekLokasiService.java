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

    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }

    public Optional<ProyekLokasi> getProyekLokasiById(ProyekLokasiId id) {
        return proyekLokasiRepository.findById(id);
    }

    public ProyekLokasi saveProyekLokasi(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }

    public void deleteProyekLokasi(ProyekLokasiId id) {
        proyekLokasiRepository.deleteById(id);
    }
}
