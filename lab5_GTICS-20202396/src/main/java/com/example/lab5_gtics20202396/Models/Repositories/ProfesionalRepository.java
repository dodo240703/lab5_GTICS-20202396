package com.example.lab5_gtics20202396.Models.Repositories;

import com.example.lab5_gtics20202396.Models.Entities.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {

    List<Profesional> findByArea_NombreAreaAndFecha_FechaDisponibilidadAndSede_NombreSede(String area, String fecha, String sede);

}
