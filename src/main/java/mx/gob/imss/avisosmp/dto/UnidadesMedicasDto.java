package mx.gob.imss.avisosmp.dto;

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
public class UnidadesMedicasDto {
	@JsonProperty
	private String idUnidadMed;
	
	@JsonProperty
    private String unidadMedicaDescripcion;
	
	@JsonProperty
    private Integer indActivo;
}
