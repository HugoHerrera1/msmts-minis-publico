package mx.gob.imss.avisosmp.dto;

import lombok.Data;

@Data
public class InsertResponse {
    private String status;
    private Integer idAvisoMp;
    private String mensaje;
}
