package mx.gob.imss.avisosmp.servicios;

import mx.gob.imss.avisosmp.dto.AvisoMPRequest;
import org.springframework.stereotype.Service;

@Service
public interface AvisosMpServices {
    String insertAvisoMp(AvisoMPRequest avisoMp);

    String findAvisosByFechas(String fechaInicio, String fechaFin);

    String findAvisosAdministracion(String fechaInicio, String fechaFin);

    String findAvisosById(Integer idAviso);

    String evictAllcaches();
}
