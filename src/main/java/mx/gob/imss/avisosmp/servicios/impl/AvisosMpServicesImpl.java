package mx.gob.imss.avisosmp.servicios.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.AvisoMPRequest;
import mx.gob.imss.avisosmp.dto.AvisosMpList;
import mx.gob.imss.avisosmp.dto.ConsultaFechasResponse;
import mx.gob.imss.avisosmp.dto.InsertResponse;
import mx.gob.imss.avisosmp.modelo.MtstAvisosMp;
import mx.gob.imss.avisosmp.repositorios.AvisosMpRepository;
import mx.gob.imss.avisosmp.servicios.AvisosMpServices;
import mx.gob.imss.componentes.TransformaObjetos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AvisosMpServicesImpl implements AvisosMpServices {
    @Autowired
    AvisosMpRepository avisosMpRepo;
    @Autowired
    TransformaObjetos transform;
    Gson jsonResponse = new Gson();

    @Override
    public String insertAvisoMp(AvisoMPRequest avisoMp) {
        InsertResponse ir = new InsertResponse();
        // Gson jsonInsert = new Gson();
        try {
            MtstAvisosMp avisosMp = transform.buildInsert(avisoMp);
            ir.setStatus("OK");
            ir.setMensaje("Operación correcta");
            ir.setIdAvisoMp(avisosMpRepo.save(avisosMp).getId().intValue());
            return jsonResponse.toJson(ir);
        } catch (Exception e) {
            ir.setMensaje("Error al insertar el registro [SERVICE :" + e.getMessage() + "]");
            ir.setStatus("Error en la operación");
            ir.setIdAvisoMp(null);
            return jsonResponse.toJson(ir);
        }
    }

    @Override
    public String findVolantesByFechas(String fechaInicio, String fechaFin) {
        ConsultaFechasResponse avisosMpFechas = new ConsultaFechasResponse();
        try {
            List<AvisosMpList> avisosMpLists = new ArrayList<>();
            List<MtstAvisosMp> mtstAvisosMpList = avisosMpRepo.findAvisosMp(fechaInicio, fechaFin);
            for (MtstAvisosMp volantes : mtstAvisosMpList) {
                avisosMpLists.add(transform.buildResponseList(volantes));
            }
            avisosMpFechas.setStatus("OK");
            avisosMpFechas.setMensaje("Operación correcta");
            avisosMpFechas.setDatosAvisosMp(avisosMpLists);
            return jsonResponse.toJson(avisosMpFechas);
        } catch (Exception e) {
            avisosMpFechas.setStatus("Error");
            avisosMpFechas.setMensaje(e.getMessage());
            avisosMpFechas.setDatosAvisosMp(new ArrayList<>());
            return jsonResponse.toJson(avisosMpFechas);
        }
    }
}
