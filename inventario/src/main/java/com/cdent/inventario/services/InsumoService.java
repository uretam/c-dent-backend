package com.cdent.inventario.services;

import com.cdent.inventario.models.Insumo;
import com.cdent.inventario.repositories.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;

    public List<Insumo> obtenerTodos() {
        return insumoRepository.findAll();
    }

    public Insumo guardarInsumo(Insumo insumo) {
        return insumoRepository.save(insumo);
    }
}