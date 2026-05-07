package com.cdent.facturacion.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @Column(nullable = false)
    private Long idCita;

    @Column(nullable = false)
    private Double montoTotal;

    private LocalDateTime fechaEmision = LocalDateTime.now();

    @Column(nullable = false)
    private String estado = "PENDIENTE";
}