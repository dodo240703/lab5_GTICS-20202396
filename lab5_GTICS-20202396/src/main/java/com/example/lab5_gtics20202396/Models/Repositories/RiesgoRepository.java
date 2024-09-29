package com.example.lab5_gtics20202396.Models.Repositories;

import com.example.lab5_gtics20202396.Models.Entities.Riesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiesgoRepository extends JpaRepository<Riesgo, Integer> {
}
