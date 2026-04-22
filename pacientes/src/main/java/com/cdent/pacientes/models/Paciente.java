package com.cdent.pacientes.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(unique = true, nullable = false)
    private String rut;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private LocalDate fechaNacimiento;
    private String email;
    private String telefono;
    private String direccion;
    
    @Column(columnDefinition = "boolean default true")
    private Boolean activo = true;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<ContactoEmergencia> contactos;
}