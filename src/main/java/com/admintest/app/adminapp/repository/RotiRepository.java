package com.admintest.app.adminapp.repository;

import com.admintest.app.adminapp.entity.Roti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RotiRepository extends JpaRepository<Roti, Long> {

    List<Roti> findByKategori(String kategori);
    long countByStatus(String status);

    @Query("SELECT COALESCE(SUM(r.stok), 0) FROM Roti r WHERE r.status = 'TERSEDIA'")
    long totalStokTersedia();
}