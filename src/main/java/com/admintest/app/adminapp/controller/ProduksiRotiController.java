package com.admintest.app.adminapp.controller;

import com.admintest.app.adminapp.entity.ProduksiRoti;
import com.admintest.app.adminapp.service.ProduksiRotiService;
import com.admintest.app.adminapp.service.RotiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produksi")
public class ProduksiRotiController {

    private final ProduksiRotiService produksiRotiService;
    private final RotiService rotiService;

    public ProduksiRotiController(ProduksiRotiService produksiRotiService,
                                  RotiService rotiService) {
        this.produksiRotiService = produksiRotiService;
        this.rotiService = rotiService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("daftarRoti", rotiService.getSemuaRoti());
        model.addAttribute("produksi", new ProduksiRoti());
        return "produksi/index";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute ProduksiRoti produksiRoti) {
        produksiRotiService.simpanProduksi(produksiRoti);
        return "redirect:/produksi";
    }
}
