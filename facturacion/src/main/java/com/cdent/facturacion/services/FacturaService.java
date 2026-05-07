package com.cdent.facturacion.services;

import com.cdent.facturacion.models.Factura;
import com.cdent.facturacion.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> obtenerTodas() {
        return facturaRepository.findAll();
    }

    public Factura generarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }
}