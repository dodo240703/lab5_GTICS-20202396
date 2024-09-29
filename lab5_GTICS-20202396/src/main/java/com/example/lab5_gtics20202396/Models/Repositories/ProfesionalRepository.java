package com.example.lab5_gtics20202396.Models.Repositories;

import com.example.lab5_gtics20202396.Models.Entities.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {

    @Query("SELECT p FROM Profesional p " +
            "JOIN p.fechasDisponibles f " +
            "WHERE (:area IS NULL OR p.area.nameArea = :area) " +
            "AND (:fecha IS NULL OR f.fechaDisponibilidad = :fecha) " +
            "AND (:sede IS NULL OR p.sede.nombreSede = :sede)")
    List<Profesional> findByAreaFechaSede(String area,
                                          String fecha,
                                          String sede);


}
