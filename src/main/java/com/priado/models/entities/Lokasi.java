package com.priado.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "lokasi")
public class Lokasi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_lokasi", nullable = false, length = 100)
    private String namaLokasi;

    @Column(name = "negara", nullable = false, length = 100)
    private String negara;

    @Column(name = "provinsi", nullable = false, length = 100)
    private String provinsi;

    @Column(name = "kota", nullable = false, length = 100)
    private String kota;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    // Constructor tanpa parameter (default)
    public Lokasi() {
    }

    // Constructor dengan parameter
    public Lokasi(int id, String namaLokasi, String negara, String provinsi, String kota, LocalDateTime createdAt) {
        this.id = id;
        this.namaLokasi = namaLokasi;
        this.negara = negara;
        this.provinsi = provinsi;
        this.kota = kota;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
