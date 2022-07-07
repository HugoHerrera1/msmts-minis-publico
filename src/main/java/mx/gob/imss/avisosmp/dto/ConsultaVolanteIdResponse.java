package mx.gob.imss.avisosmp.dto;

import lombok.Data;

@Data
public class ConsultaVolanteIdResponse {
    private String status;
    private String mensaje;
    private DetalleAvisoMp datosAvisoMp;
}
