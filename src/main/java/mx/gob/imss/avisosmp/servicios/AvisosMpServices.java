package mx.gob.imss.avisosmp.servicios;

import mx.gob.imss.avisosmp.dto.AvisoMPRequest;
import org.springframework.stereotype.Service;

@Service
public interface AvisosMpServices {
String insertAvisoMp(AvisoMPRequest avisoMp);
String findVolantesByFechas(String fechaInicio, String fechaFin);
}
