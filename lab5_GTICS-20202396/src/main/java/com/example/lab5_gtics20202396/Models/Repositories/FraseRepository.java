package com.example.lab5_gtics20202396.Models.Repositories;

import com.example.lab5_gtics20202396.Models.Entities.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraseRepository extends JpaRepository<Frase, Integer> {
    List<Frase> findByRecurso_IdRecurso(Integer idRecurso);
}
