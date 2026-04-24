package com.cdent.pacientes.controllers;

import com.cdent.pacientes.models.Paciente;
import com.cdent.pacientes.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.obtenerTodos();
    }

    @PostMapping
    public Paciente crearPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }

@GetMapping("/{id}")
    public Paciente obtenerPorId(@PathVariable Long id) {
        return pacienteService.obtenerTodos().stream()
                .filter(p -> p.getIdPaciente().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }
}