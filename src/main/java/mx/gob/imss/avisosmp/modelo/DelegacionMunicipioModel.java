package mx.gob.imss.avisosmp.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DelegacionMunicipioModel {
    @JsonProperty
    private String cve_delegacion_municipio;
    @JsonProperty
    private String des_municipio;
    @JsonProperty
    private String cve_estado;
    @JsonProperty
    private String fec_alta;
    @JsonProperty
    private String fec_modificacion;
    @JsonProperty
    private String fec_baja;
    @JsonProperty
    private String ind_activo;
}
