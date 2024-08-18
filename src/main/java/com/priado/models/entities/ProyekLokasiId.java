package com.priado.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class ProyekLokasiId implements Serializable {

    private int proyek;
    private int lokasi;

    // Default constructor
    public ProyekLokasiId() {
    }

    // Constructor with parameters
    public ProyekLokasiId(int proyek, int lokasi) {
        this.proyek = proyek;
        this.lokasi = lokasi;
    }

    // Getters and Setters
    public int getProyek() {
        return proyek;
    }

    public void setProyek(int proyek) {
        this.proyek = proyek;
    }

    public int getLokasi() {
        return lokasi;
    }

    public void setLokasi(int lokasi) {
        this.lokasi = lokasi;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyekLokasiId that = (ProyekLokasiId) o;
        return proyek == that.proyek && lokasi == that.lokasi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyek, lokasi);
    }
}
