package org.com.belgueta.pruebacertificacion.models.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO implements Serializable {

    @Id
    @Column(name = "id_asi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsi;

    @Column(name = "nom_asi")
    private String nomAsi;

    @Column(name = "tip_asi")
    private String tipAsi;

    @OneToMany(mappedBy = "asignatura",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionDTO> evaluaciones = new ArrayList<>();
}
