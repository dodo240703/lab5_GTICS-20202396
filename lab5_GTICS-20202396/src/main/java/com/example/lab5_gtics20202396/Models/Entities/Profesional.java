package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profesionales")
public class Profesional {

    @Id
    @Column(name = "idprofesionales")
    private Integer idProfesional;

    @Column(name = "nombre")
    private String nombreProfesional;

    @Column(name = "imagen")
    private String urlImagen;

    @Column(name = "descripcionprofesional")
    private String descripcionProfesional;

    @ManyToOne
    @JoinColumn(name = "idarea")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "idsede")
    private Sede sede;
}
