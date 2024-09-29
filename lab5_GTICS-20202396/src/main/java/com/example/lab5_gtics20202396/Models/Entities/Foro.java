package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idforo", nullable = false)
    private Integer id;

    @Column(name = "comentario", nullable = false, length = 45)
    private String comentario;

    @Column(name = "nombrepersona", nullable = false, length = 45)
    private String nombrePersona;

    @Column(name = "edadpersona")
    private Integer edadPersona;

}