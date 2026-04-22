package com.cdent.odontologos.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "odontologos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOdontologo;

    @Column(unique = true, nullable = false)
    private String rut;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String especialidad; // Ej: General, Ortodoncia, Endodoncia

    private String email;
    private String telefono;
    
    @Column(columnDefinition = "boolean default true")
    private Boolean activo = true;
}