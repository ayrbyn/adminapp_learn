package com.admintest.app.adminapp.service;

import com.admintest.app.adminapp.entity.ProduksiRoti;
import com.admintest.app.adminapp.repository.ProduksiRotiRepository;
import org.springframework.stereotype.Service;

@Service
public class ProduksiRotiService {

    private final ProduksiRotiRepository produksiRotiRepository;
    private final RotiService rotiService;

    public ProduksiRotiService(ProduksiRotiRepository produksiRotiRepository,
                               RotiService rotiService) {
        this.produksiRotiRepository = produksiRotiRepository;
        this.rotiService = rotiService;
    }

    public ProduksiRoti simpanProduksi(ProduksiRoti produksiRoti) {
        rotiService.tambahStok(
                produksiRoti.getRoti().getId(),
                produksiRoti.getJumlahProduksi()
        );
        return produksiRotiRepository.save(produksiRoti);
    }
}
