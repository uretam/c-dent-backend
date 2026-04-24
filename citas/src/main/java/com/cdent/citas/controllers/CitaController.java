package com.cdent.citas.controllers;

import com.cdent.citas.models.Cita;
import com.cdent.citas.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping
    public Cita crearCita(@RequestBody Cita cita) {
        return citaService.agendarCita(cita);
    }
}