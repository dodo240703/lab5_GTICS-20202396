package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "frases")
public class Frase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfrases")
    private Integer idFrase;

    @Column(name = "frase", nullable = false)
    private String frase;

    @ManyToOne
    @JoinColumn(name = "idrecurso", nullable = false)
    private Recurso recurso;

}

