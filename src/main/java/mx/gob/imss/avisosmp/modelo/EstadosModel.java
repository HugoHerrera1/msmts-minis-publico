package mx.gob.imss.avisosmp.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EstadosModel {

    @JsonProperty
    private String cve_estado;

    @JsonProperty
    private String des_nombre_completo;

    @JsonProperty
    private String des_nombre_abreviado;

    @JsonProperty
    private String fec_alta;

    @JsonProperty
    private String fec_modificacion;

    @JsonProperty
    private String fec_baja;

    @JsonProperty
    private String ind_activo;
}
