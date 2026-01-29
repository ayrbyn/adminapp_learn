package com.admintest.app.adminapp.repository;

import com.admintest.app.adminapp.entity.Transaksi;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
     @Query("""
        SELECT COUNT(t) 
        FROM Transaksi t 
        WHERE t.tanggalTransaksi >= :start 
          AND t.tanggalTransaksi < :end
    """)
    long countTransaksiHariIni(LocalDateTime start, LocalDateTime end);
}
