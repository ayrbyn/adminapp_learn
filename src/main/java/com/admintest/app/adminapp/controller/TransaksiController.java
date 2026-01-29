package com.admintest.app.adminapp.controller;

import com.admintest.app.adminapp.entity.DetailTransaksi; 
import com.admintest.app.adminapp.entity.Transaksi;
import com.admintest.app.adminapp.service.RotiService;
import com.admintest.app.adminapp.service.TransaksiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

    private final TransaksiService transaksiService;
    private final RotiService rotiService;

    public TransaksiController(TransaksiService transaksiService,
                               RotiService rotiService) {
        this.transaksiService = transaksiService;
        this.rotiService = rotiService;
    }

    @GetMapping("/baru")
    public String transaksiBaru(Model model) {
        Transaksi transaksi = new Transaksi();
        
        transaksi.setDetailTransaksiList(new ArrayList<>());
        
        transaksi.getDetailTransaksiList().add(new DetailTransaksi());
        
        model.addAttribute("transaksi", transaksi);
        model.addAttribute("daftarRoti", rotiService.getSemuaRoti());
        return "transaksi/form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Transaksi transaksi,
                         RedirectAttributes redirectAttributes) {
        
        if (transaksi.getDetailTransaksiList() == null || transaksi.getDetailTransaksiList().isEmpty()) {
            
        }

        // Logic penting: Set 'transaksi' induk ke setiap 'detail' anak
        for (DetailTransaksi detail : transaksi.getDetailTransaksiList()) {
            detail.setTransaksi(transaksi);
        }

        transaksiService.simpanTransaksi(transaksi);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Transaksi berhasil disimpan!"
        );

        return "redirect:/transaksi/riwayat";
    }

    @GetMapping("/riwayat")
    public String riwayat(Model model) {
        model.addAttribute("daftarTransaksi",
                transaksiService.getSemuaTransaksi());
        return "transaksi/riwayat";
    }
}