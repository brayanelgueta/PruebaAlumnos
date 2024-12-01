package org.com.belgueta.pruebacertificacion.models.services;

import org.com.belgueta.pruebacertificacion.models.dao.IAlumnoDao;
import org.com.belgueta.pruebacertificacion.models.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    IAlumnoDao alumnoDao;

    @Override
    public List<AlumnoDTO> findAll() {
        return alumnoDao.findAll();
    }

    @Override
    public void save(AlumnoDTO alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    public AlumnoDTO findById(String id) {
        return alumnoDao.findById(id).orElse(null);
    }


    @Override
    public void delete(String id) {
        alumnoDao.deleteById(id);
    }

    public List<AlumnoDTO> findBySitFinal(String sitFinal) {

        return alumnoDao.findAll().stream()
                .filter(alumno -> sitFinal.equals((alumno.getSitFinal())))
                .collect(Collectors.toList());

    }
}
