package com.cdent.pacientes.services;

import com.cdent.pacientes.models.Paciente;
import com.cdent.pacientes.models.ContactoEmergencia;
import com.cdent.pacientes.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> obtenerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> obtenerPorRut(String rut) {
        return pacienteRepository.findByRut(rut);
    }

    public Paciente guardarPaciente(Paciente paciente) {
        if (paciente.getContactos() != null && !paciente.getContactos().isEmpty()) {
            for (ContactoEmergencia contacto : paciente.getContactos()) {
                contacto.setPaciente(paciente);
            }
        }
        return pacienteRepository.save(paciente);
    }

    public Paciente actualizarPaciente(Long id, Paciente pacienteActualizado) {
        Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);
        if (pacienteExistente.isPresent()) {
            Paciente paciente = pacienteExistente.get();
            paciente.setRut(pacienteActualizado.getRut());
            paciente.setNombres(pacienteActualizado.getNombres());
            paciente.setApellidos(pacienteActualizado.getApellidos());
            paciente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
            paciente.setEmail(pacienteActualizado.getEmail());
            paciente.setTelefono(pacienteActualizado.getTelefono());
            paciente.setDireccion(pacienteActualizado.getDireccion());
            paciente.setActivo(pacienteActualizado.getActivo());

            if (pacienteActualizado.getContactos() != null) {
                paciente.setContactos(pacienteActualizado.getContactos());
                for (ContactoEmergencia contacto : paciente.getContactos()) {
                    contacto.setPaciente(paciente);
                }
            }

            return pacienteRepository.save(paciente);
        }
        throw new RuntimeException("Paciente no encontrado con id: " + id);
    }

    public void eliminarPaciente(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Paciente no encontrado con id: " + id);
        }
    }
}