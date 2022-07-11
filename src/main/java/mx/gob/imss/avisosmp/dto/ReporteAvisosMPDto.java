package mx.gob.imss.avisosmp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteAvisosMPDto {
	
	@JsonProperty
	private String estado;
	@JsonProperty
    private String dia;
	@JsonProperty
    private String mes;
    @JsonProperty
    private String año;
    @JsonProperty
    private String alcaldia;
    @JsonProperty
    private String nombrePac;
    @JsonProperty
    private String nombreHosp;
    @JsonProperty
    private String ubicacionHosp;
    @JsonProperty
    private String servicio;
    @JsonProperty
    private String cama;
    @JsonProperty
    private String fecIngreso;
    @JsonProperty
    private String hrIngreso;
    @JsonProperty
    private String observaciones;
    @JsonProperty
    private String nomMedico;
    @JsonProperty
    private String matriculaMed;
    @JsonProperty
    private String nomTS;
    @JsonProperty
    private String matTS;

}