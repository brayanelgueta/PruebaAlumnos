package org.com.belgueta.pruebacertificacion.models.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO implements Serializable {

    public AlumnoDTO(String runAlu, String nomAlu, String apeAlu) {
        this.runAlu = runAlu;
        this.nomAlu = nomAlu;
        this.apeAlu = apeAlu;
        this.evaluaciones = new ArrayList<>();
    }

    @Id
    @Column(name = "run_alu")
    private String runAlu;

    @Column(name = "nom_alu")
    private String nomAlu;

    @Column(name = "ape_alu")
    private String apeAlu;

    @Transient
    private Double promedio;

    @Transient
    private String sitFinal;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionDTO> evaluaciones = new ArrayList<>();

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoDTO> cursos = new ArrayList<>();

    public Double getPromedio(){
        if(evaluaciones == null || evaluaciones.isEmpty()){
            return 0.0;
        }
        return (double)Math.round(evaluaciones.stream().mapToDouble(EvaluacionDTO::getNotEvaluacion)
                .average()
                .orElse(0.0) * 10.0) / 10.0;
    }

    public String getSitFinal(){

        Double promedio = getPromedio();

        if(promedio != null && promedio >= 4.0){
            return "aprobado";
        }else{
            return "reprobado";
        }
    }


}
