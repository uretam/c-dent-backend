package com.cdent.odontologos.services;

import com.cdent.odontologos.models.Odontologo;
import com.cdent.odontologos.repositories.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;

    public List<Odontologo> obtenerTodos() {
        return odontologoRepository.findAll();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
}