package com.admintest.app.adminapp.service;

import com.admintest.app.adminapp.entity.Roti;
import com.admintest.app.adminapp.repository.RotiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotiService {

    private final RotiRepository rotiRepository;

    public RotiService(RotiRepository rotiRepository) {
        this.rotiRepository = rotiRepository;
    }

    public List<Roti> getSemuaRoti() {
        return rotiRepository.findAll();
    }

    public Roti getRotiById(Long id) {
        return rotiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Roti tidak ditemukan"));
    }

    public Roti simpanRoti(Roti roti) {
        Integer stok = roti.getStok();

        if (stok == null || stok <= 0) {
            roti.setStatus("HABIS");
        } else {
            roti.setStatus("TERSEDIA");
        }

        return rotiRepository.save(roti);
    }

    public void hapusRoti(Long id) {
        rotiRepository.deleteById(id);
    }

    public void tambahStok(Long rotiId, int jumlah) {
        Roti roti = getRotiById(rotiId);
        roti.setStok(roti.getStok() + jumlah);
        
        if (roti.getStok() > 0) {
            roti.setStatus("TERSEDIA");
        }
        
        rotiRepository.save(roti);
    }

    public void kurangiStok(Long rotiId, int jumlah) {
        Roti roti = getRotiById(rotiId);
        if (roti.getStok() < jumlah) {
            throw new RuntimeException("Stok roti tidak mencukupi");
        }
        roti.setStok(roti.getStok() - jumlah);

        if (roti.getStok() == 0) {
            roti.setStatus("HABIS");
        }

        rotiRepository.save(roti);
    }
    
    public long hitungRotiByStatus(String status) {
        return rotiRepository.countByStatus(status);
    }

    public long totalStokTersedia() {
        return rotiRepository.totalStokTersedia(); 
    }
}