package com.cdent.fichasmedicas.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "fichas_medicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFicha;

    @Column(nullable = false, unique = true)
    private Long idPaciente;

    @Column(columnDefinition = "TEXT")
    private String antecedentesFamiliares;

    @Column(columnDefinition = "TEXT")
    private String antecedentesPersonales;

    @Column(columnDefinition = "TEXT")
    private String alergias;

    private String tipoSangre;

    @Column(updatable = false)
    private LocalDate fechaCreacion = LocalDate.now();
}