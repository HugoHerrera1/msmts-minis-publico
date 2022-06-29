package mx.gob.imss.avisosmp.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.imss.avisosmp.modelo.AdtcorebddsHorariosModel;

public interface AdtcorebddsCatalogos extends JpaRepository<AdtcorebddsHorariosModel, Integer> {
	@Query( value = ""
			+ "SELECT  * FROM    mtssdds.adtsc_horario ORDER   BY ID_HORARIO ASC", nativeQuery = true )
	List<AdtcorebddsHorariosModel> consultaHorarios ();
	
}
