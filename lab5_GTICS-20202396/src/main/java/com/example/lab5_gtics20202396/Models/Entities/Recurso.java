package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recursos")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrecursos")
    private Integer idRecurso;

    @OneToMany(mappedBy = "recurso")
    private List<Cancion> canciones;

    @OneToMany(mappedBy = "recurso")
    private List<Frase> frases;

}

