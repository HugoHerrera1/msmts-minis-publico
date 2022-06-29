package mx.gob.imss.avisosmp.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

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
@JsonRootName(value = "response")
public class Response {
	@JsonProperty
	private HttpStatus status;
	
	@JsonProperty
	private String mensaje;
	
	@JsonProperty
	private List<AvisosMPDto> listaAvisosMPDto;
	
	@JsonProperty
	private AvisosMPDto avisosMPDto;
	
	@JsonProperty
	private Integer idAmp;
	
	@JsonProperty
    private String noFolioControl;
	
	@JsonProperty
	private String data;
	
}
