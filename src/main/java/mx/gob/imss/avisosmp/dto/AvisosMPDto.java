package mx.gob.imss.avisosmp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "avisosMP")
public class AvisosMPDto {
	@JsonProperty
	private Bitacora bitacora;
	
	@JsonProperty
	private Integer idAmp;
	
	@JsonProperty
    private String fecFecha;

	@JsonProperty
	private String idDelegacion;
	
	@JsonProperty
    private String agenciaDelMP;
	
	@JsonProperty
    private String nombrePaciente;
	
	@JsonProperty
    private String idUnidadMed;

	@JsonProperty
    private String numCama;
	
	@JsonProperty
    private String idEspecialidad;
	
	@JsonProperty
    private String ubicadoEn;
	
	@JsonProperty
    private String fecIngreso;
	
	@JsonProperty
    private String horaIngreso;
	
	@JsonProperty
    private String lesionesPaciente;
	
	@JsonProperty
    private String nombreMedico;
	
	@JsonProperty
    private String matriculaMedico;
	
	@JsonProperty
    private String nombreTS;
	
	@JsonProperty
    private String matriculaTS;
	
	@JsonProperty
	private List<UnidadesMedicasDto> unidadesMedicas;
	
	@JsonProperty
	private List<String> avisosArray;
	
}
