package com.cdent.inventario.controllers;

import com.cdent.inventario.models.Insumo;
import com.cdent.inventario.services.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InsumoController {
    @Autowired
    private InsumoService insumoService;

    @GetMapping
    public List<Insumo> listarInsumos() {
        return insumoService.obtenerTodos();
    }

    @PostMapping
    public Insumo crearInsumo(@RequestBody Insumo insumo) {
        return insumoService.guardarInsumo(insumo);
    }
}