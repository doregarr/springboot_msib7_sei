package com.priado.models.repositories;

import com.priado.models.entities.ProyekLokasi;
import com.priado.models.entities.ProyekLokasiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, ProyekLokasiId> {

    // Method untuk menemukan lokasi berdasarkan ID proyek
    List<ProyekLokasi> findByProyekId(int proyekId);
}
