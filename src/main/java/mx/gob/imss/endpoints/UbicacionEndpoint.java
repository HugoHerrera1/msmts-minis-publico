package mx.gob.imss.endpoints;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import mx.gob.imss.avisosmp.dto.Ubicacion;

public class UbicacionEndpoint {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public Ubicacion consumeRest (RestTemplate restTemplate) {
		Ubicacion ubicacion = restTemplate.getForObject("https://adt-qa.cloudapps.imss.gob.mx/msedsc-catalogos/api/listUbicacion/C201",Ubicacion.class);
		
		return ubicacion;
	}
}
