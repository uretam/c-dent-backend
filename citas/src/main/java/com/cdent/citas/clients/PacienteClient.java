package com.cdent.citas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// puerto 9091 (Pacientes)
@FeignClient(name = "pacientes-service", url = "http://localhost:9091/api/pacientes")
public interface PacienteClient {
    
    @GetMapping("/{id}")
    Object obtenerPacientePorId(@PathVariable("id") Long id);
}