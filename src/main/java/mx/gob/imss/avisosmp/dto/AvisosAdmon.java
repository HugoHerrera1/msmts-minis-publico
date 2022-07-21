package mx.gob.imss.avisosmp.dto;

import lombok.Data;

@Data
public class AvisosAdmon {
    private Integer idAvisoMp;
    private String fechaElaboracion;
    private String nss;
    private String nombrePaciente;
    private String medicoTratante;
    private String TrabajadorSocial;

}
