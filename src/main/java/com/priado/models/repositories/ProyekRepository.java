package com.priado.models.repositories;

import com.priado.models.entities.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
    // Metode khusus bisa ditambahkan di sini jika diperlukan
}
