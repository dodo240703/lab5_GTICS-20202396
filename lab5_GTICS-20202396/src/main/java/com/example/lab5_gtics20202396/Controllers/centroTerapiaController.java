package com.example.lab5_gtics20202396.Controllers;

import com.example.lab5_gtics20202396.Models.Entities.*;
import com.example.lab5_gtics20202396.Models.Repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/terapia")
public class centroTerapiaController {
    
    final ProfesionalRepository profesionalRepository;
    final SedeRepository sedeRepository;
    final AreaRepository areaRepository;
    final FechaRepository fechaRepository;
    final CitaRepository citaRepository;
    final PacienteRepository pacienteRepository;
    final RiesgoRepository riesgoRepository;
    final ForoRepository foroRepository;
    private final CancionRepository cancionRepository;
    private final FraseRepository fraseRepository;

    public centroTerapiaController(ProfesionalRepository profesionalRepository, SedeRepository sedeRepository, AreaRepository areaRepository, FechaRepository fechaRepository, CitaRepository citaRepository, PacienteRepository pacienteRepository, RiesgoRepository riesgoRepository, ForoRepository foroRepository) {
        this.profesionalRepository = profesionalRepository;
        this.sedeRepository = sedeRepository;
        this.areaRepository = areaRepository;
        this.fechaRepository = fechaRepository;
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
        this.riesgoRepository = riesgoRepository;
        this.foroRepository = foroRepository;
    }


    @GetMapping("/profesionales")
    public String profesional(@RequestParam(required = false) String area,
                              @RequestParam(required = false) String sede,
                              @RequestParam(required = false) String fecha,
                              Model model) {
        List<Profesional> listaProfesionales;
        List<Area> listaAreas = areaRepository.findAll();
        List<Sede> listaSedes = sedeRepository.findAll();
        List<Fecha> listaFechas = fechaRepository.findAll();

        if (area != null && sede != null && fecha != null) {
            listaProfesionales = profesionalRepository.findByAreaFechaSede(area, fecha, sede);
        } else {
            listaProfesionales = profesionalRepository.findAll();
        }
        model.addAttribute("listaProfesionales", listaProfesionales);
        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("listaSedes", listaSedes);
        model.addAttribute("listaFechas", listaFechas);

        return "profesionales";
    }

    @GetMapping("/formRegistrarCita")
    public String formRegistrarCita(Model model) {
        List<Profesional> listaProfesionales = profesionalRepository.findAll();
        List<Area> listaAreas = areaRepository.findAll();
        List<Sede> listaSedes = sedeRepository.findAll();
        List<Fecha> listaFechas = fechaRepository.findAll();
        List<Riesgo> listaRiesgos = riesgoRepository.findAll();

        model.addAttribute("listaProfesionales", listaProfesionales);
        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("listaSedes", listaSedes);
        model.addAttribute("listaFechas", listaFechas);
        model.addAttribute("listaRiesgos", listaRiesgos);
        return "registrarCita";
    }

    @PostMapping("/reservarCita")
    public String saveCitaa(@RequestParam String nombrePaciente,
                            @RequestParam String dni,
                            @RequestParam Integer edad,
                            @RequestParam String motivoConsulta,
                            @RequestParam Integer idProfesional,
                            @RequestParam Integer idArea,
                            @RequestParam Integer idSede,
                            @RequestParam Integer idRiesgo,
                            @RequestParam Integer idFecha,
                            Model model,
                            RedirectAttributes redirectAttributes){


        // Verificar si el profesional coincide con su área de especialidad
        Profesional profesional = profesionalRepository.findById(idProfesional)
                .orElseThrow(() -> new IllegalArgumentException("Profesional no encontrado"));
        Area area = areaRepository.findById(idArea)
                .orElseThrow(() -> new IllegalArgumentException("Área no encontrada"));
        Sede sede = sedeRepository.findById(idSede)
                .orElseThrow(() -> new IllegalArgumentException("Sede no encontrada"));
        Fecha fecha = fechaRepository.findById(idFecha)
                .orElseThrow(() -> new IllegalArgumentException("Fecha no disponible"));
        Riesgo riesgo = riesgoRepository.findById(idRiesgo)
                .orElseThrow(() -> new IllegalArgumentException("Nivel de riesgo no encontrado"));

        if (!profesional.getArea().equals(area)) {
            redirectAttributes.addFlashAttribute("error", "El profesional no coincide con su área de especialidad.");
            return "redirect:/terapia/formRegistrarCita";
        }

        if (!profesional.getSede().equals(sede)) {
            redirectAttributes.addFlashAttribute("error", "El profesional no está disponible en la sede seleccionada.");
            return "redirect:/terapia/formRegistrarCita";
        }

        if (!profesional.getFechasDisponibles().contains(fecha)) {
            redirectAttributes.addFlashAttribute("error", "El profesional no está disponible en la fecha seleccionada.");
            return "redirect:/terapia/formRegistrarCita";
        }
        // Crear o buscar paciente
        // Crear o buscar paciente
        Paciente paciente = pacienteRepository.findByDni(dni)
                .orElse(new Paciente(nombrePaciente, dni, edad));
        pacienteRepository.save(paciente);
        pacienteRepository.save(paciente);

        // Crear y guardar la cita
        Cita nuevaCita = new Cita();
        nuevaCita.setMotivoConsulta(motivoConsulta);
        nuevaCita.setPaciente(paciente);
        nuevaCita.setArea(area);
        nuevaCita.setSede(sede);
        nuevaCita.setFechaConsulta(fecha);
        nuevaCita.setRiesgo(riesgo);

        citaRepository.save(nuevaCita);

        redirectAttributes.addFlashAttribute("success", "Cita reservada exitosamente.");



        return "redirect:/terapia/formRegistrarCita";

    }

    @GetMapping("/foro")
    public String showForo(Model model){
        List<Foro> listaComentarios = foroRepository.findAll();
        model.addAttribute("listaComentarios", listaComentarios);
        return "foro";
    }

    // Guardar un nuevo comentario
    @PostMapping("/enviarComentario")
    public String guardarComentario(@RequestParam String nombrePersona,
                                    @RequestParam Integer edad,
                                    @RequestParam String comentario,
                                    RedirectAttributes redirectAttributes) {
        if (nombrePersona.isEmpty() || comentario.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "El nombre y el comentario son obligatorios.");
            return "redirect:/terapia/foro";
        }

        Foro nuevoComentario = new Foro();
        nuevoComentario.setNombrePersona(nombrePersona);
        nuevoComentario.setEdadPersona(edad);
        nuevoComentario.setComentario(comentario);
        foroRepository.save(nuevoComentario);

        redirectAttributes.addFlashAttribute("success", "Comentario publicado exitosamente.");
        return "redirect:/terapia/foro";
    }

    @GetMapping
}
