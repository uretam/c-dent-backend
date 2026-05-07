package com.cdent.reportes.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "reportes_generados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReporte;

    @Column(nullable = false)
    private String tipoReporte;

    @Column(columnDefinition = "TEXT")
    private String contenidoResumen;

    private LocalDateTime fechaGeneracion = LocalDateTime.now();
}