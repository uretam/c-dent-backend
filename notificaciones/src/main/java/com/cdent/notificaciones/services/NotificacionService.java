package com.cdent.notificaciones.services;

import com.cdent.notificaciones.models.Notificacion;
import com.cdent.notificaciones.repositories.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> obtenerTodas() {
        return notificacionRepository.findAll();
    }

    public Notificacion enviarYGuardarNotificacion(Notificacion notificacion) {
        System.out.println("Enviando correo a: " + notificacion.getCorreoDestinatario());
        System.out.println("Asunto: " + notificacion.getAsunto());
        
        return notificacionRepository.save(notificacion);
    }
}