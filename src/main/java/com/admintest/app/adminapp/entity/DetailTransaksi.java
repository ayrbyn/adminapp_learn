package com.admintest.app.adminapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_transaksi")
public class DetailTransaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaksi_id", nullable = false)
    private Transaksi transaksi;


    @ManyToOne
    @JoinColumn(name = "roti_id", nullable = false)
    private Roti roti;

    @Column(name = "jumlah", nullable = false)
    private Integer jumlah;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Roti getRoti() {
        return roti;
    }

    public void setRoti(Roti roti) {
        this.roti = roti;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
}