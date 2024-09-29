package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcanciones")
    private Integer idCancion;

    @Column(name = "nombrecancion", nullable = false)
    private String nombreCancion;

    @Column(name = "tipocancion", nullable = false)
    private String tipoCancion;  // "recomendada" o "no recomendada"

    @ManyToOne
    @JoinColumn(name = "idrecurso", nullable = false)
    private Recurso recurso;


}

