package mx.gob.imss.avisosmp.servicios;

import java.util.List;

import mx.gob.imss.avisosmp.dto.RequestPorRangoDeFechasPaginado;
import mx.gob.imss.avisosmp.dto.AvisosMPDto;
import mx.gob.imss.avisosmp.dto.Response;

public interface AvisosMPServicio {
	
	Response consultaAvisosMPPorIdAmp (AvisosMPDto avisosMP);
	Response consultaAvisosMPPorRangoDeFechasPaginado (RequestPorRangoDeFechasPaginado consultaPorRangoDeFechasPaginado);
	Response guardarAvisosMP(AvisosMPDto avisosMP);
	String ubicacionEndpoint(String cveServicio);
}
