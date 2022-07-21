package mx.gob.imss.avisosmp.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("avisosMP")
public class AvisoMPRequest {
private String fechaRegistroAviso;
private String idEstado;
private String alcaldia;
private String agenciaMP;
private String nombrePaciente;
private String desNss;
private String idUnidadHospital;
private String ubicacionHospital;
private String cveServicio;
private String numCama;
private String fechaIngreso;
private String horaIngreso;
private String lesionesPaciente;
private String nombreMedicoTratante;
private String matriculaMedicoTratante;
private String nombreTrabajadorSocial;
private String matriculaTrabajadorSocial;
}
