package org.com.belgueta.pruebacertificacion.models.dao;

import org.com.belgueta.pruebacertificacion.models.dto.EvaluacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvaluacionDAO extends JpaRepository<EvaluacionDTO, Integer> {
}
