package com.admintest.app.adminapp.controller;

import com.admintest.app.adminapp.entity.Transaksi;
import com.admintest.app.adminapp.service.RotiService;
import com.admintest.app.adminapp.service.TransaksiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Controller
public class DashboardController {

    private final RotiService rotiService;
    private final TransaksiService transaksiService;

    // Inject TransaksiService di Constructor
    public DashboardController(RotiService rotiService, TransaksiService transaksiService) {
        this.rotiService = rotiService;
        this.transaksiService = transaksiService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        // --- Bagian Stok Roti ---
        model.addAttribute("jumlahRotiTersedia",
                rotiService.hitungRotiByStatus("TERSEDIA"));

        model.addAttribute("totalStok",
                rotiService.totalStokTersedia());

        // --- Bagian Summary Transaksi (BARU) ---
        List<Transaksi> semuaTransaksi = transaksiService.getSemuaTransaksi();

        // 1. Hitung Jumlah Transaksi
        int jumlahTransaksi = semuaTransaksi.size();

        // 2. Hitung Total Pendapatan (Sum dari totalHarga)
        BigDecimal totalPendapatan = semuaTransaksi.stream()
                .map(Transaksi::getTotalHarga)
                .filter(Objects::nonNull) // Hindari error jika ada data null
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("jumlahTransaksi", jumlahTransaksi);
        model.addAttribute("totalPendapatan", totalPendapatan);

        model.addAttribute("title", "Dashboard");

        return "dashboard/index";
    }
}