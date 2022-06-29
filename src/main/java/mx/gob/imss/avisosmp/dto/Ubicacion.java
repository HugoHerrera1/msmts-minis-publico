package mx.gob.imss.avisosmp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "ubicacion")
@Getter
@Setter
public class Ubicacion {
	@JsonProperty
	private String cve_ubicacion;
	@JsonProperty
	private String des_completa_ubicacion;
	@JsonProperty
	private String des_abreviada_ubicacion;
	@JsonProperty
	private String fec_baja;
	@JsonProperty
	private String fec_alta;
	@JsonProperty
	private String fec_actualizacion;
	@JsonProperty
	private String ind_activo;
	@JsonProperty
	private String cve_tipo_unidad_medica;
	@JsonProperty
	private String cve_nivel;
	@JsonProperty
	private String cve_especialidad;
	@JsonProperty
	private String cve_unidad_medica;
	
}
