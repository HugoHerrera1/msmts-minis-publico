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
@Table(name = "msmtsc_unidades_medicas")
@Getter
@Setter
public class MsmtsUnidadesMedicas {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UNIDAD_MEDICA", nullable = false)
	private String idUnidadMed;
	
	@Column(name = "DES_UNIDAD_INF_PREI", nullable = false, length = 100)
    private String unidadMedicaDescripcion;

	
	@Column(name = "IND_ACTIVO")
	private int indActivo ;
	
}
