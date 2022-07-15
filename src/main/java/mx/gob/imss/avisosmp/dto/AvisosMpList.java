package mx.gob.imss.avisosmp.dto;

import lombok.Data;

@Data
public class AvisosMpList {
    private Integer idAvisoMp;
    private String fechaElaboracion;
    private String nombrePaciente;
    private String medicoTratante;
    private String TrabajadorSocial;
}
