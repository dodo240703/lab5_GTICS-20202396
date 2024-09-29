package com.example.lab5_gtics20202396.Models.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacientesRiesgoDto {
    private String tipoRiesgo;
    private Long totalPacientes;

    public PacientesRiesgoDto(String tipoRiesgo, Long totalPacientes) {
        this.tipoRiesgo = tipoRiesgo;
        this.totalPacientes = totalPacientes;
    }
}
