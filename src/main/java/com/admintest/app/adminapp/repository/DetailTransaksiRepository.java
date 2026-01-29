package com.admintest.app.adminapp.repository;

import com.admintest.app.adminapp.entity.DetailTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailTransaksiRepository extends JpaRepository<DetailTransaksi, Long> {

    List<DetailTransaksi> findByTransaksiId(Long transaksiId);

}
