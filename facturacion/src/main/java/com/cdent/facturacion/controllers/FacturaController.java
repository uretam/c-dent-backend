package com.cdent.facturacion.controllers;

import com.cdent.facturacion.models.Factura;
import com.cdent.facturacion.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/facturacion")
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.obtenerTodas();
    }

    @PostMapping
    public Factura crearFactura(@RequestBody Factura factura) {
        return facturaService.generarFactura(factura);
    }
}