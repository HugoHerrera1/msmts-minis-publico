package mx.gob.imss.avisosmp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ConsultaAdmon {
    private String status;
    private String mensaje;
    private List<AvisosAdmon> datosAvisosMp;
}
