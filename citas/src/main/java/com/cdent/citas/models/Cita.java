package com.cdent.citas.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    @Column(nullable = false)
    private Long idPaciente; // ID del puerto 9091

    @Column(nullable = false)
    private Long idOdontologo; // ID del puerto 9092

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    private String motivo;
    
    private String estado = "AGENDADA"; // AGENDADA, CANCELADA, COMPLETADA
}