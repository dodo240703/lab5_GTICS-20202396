package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "riesgos")
public class Riesgo {
    @Id
    @Column(name = "idriesgos", nullable = false)
    private Integer idRiesgo;

    @Column(name = "tiporiesgo")
    private String tipoRiesgo;
}