package org.com.belgueta.pruebacertificacion.models.dao;

import org.com.belgueta.pruebacertificacion.models.dto.AsignaturaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsignaturaDAO extends JpaRepository<AsignaturaDTO, Integer> {
}
