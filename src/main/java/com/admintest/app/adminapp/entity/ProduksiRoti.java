package com.admintest.app.adminapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "produksi_roti")
public class ProduksiRoti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roti_id", nullable = false)
    private Roti roti;

    @Column(name = "tanggal_produksi", nullable = false)
    private LocalDate tanggalProduksi;

    @Column(name = "jumlah_produksi", nullable = false)
    private Integer jumlahProduksi;

    @PrePersist
    protected void onCreate() {
        tanggalProduksi = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public Roti getRoti() {
        return roti;
    }

    public void setRoti(Roti roti) {
        this.roti = roti;
    }

    public LocalDate getTanggalProduksi() {
        return tanggalProduksi;
    }

    public Integer getJumlahProduksi() {
        return jumlahProduksi;
    }

    public void setJumlahProduksi(Integer jumlahProduksi) {
        this.jumlahProduksi = jumlahProduksi;
    }
}
