package com.cdent.citas.services;

import com.cdent.citas.clients.OdontologoClient;
import com.cdent.citas.clients.PacienteClient;
import com.cdent.citas.models.Cita;
import com.cdent.citas.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PacienteClient pacienteClient;

    @Autowired
    private OdontologoClient odontologoClient;

    public Cita agendarCita(Cita cita) {
        // Validacion de paciente (puerto 9091)
        try {
            pacienteClient.obtenerPacientePorId(cita.getIdPaciente());
        } catch (Exception e) {
            throw new RuntimeException("Error: El paciente con ID " + cita.getIdPaciente() + " no existe.");
        }

        // Validacion de odontologo (puerto 9092)
        try {
            odontologoClient.obtenerOdontologoPorId(cita.getIdOdontologo());
        } catch (Exception e) {
            throw new RuntimeException("Error: El odontólogo con ID " + cita.getIdOdontologo() + " no existe.");
        }

        return citaRepository.save(cita);
    }
}