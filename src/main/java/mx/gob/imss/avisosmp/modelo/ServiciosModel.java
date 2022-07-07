package mx.gob.imss.avisosmp.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ServiciosModel {
    @JsonProperty
    private String cve_especialidad;
    @JsonProperty
    private String des_especialidad;
    @JsonProperty
    private String ind_ce;
    @JsonProperty
    private String ind_iq;
    @JsonProperty
    private String ind_hospital;
    @JsonProperty
    private String ind_nivel1;
    @JsonProperty
    private String ind_nivel2;
    @JsonProperty
    private String ind_nivel3;
    @JsonProperty
    private String ind_css;
    @JsonProperty
    private String indCss;
    @JsonProperty
    private String fec_baja;
    @JsonProperty
    private String fec_alta;
    @JsonProperty
    private String fec_actualizacion;
    @JsonProperty
    private String ind_activo;

}
