package com.cdent.tratamientos.services;

import com.cdent.tratamientos.models.Tratamiento;
import com.cdent.tratamientos.repositories.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TratamientoService {
    @Autowired
    private TratamientoRepository tratamientoRepository;

    public List<Tratamiento> obtenerTodos() {
        return tratamientoRepository.findAll();
    }

    public Tratamiento guardarTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }
}