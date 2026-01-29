package com.admintest.app.adminapp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "roti")
public class Roti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_roti", nullable = false)
    private String namaRoti;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "harga", nullable = false)
    private BigDecimal harga;

    @Column(name = "stok", nullable = false)
    private Integer stok;

    @Column(name = "status")
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaRoti() {
        return namaRoti;
    }

    public void setNamaRoti(String namaRoti) {
        this.namaRoti = namaRoti;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}