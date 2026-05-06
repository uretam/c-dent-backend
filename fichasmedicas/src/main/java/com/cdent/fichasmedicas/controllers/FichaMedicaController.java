package com.cdent.fichasmedicas.controllers;

import com.cdent.fichasmedicas.models.FichaMedica;
import com.cdent.fichasmedicas.services.FichaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fichas")
public class FichaMedicaController {
    @Autowired
    private FichaMedicaService fichaMedicaService;

    @GetMapping
    public List<FichaMedica> listarFichas() {
        return fichaMedicaService.obtenerTodas();
    }

    @PostMapping
    public FichaMedica crearFicha(@RequestBody FichaMedica fichaMedica) {
        return fichaMedicaService.guardarFicha(fichaMedica);
    }
}