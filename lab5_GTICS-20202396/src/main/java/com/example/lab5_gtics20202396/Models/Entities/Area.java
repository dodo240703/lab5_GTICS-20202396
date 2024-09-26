package com.example.lab5_gtics20202396.Models.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="areas")
public class Area {

    @Id
    @Column(name = "idareas")
    private Integer idArea;

    @Column(name = "nombrearea")
    private String nameArea;
}
