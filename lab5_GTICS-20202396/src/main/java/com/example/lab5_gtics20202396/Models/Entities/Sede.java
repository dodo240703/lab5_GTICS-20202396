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
@Table(name = "sedes")
public class Sede {

    @Id
    @Column(name = "idsedes")
    private Integer idSede;

    @Column(name = "nombresede")
    private String nombreSede;
}
