package mx.gob.imss.avisosmp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "msmtst_avisos_mp")
@Getter
@Setter
public class MsmtsAvisosMP {

	/* Datos Generales */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AMP", nullable = true)
	private Integer idApm;

	@Column(name = "FEC_ELABORACION", nullable = true, length = 100)
	private String fecFecha;

	@Column(name = "ID_DELEGACION_MUNICIPIO", nullable = true, length = 100)
	private String idDelegacion;

	@Column(name = "DES_AGENCIA_MP", nullable = true, length = 100)
	private String agenciaDelMP;

	@Column(name = "NOM_PACIENTE", nullable = true, length = 100)
	private String nombrePaciente;

	@Column(name = "ID_UNIDAD_MEDICA", nullable = true, length = 100)
	private String idUnidadMed;

	@Column(name = "DES_UBICADO_EN", nullable = true, length = 100)
	private String ubicadoEn;

	@Column(name = "CVE_ESPECIALIDAD", nullable = true, length = 100)
	private String idEspecialidad;

	@Column(name = "CVE_CAMA", nullable = true, length = 100)
	private String numCama;

	@Column(name = "FEC_INGRESO", nullable = true, length = 100)
	private String fecIngreso;

	@Column(name = "TIM_INGRESO", nullable = true, length = 100)
	private String horaIngreso;

	@Column(name = "DES_LECIONES_PACIENTE", nullable = true, length = 100)
	private String lesionesPaciente;

	@Column(name = "NOM_MEDICO", nullable = true, length = 100)
	private String nombreMedico;

	@Column(name = "MAT_MEDICO", nullable = true, length = 100)
	private String matriculaMedico;

	@Column(name = "NOM_TS", nullable = true, length = 100)
	private String nombreTS;

	@Column(name = "MAT_TS", nullable = true, length = 100)
	private String matriculaTS;
	
	
}
