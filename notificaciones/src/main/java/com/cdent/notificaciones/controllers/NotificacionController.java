package com.cdent.notificaciones.controllers;

import com.cdent.notificaciones.models.Notificacion;
import com.cdent.notificaciones.services.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public List<Notificacion> listarNotificaciones() {
        return notificacionService.obtenerTodas();
    }

    @PostMapping
    public Notificacion crearNotificacion(@RequestBody Notificacion notificacion) {
        return notificacionService.enviarYGuardarNotificacion(notificacion);
    }
}