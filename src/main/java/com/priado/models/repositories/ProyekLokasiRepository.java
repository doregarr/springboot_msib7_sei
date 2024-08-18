package com.priado.models.repositories;

import com.priado.models.entities.ProyekLokasi;
import com.priado.models.entities.ProyekLokasiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, ProyekLokasiId> {
}
