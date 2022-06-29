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
public class RequestPorRangoDeFechasPaginado {
	@JsonProperty
	private int pagina;
	
	@JsonProperty
	private String fechaInicial;
	
	@JsonProperty
	private String fechaFinal;
	
	@JsonProperty
	private int clavePaciente;
}
