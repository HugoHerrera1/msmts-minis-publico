package mx.gob.imss.avisosmp.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.imss.avisosmp.modelo.MsmtsAvisosMP;
import mx.gob.imss.constantes.Querys;
import mx.gob.imss.avisosmp.modelo.MsmtsUnidadesMedicas;

public interface MsmtsAvisosMPRepository extends JpaRepository<MsmtsAvisosMP, Integer> {

	@Query(value = Querys.consultaPorId, nativeQuery = true)
	MsmtsAvisosMP consultaPorId(int folio);
	
	@Query(value = Querys.consultaAvisosMPPorRangoDeFechasPaginado , nativeQuery = true)
	List<MsmtsAvisosMP> consultaAvisosMPPorRangoDeFechasPaginado(
			String fechaInicial, String fechaFinal,int clavePaciente,int paginaInicial,int paginaFinal);
	
}
