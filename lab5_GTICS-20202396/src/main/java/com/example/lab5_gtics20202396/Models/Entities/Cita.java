package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcitas", nullable = false)
    private Integer id;

    @Column(name = "motivoconsulta", nullable = false, length = 45)
    private String motivoConsulta;

    @ManyToOne
    @JoinColumn(name = "idpaciente", nullable = false)
    private Paciente paciente;

    // Nueva relación con Profesional
    @ManyToOne
    @JoinColumn(name = "idprofesional", nullable = false)
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "idarea", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idfechaconsulta")
    private Fecha fechaConsulta;

    @ManyToOne
    @JoinColumn(name = "idsede", nullable = false)
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "idriesgo", nullable = false)
    private Riesgo riesgo;

    @Column(name = "precio", precision = 10)
    private BigDecimal precio;

    @Column(name = "citascol", length = 45)
    private String citascol;

}