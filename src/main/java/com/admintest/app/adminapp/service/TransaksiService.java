package com.admintest.app.adminapp.service;

import com.admintest.app.adminapp.entity.DetailTransaksi;
import com.admintest.app.adminapp.entity.Roti;
import com.admintest.app.adminapp.entity.Transaksi;
import com.admintest.app.adminapp.repository.TransaksiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransaksiService {

    private final TransaksiRepository transaksiRepository;
    private final RotiService rotiService;

    public TransaksiService(TransaksiRepository transaksiRepository,
                            RotiService rotiService) {
        this.transaksiRepository = transaksiRepository;
        this.rotiService = rotiService;
    }

    @Transactional 
    public void simpanTransaksi(Transaksi transaksi) {

        BigDecimal total = BigDecimal.ZERO;

        for (DetailTransaksi detail : transaksi.getDetailTransaksiList()) {

            Roti rotiAsli = rotiService.getRotiById(detail.getRoti().getId());

            detail.setRoti(rotiAsli);

            BigDecimal hargaAsli = rotiAsli.getHarga();

        
            detail.setTransaksi(transaksi);

            rotiService.kurangiStok(
                    rotiAsli.getId(),
                    detail.getJumlah()
            );

            BigDecimal subtotal = hargaAsli.multiply(BigDecimal.valueOf(detail.getJumlah()));
            total = total.add(subtotal);
        }

        transaksi.setTotalHarga(total);
        transaksiRepository.save(transaksi);
    }

    public List<Transaksi> getSemuaTransaksi() {
        return transaksiRepository.findAll();
    }
}