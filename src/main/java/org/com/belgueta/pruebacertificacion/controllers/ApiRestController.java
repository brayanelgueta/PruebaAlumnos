package org.com.belgueta.pruebacertificacion.controllers;

import org.com.belgueta.pruebacertificacion.models.dto.AlumnoDTO;
import org.com.belgueta.pruebacertificacion.models.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiRestController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/api/alumnos")
    public ResponseEntity<List<AlumnoDTO>> listar(){

        try{
            List<AlumnoDTO> lista = alumnoService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
