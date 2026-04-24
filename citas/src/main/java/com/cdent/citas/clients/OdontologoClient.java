package com.cdent.citas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Puerto 9092 (Odontologo)
@FeignClient(name = "odontologos-service", url = "http://localhost:9092/api/odontologos")
public interface OdontologoClient {
    @GetMapping("/{id}")
    Object obtenerOdontologoPorId(@PathVariable("id") Long id);
}