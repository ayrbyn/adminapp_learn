package com.admintest.app.adminapp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList; 
import java.util.List;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tanggal_transaksi", nullable = false)
    private LocalDateTime tanggalTransaksi;

    @Column(name = "total_harga", precision = 38, scale = 2)
    private BigDecimal totalHarga;

    @Column(name = "metode_pembayaran", nullable = false)
    private String metodePembayaran;

    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL)
    private List<DetailTransaksi> detailTransaksiList = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        tanggalTransaksi = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { 
        this.id = id;
    }

    public LocalDateTime getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(LocalDateTime tanggalTransaksi) { 
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public BigDecimal getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(BigDecimal totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public List<DetailTransaksi> getDetailTransaksiList() {
        return detailTransaksiList;
    }

    public void setDetailTransaksiList(List<DetailTransaksi> detailTransaksiList) {
        this.detailTransaksiList = detailTransaksiList;
    }
}