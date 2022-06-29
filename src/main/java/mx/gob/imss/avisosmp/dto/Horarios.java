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
@JsonRootName(value = "catalogos")
public class Horarios {
	@JsonProperty
	private Integer idHorario;
	
	@JsonProperty
    private String nomDia;
	
}
