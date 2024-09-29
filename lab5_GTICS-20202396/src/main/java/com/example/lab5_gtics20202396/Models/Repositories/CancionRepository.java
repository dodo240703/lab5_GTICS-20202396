package com.example.lab5_gtics20202396.Models.Repositories;

import com.example.lab5_gtics20202396.Models.Entities.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
import java.util.List;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer> {
    List<Cancion> findByTipoCancionAndRecurso_IdRecurso(String tipoCancion, Integer idRecurso);
}
