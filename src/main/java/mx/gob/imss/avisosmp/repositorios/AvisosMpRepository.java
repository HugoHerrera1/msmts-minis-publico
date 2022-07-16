package mx.gob.imss.avisosmp.repositorios;

import mx.gob.imss.avisosmp.modelo.MtstAvisosMp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AvisosMpRepository extends JpaRepository<MtstAvisosMp,Long> {
    @Query(value = "select * from MTST_AVISOS_MP mam where mam.FEC_ELABORACION between ?1 and ?2 and mam.IND_ACTIVO = 1 ",nativeQuery = true)
    List<MtstAvisosMp> findAvisosMp(String fechaInicial, String fechaFinal);

    @Query(value = "select * from MTST_AVISOS_MP mam where mam.ID_AVISO_MP = ?1 and mam.IND_ACTIVO =1",nativeQuery = true)
    MtstAvisosMp findAvisosMpById(Integer idAviso);
}
