package mx.gob.imss.avisosmp.dto;

import lombok.Data;

@Data
public class DetalleAvisoMp {
private Integer idAvisoMp;
private String fechaElaboracion;
private String delegacionMunicipio;
private String agenciaMp;
private String nombrePaciente;
private String unidadMedica;
private String cveEspecialidad;
private String especialidad;
private String cama;
private String fechaIngreso;
private String horaIngreso;
private String lesionesPaciente;
private String nombreMedico;
private String matriculaMedico;
private String nombreTrabajadorSocial;
private String matriculaTrabajadorSocial;
}
