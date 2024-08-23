package com.priado.models.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType; // Import ini jika belum ada

@Entity
@Table(name = "proyek_lokasi")
@IdClass(ProyekLokasiId.class)
public class ProyekLokasi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne(fetch = FetchType.EAGER) // Menggunakan FetchType.EAGER
    @JoinColumn(name = "proyek_id", referencedColumnName = "id", nullable = false)
    private Proyek proyek;

    @Id
    @ManyToOne(fetch = FetchType.EAGER) // Menggunakan FetchType.EAGER
    @JoinColumn(name = "lokasi_id", referencedColumnName = "id", nullable = false)
    private Lokasi lokasi;

    // Default constructor
    public ProyekLokasi() {
    }

    // Constructor with parameters
    public ProyekLokasi(Proyek proyek, Lokasi lokasi) {
        this.proyek = proyek;
        this.lokasi = lokasi;
    }

    // Getters and Setters
    public Proyek getProyek() {
        return proyek;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }
}
