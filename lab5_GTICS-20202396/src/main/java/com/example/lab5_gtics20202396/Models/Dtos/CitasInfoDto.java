package com.example.lab5_gtics20202396.Models.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitasInfoDto {
    private String nombreSede;
    private String nombreArea;
    private String nombreProfesional;
    private Long totalCitasSede;
    private Long totalCitasEspecialidad;
    private Long totalCitasProfesional;

    // Constructor con todos los parámetros, algunos pueden ser null
    public CitasInfoDto(String nombreSede, String nombreArea, String nombreProfesional,
                        Long totalCitasSede, Long totalCitasEspecialidad, Long totalCitasProfesional) {
        this.nombreSede = nombreSede;
        this.nombreArea = nombreArea;
        this.nombreProfesional = nombreProfesional;
        this.totalCitasSede = totalCitasSede;
        this.totalCitasEspecialidad = totalCitasEspecialidad;
        this.totalCitasProfesional = totalCitasProfesional;
    }
}
