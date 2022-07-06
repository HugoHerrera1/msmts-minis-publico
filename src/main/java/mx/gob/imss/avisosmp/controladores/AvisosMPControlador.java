package mx.gob.imss.avisosmp.controladores;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.AvisosMPDto;
import mx.gob.imss.avisosmp.dto.ReporteAvisosMPDto;
import mx.gob.imss.avisosmp.dto.RequestPorRangoDeFechasPaginado;
import mx.gob.imss.avisosmp.servicios.AvisosMPServicio;
import mx.gob.imss.avisosmp.servicios.ReporteAvisosMPServicio;
import mx.gob.imss.avisosmp.servicios.impl.CatalogosImpl;
import net.sf.jasperreports.engine.JRException;
import mx.gob.imss.avisosmp.dto.Response;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/msmts-avisos-mp/api")
public class AvisosMPControlador {
	@Autowired 
	private AvisosMPServicio avisosMPServicio;
	
	@Autowired
	private CatalogosImpl catalogos;
	
	@Autowired
	private ReporteAvisosMPServicio reporteAvisosMPServicio;
	
	@PostMapping(value="/idAmp", produces = "application/json")
	public ResponseEntity<Response> consultaGeneralAvisosMPPorIdAmp (@RequestBody AvisosMPDto avisosMP){
		try {
			Response respuesta = avisosMPServicio.consultaAvisosMPPorIdAmp(avisosMP);
			return new ResponseEntity<Response>(respuesta,respuesta.getStatus());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping (value="/insert", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> guardarAvisosMP (@RequestBody AvisosMPDto avisosMP){
		
		Response respuesta = avisosMPServicio.guardarAvisosMP(avisosMP);
		return new ResponseEntity<>(respuesta.getMensaje(),respuesta.getStatus());
				
	}
	
	@PostMapping(value="/rango/fechas", produces = "application/json")
	public ResponseEntity<Response> consultaAvisosMPPorRangoDeFechas (@RequestBody RequestPorRangoDeFechasPaginado consultaPorRangoDeFechasPaginado){
		try {
			Response response = avisosMPServicio.consultaAvisosMPPorRangoDeFechasPaginado(consultaPorRangoDeFechasPaginado);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	  @PostMapping(path = "/reporteAvisoMP", consumes = "application/json")
	    public ResponseEntity<Resource> download(@RequestBody ReporteAvisosMPDto reporte)
	            throws JRException, IOException {

	        byte[] filePdf = reporteAvisosMPServicio.imprimeAvisosMP(reporte);
	        ByteArrayResource resource = new ByteArrayResource(filePdf);
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Reporte_AvisosMP.pdf")
	                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(filePdf.length).body(resource);
	    }
}

