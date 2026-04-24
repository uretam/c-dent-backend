package com.cdent.odontologos.controllers;

import com.cdent.odontologos.models.Odontologo;
import com.cdent.odontologos.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping
    public List<Odontologo> listarOdontologos() {
        return odontologoService.obtenerTodos();
    }

    @PostMapping
    public Odontologo crearOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.guardarOdontologo(odontologo);
    }

    @GetMapping("/{id}")
    public Odontologo obtenerPorId(@PathVariable Long id) {
        return odontologoService.obtenerTodos().stream()
                .filter(o -> o.getIdOdontologo().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Odontólogo no encontrado"));
    }
}