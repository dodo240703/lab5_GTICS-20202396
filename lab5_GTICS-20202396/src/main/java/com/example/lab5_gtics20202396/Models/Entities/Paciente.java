package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpacientes", nullable = false)
    private Integer id;

    @Column(name = "nombrepaciente", length = 45)
    private String nombrePaciente;

    @Column(name = "dni", length = 45)
    private String dni;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "pacientescol", length = 45)
    private String pacientescol;

    public Paciente(String nombrePaciente, String dni, Integer edad) {
    }

    public Paciente() {

    }
}