package com.cdent.reportes.services;

import com.cdent.reportes.models.Reporte;
import com.cdent.reportes.repositories.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }

    public Reporte guardarReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }
}