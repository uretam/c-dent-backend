package com.cdent.pacientes.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "contactos_emergencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;

    @Column(nullable = false)
    private String nombreContacto;

    @Column(nullable = false)
    private String telefonoContacto;

    private String parentesco;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
}