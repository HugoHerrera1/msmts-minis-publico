package mx.gob.imss.avisosmp.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.gob.imss.constantes.Querys;
import mx.gob.imss.avisosmp.modelo.MsmtsUnidadesMedicas;

public interface MsmtsUnidadesMedicasRepository extends JpaRepository<MsmtsUnidadesMedicas, String> {
	@Query(value = Querys.consultaUnidadesMedicasPorIdUm , nativeQuery = true)
	List<MsmtsUnidadesMedicas> consultaUnidadesMedicasPorIdUm(String idUnidadMed);
	
}
