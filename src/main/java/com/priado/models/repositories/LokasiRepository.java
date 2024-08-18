package com.priado.models.repositories;

import com.priado.models.entities.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
    // Metode khusus bisa ditambahkan di sini jika diperlukan
}
