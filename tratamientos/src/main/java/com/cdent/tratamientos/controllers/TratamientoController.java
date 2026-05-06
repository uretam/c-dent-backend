package com.cdent.tratamientos.controllers;

import com.cdent.tratamientos.models.Tratamiento;
import com.cdent.tratamientos.services.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping
    public List<Tratamiento> listarTratamientos() {
        return tratamientoService.obtenerTodos();
    }

    @PostMapping
    public Tratamiento crearTratamiento(@RequestBody Tratamiento tratamiento) {
        return tratamientoService.guardarTratamiento(tratamiento);
    }
}