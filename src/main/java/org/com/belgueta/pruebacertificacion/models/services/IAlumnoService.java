package org.com.belgueta.pruebacertificacion.models.services;

import org.com.belgueta.pruebacertificacion.models.dto.AlumnoDTO;

import java.util.List;
import java.util.stream.Collectors;

public interface IAlumnoService {

    List<AlumnoDTO> findAll();

    void save(AlumnoDTO alumno);

    AlumnoDTO findById(String id);

    void delete(String id);

    List<AlumnoDTO> findBySitFinal(String sitFinal);
}
