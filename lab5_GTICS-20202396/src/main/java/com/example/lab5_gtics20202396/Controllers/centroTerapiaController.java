package com.example.lab5_gtics20202396.Controllers;

import com.example.lab5_gtics20202396.Models.Entities.Area;
import com.example.lab5_gtics20202396.Models.Entities.Profesional;
import com.example.lab5_gtics20202396.Models.Entities.Sede;
import com.example.lab5_gtics20202396.Models.Repositories.AreaRepository;
import com.example.lab5_gtics20202396.Models.Repositories.ProfesionalRepository;
import com.example.lab5_gtics20202396.Models.Repositories.SedeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/terapia")
public class centroTerapiaController {
    
    final ProfesionalRepository profesionalRepository;
    final SedeRepository sedeRepository;
    final AreaRepository areaRepository;

    public centroTerapiaController(ProfesionalRepository profesionalRepository, SedeRepository sedeRepository, AreaRepository areaRepository) {
        this.profesionalRepository = profesionalRepository;
        this.sedeRepository = sedeRepository;
        this.areaRepository = areaRepository;
    }


    @GetMapping("profesionales")
    public String profesional(@RequestParam(required = false) String area,
                              @RequestParam(required = false) String fecha,
                              @RequestParam(required = false) String sede,
                              Model model) {
        List<Profesional> listaProfesionales;
        List<Area> listaAreas = areaRepository.findAll();
        List<Sede> listaSedes = sedeRepository.findAll();

        if (area != null && fecha != null && sede != null) {
            listaProfesionales = profesionalRepository.findByArea_NombreAreaAndFecha_FechaDisponibilidadAndSede_NombreSede(area, fecha, sede);
        } else {
            listaProfesionales = profesionalRepository.findAll();
        }
        model.addAttribute("listaProfesionales", listaProfesionales);
        model.addAttribute("lis", area);
        model.addAttribute("fecha", fecha);

        return "profesionales";
    }
}
