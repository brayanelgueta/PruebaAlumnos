package org.com.belgueta.pruebacertificacion.controllers;

import org.com.belgueta.pruebacertificacion.models.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProyectoController {


    @Autowired
    IAlumnoService alumnoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "App certificacion");
        return "index";
    }

    @GetMapping("/listarAlumnos")
    public String listarAlumnos(Model model) {
        model.addAttribute("titulo", "Listar Alumnos");
        model.addAttribute("alumnos", alumnoService.findAll());
        return "alumnos";
    }
    @PostMapping("/listarAlumnosFiltrados")
    public String listarAlumnosFiltrados(Model model,
                                @RequestParam String runAlu,
                                @RequestParam String sitFinal) {
        model.addAttribute("titulo", "Listar Alumnos");

        if(runAlu != null && !runAlu.isEmpty()) {
            model.addAttribute("alumnos", alumnoService.findById(runAlu));
            model.addAttribute("subTitulo", "Buscando por run: " + runAlu);
            return "alumnos";
        }
        if(sitFinal != null && !sitFinal.isEmpty()) {
            model.addAttribute("alumnos", alumnoService);
            model.addAttribute("alumnos", alumnoService.findBySitFinal(sitFinal));
            return "alumnos";
        }
        model.addAttribute("alumnos", alumnoService.findAll());
        return "alumnos";
    }

    @GetMapping ("/eliminarAlumno/{runAlu}")
    public String eliminarAlumno(Model model, @PathVariable(value = "runAlu") String runAlu) {

        if(runAlu !=null && !runAlu.isEmpty()) {
            alumnoService.delete(runAlu);
            model.addAttribute("titulo", "Listar Alumnos");
            model.addAttribute("alumnos", alumnoService.findAll());
            return "redirect:/listarAlumnos";
        }else{
            model.addAttribute("titulo", "No llego el id");
            model.addAttribute("alumnos", alumnoService.findAll());
        }
        return "alumnos";
    }
}
