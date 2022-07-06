package mx.gob.imss.avisosmp.servicios;

import mx.gob.imss.avisosmp.dto.ReporteAvisosMPDto;

public interface ReporteAvisosMPServicio {

	byte [] imprimeAvisosMP (ReporteAvisosMPDto reporte);
}
