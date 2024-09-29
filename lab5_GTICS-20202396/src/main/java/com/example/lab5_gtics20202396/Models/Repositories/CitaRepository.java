package com.example.lab5_gtics20202396.Models.Repositories;

import com.example.lab5_gtics20202396.Models.Dtos.CitasInfoDto;
import com.example.lab5_gtics20202396.Models.Entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    @Query("SELECT c FROM Cita c WHERE " +
            "(:profesional IS NULL OR c.profesional.nombreProfesional = :profesional) AND " +
            "(:area IS NULL OR c.area.nameArea = :area) AND " +
            "(:fecha IS NULL OR c.fechaConsulta.fechaDisponibilidad = :fecha) AND " +
            "(:riesgo IS NULL OR c.riesgo.tipoRiesgo = :riesgo) AND " +
            "(:sede IS NULL OR c.sede.nombreSede = :sede)")
    List<Cita> findByFilters(String profesional,
                             String area,
                             String fecha,
                             String riesgo,
                             String sede);

    @Query("SELECT new com.example.lab5_gtics20202396.Models.Dtos.CitasInfoDto(s.nombreSede, null, null, COUNT(c), null, null) " +
            "FROM Cita c JOIN c.sede s GROUP BY s.nombreSede")
    List<CitasInfoDto> getTotalCitasPorSede();

    @Query("SELECT new com.example.lab5_gtics20202396.Models.Dtos.CitasInfoDto(null, a.nameArea, null, null, COUNT(c), null) " +
            "FROM Cita c JOIN c.area a GROUP BY a.nameArea")
    List<CitasInfoDto> getTotalCitasPorEspecialidad();

    @Query("SELECT new com.example.lab5_gtics20202396.Models.Dtos.CitasInfoDto(null, null, p.nombreProfesional, null, null, COUNT(c)) " +
            "FROM Cita c JOIN c.profesional p GROUP BY p.nombreProfesional")
    List<CitasInfoDto> getTotalCitasPorProfesional();

}
