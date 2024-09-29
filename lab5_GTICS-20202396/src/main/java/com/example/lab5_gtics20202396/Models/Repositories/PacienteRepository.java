package com.example.lab5_gtics20202396.Models.Repositories;

import com.example.lab5_gtics20202396.Models.Dtos.PacientesRiesgoDto;
import com.example.lab5_gtics20202396.Models.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByDni(String dni);

    @Query("SELECT new com.example.lab5_gtics20202396.Models.Dtos.PacientesRiesgoDto(r.tipoRiesgo, COUNT(p)) " +
            "FROM Paciente p JOIN Cita c ON p.id = c.paciente.id " +
            "JOIN c.riesgo r GROUP BY r.tipoRiesgo")
    List<PacientesRiesgoDto> getTotalPacientesPorRiesgo();
}
