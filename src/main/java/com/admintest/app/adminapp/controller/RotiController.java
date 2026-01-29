package com.admintest.app.adminapp.controller;

import com.admintest.app.adminapp.entity.Roti;
import com.admintest.app.adminapp.service.RotiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roti")
public class RotiController {

    private final RotiService rotiService;

    public RotiController(RotiService rotiService) {
        this.rotiService = rotiService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("daftarRoti", rotiService.getSemuaRoti());
        return "roti/index";
    }

    @GetMapping("/tambah")
    public String tambah(Model model) {
        model.addAttribute("roti", new Roti());
        return "roti/form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Roti roti) {
        rotiService.simpanRoti(roti);
        return "redirect:/roti";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("roti", rotiService.getRotiById(id));
        return "roti/form";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        rotiService.hapusRoti(id);
        return "redirect:/roti";
    }
}
