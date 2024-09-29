package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fechas")
public class Fecha {
    @Id
    @Column(name = "idfechas")
    private Integer id;

    @Column(name = "fechadisponibilidad")
    private String fechaDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "idprofesional")
    private Profesional profesional;


}