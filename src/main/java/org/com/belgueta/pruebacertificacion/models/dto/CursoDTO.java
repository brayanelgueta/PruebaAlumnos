package org.com.belgueta.pruebacertificacion.models.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    @Id
    @Column(name = "id_cur")
    private Integer idCurso;

    @ManyToOne
    @JoinColumn(name = "alu_cur")
    private AlumnoDTO alumno;
}
