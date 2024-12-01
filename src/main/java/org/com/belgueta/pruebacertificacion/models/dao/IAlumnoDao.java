package org.com.belgueta.pruebacertificacion.models.dao;

import org.com.belgueta.pruebacertificacion.models.dto.AlumnoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoDao extends JpaRepository<AlumnoDTO, String> {


}
