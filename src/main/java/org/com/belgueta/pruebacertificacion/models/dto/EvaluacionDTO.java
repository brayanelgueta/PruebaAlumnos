package org.com.belgueta.pruebacertificacion.models.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "evaluaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluacionDTO implements Serializable {

    @Id
    @Column(name = "id_eva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluacion;

    @Column(name = "nom_eva")
    private String nombreEvaluacion;

    @Column(name = "fec_eva")
    private Date fechaEvaluacion;

    @Column(name = "not_eva")
    private Double notEvaluacion;


    @ManyToOne
    @JoinColumn(name = "alu_eva")
    private AlumnoDTO alumno;

    @ManyToOne
    @JoinColumn(name = "asi_eva")
    private AsignaturaDTO asignatura;
}
