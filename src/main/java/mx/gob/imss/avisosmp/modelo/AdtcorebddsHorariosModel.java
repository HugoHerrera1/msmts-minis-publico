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
@Table(name = "adtsc_horario")
@Getter
@Setter
public class AdtcorebddsHorariosModel {

	/* Datos Generales */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_HORARIO", nullable = true)
	private Integer idHorario;

	@Column(name = "ID_ESTATUS", nullable = true, length = 100)
	private Integer idEstatus;

	@Column(name = "ID_TURNO", nullable = true, length = 100)
	private Integer idTurno;
	
	@Column(name = "NOM_DIA", nullable = true, length = 100)
	private String nomDia;
	
	@Column(name = "TIM_HORA_INICIAL", nullable = true, length = 100)
	private String horaInicial;
	
	@Column(name = "TIM_HORA_FINAL", nullable = true, length = 100)
	private String horaFinal;
	
	@Column(name = "NUM_DURACION", nullable = true, length = 100)
	private Integer duracion;

	/* Datos de Mantenimiento */
	@Column(name = "FEC_EXPIRA")
	private String fechaDeExpiracion ;
	
	@Column(name = "FEC_ALTA")
	private String fechaDeAlta ;
	
	@Column(name = "FEC_ACTUALIZACION")
	private String fechaDeActualizacion ;
	
	@Column(name = "FEC_BAJA")
	private String fechaDeBaja ;
	
	@Column(name = "IND_ACTIVO")
	private Integer indActivo ;
}
