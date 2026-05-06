package com.cdent.fichasmedicas.services;

import com.cdent.fichasmedicas.models.FichaMedica;
import com.cdent.fichasmedicas.repositories.FichaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FichaMedicaService {
    @Autowired
    private FichaMedicaRepository fichaMedicaRepository;

    public List<FichaMedica> obtenerTodas() {
        return fichaMedicaRepository.findAll();
    }

    public FichaMedica guardarFicha(FichaMedica fichaMedica) {
        return fichaMedicaRepository.save(fichaMedica);
    }
}