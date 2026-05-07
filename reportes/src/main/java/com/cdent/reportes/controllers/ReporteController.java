package com.cdent.reportes.controllers;

import com.cdent.reportes.models.Reporte;
import com.cdent.reportes.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Reporte> listarReportes() {
        return reporteService.obtenerTodos();
    }

    @PostMapping
    public Reporte crearReporte(@RequestBody Reporte reporte) {
        return reporteService.guardarReporte(reporte);
    }
}