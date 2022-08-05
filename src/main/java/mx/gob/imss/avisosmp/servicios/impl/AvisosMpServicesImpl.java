package mx.gob.imss.avisosmp.servicios.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.*;
import mx.gob.imss.avisosmp.modelo.MtstAvisosMp;
import mx.gob.imss.avisosmp.repositorios.AvisosMpRepository;
import mx.gob.imss.avisosmp.servicios.AvisosMpServices;
import mx.gob.imss.componentes.TransformaObjetos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AvisosMpServicesImpl implements AvisosMpServices {
    @Autowired
    AvisosMpRepository avisosMpRepo;
    @Autowired
    TransformaObjetos transform;
    Gson jsonResponse = new Gson();
    @Autowired
    CacheManager cacheManager;

    @Override
    public String insertAvisoMp(AvisoMPRequest avisoMp) {
        InsertResponse ir = new InsertResponse();
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
    public String findAvisosByFechas(String fechaInicio, String fechaFin) {
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

    @Override
    public String findAvisosAdministracion(String fechaInicio, String fechaFin) {
        ConsultaAdmon avisosMpAdmon = new ConsultaAdmon();
        try {
            List<AvisosAdmon> avisosMpLists = new ArrayList<>();
            List<MtstAvisosMp> mtstAvisosMpList = avisosMpRepo.findAvisosMp(fechaInicio, fechaFin);
            for (MtstAvisosMp volantes : mtstAvisosMpList) {
                avisosMpLists.add(transform.buildResponseAdmon(volantes));
            }
            avisosMpAdmon.setStatus("OK");
            avisosMpAdmon.setMensaje("Operación correcta");
            avisosMpAdmon.setDatosAvisosMp(avisosMpLists);
            return jsonResponse.toJson(avisosMpAdmon);
        } catch (Exception e) {
            avisosMpAdmon.setStatus("Error");
            avisosMpAdmon.setMensaje(e.getMessage());
            avisosMpAdmon.setDatosAvisosMp(new ArrayList<>());
            return jsonResponse.toJson(avisosMpAdmon);
        }
    }

    @Override
    public String findAvisosById(Integer idAviso) {
        ConsultaVolanteIdResponse consultaID = new ConsultaVolanteIdResponse();
        try {
            MtstAvisosMp avisoMp = avisosMpRepo.findAvisosMpById(idAviso);
            DetalleAvisoMp detail = transform.buildDetalleResponse(avisoMp);
            consultaID.setStatus("OK");
            consultaID.setMensaje("Operación correcta");
            consultaID.setDatosAvisoMp(detail);
            return jsonResponse.toJson(consultaID);
        } catch (Exception e) {
            consultaID.setStatus("Error");
            consultaID.setMensaje(e.getMessage());
            consultaID.setDatosAvisoMp(new DetalleAvisoMp());
            return jsonResponse.toJson(consultaID);
        }
    }

    public String evictAllcaches() {
        try {
            cacheManager.getCacheNames()
                    .forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
            return "Memoria cache borrada correctamente";

        } catch (Exception e) {

            e.printStackTrace();
            return "Error al borrar memoria cache";

        }
    }
}
