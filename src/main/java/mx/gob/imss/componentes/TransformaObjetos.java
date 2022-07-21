package mx.gob.imss.componentes;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.AvisoMPRequest;
import mx.gob.imss.avisosmp.dto.AvisosAdmon;
import mx.gob.imss.avisosmp.dto.AvisosMpList;
import mx.gob.imss.avisosmp.dto.DetalleAvisoMp;
import mx.gob.imss.avisosmp.modelo.DelegacionMunicipioModel;
import mx.gob.imss.avisosmp.modelo.EstadosModel;
import mx.gob.imss.avisosmp.modelo.MtstAvisosMp;
import mx.gob.imss.avisosmp.modelo.ServiciosModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Slf4j
@Component
public class TransformaObjetos {
    @Autowired
    AgendaDigitalCliente cliente;

    public MtstAvisosMp buildInsert(AvisoMPRequest avisoMPRequest) throws ParseException {
        MtstAvisosMp mp = new MtstAvisosMp();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse(avisoMPRequest.getFechaRegistroAviso());
        mp.setFecElaboracion(date);
        mp.setIdEstado(avisoMPRequest.getIdEstado());
        mp.setDesDelegacionMunicipio(avisoMPRequest.getAlcaldia());
        mp.setDesAgenciaMp(avisoMPRequest.getAgenciaMP());
        mp.setNomPaciente(avisoMPRequest.getNombrePaciente());
        mp.setDesNss(avisoMPRequest.getDesNss());
        mp.setDesUnidadMedica(avisoMPRequest.getIdUnidadHospital());
        mp.setDesUbicacionUm(avisoMPRequest.getUbicacionHospital());
        mp.setCveEspecialidad(avisoMPRequest.getCveServicio());
        mp.setCveCama(avisoMPRequest.getNumCama());
        mp.setFecIngreso(format.parse(avisoMPRequest.getFechaIngreso()));
        mp.setTimIngreso(new Time(formatTime.parse(avisoMPRequest.getHoraIngreso()).getTime()));
        mp.setDesLesionesPaciente(avisoMPRequest.getLesionesPaciente());
        mp.setNomMedico(avisoMPRequest.getNombreMedicoTratante());
        mp.setCveMatriculaMedico(avisoMPRequest.getMatriculaMedicoTratante());
        mp.setNomTrabajadorSocial(avisoMPRequest.getNombreTrabajadorSocial());
        mp.setCveMatriculaTs(avisoMPRequest.getMatriculaTrabajadorSocial());
        mp.setIndActivo(true);
        return mp;
    }

    public AvisosMpList buildResponseList(MtstAvisosMp mtstAvisosMp) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        AvisosMpList response = new AvisosMpList();
        try {
            response.setIdAvisoMp(mtstAvisosMp.getId().intValue());
            response.setNombrePaciente(mtstAvisosMp.getNomPaciente());
            response.setFechaElaboracion(dateFormat.format(mtstAvisosMp.getFecElaboracion()));
            response.setMedicoTratante(mtstAvisosMp.getNomMedico());
            response.setTrabajadorSocial(mtstAvisosMp.getNomTrabajadorSocial());
            return response;
        } catch (Exception ex) {
            response.setIdAvisoMp(null);
            response.setNombrePaciente("");
            response.setFechaElaboracion("");
            return response;
        }
    }

    public AvisosAdmon buildResponseAdmon(MtstAvisosMp mtstAvisosMp) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        AvisosAdmon response = new AvisosAdmon();
        try {
            response.setIdAvisoMp(mtstAvisosMp.getId().intValue());
            response.setNombrePaciente(mtstAvisosMp.getNomPaciente());
            response.setFechaElaboracion(dateFormat.format(mtstAvisosMp.getFecElaboracion()));
            response.setMedicoTratante(mtstAvisosMp.getNomMedico());
            response.setTrabajadorSocial(mtstAvisosMp.getNomTrabajadorSocial());
            response.setNss(mtstAvisosMp.getDesNss());
            return response;
        } catch (Exception ex) {
            response.setIdAvisoMp(null);
            response.setNombrePaciente("");
            response.setFechaElaboracion("");
            return response;
        }
    }

    public DetalleAvisoMp buildDetalleResponse(MtstAvisosMp avisosMp) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DetalleAvisoMp detail = new DetalleAvisoMp();
        try {
            detail.setIdAvisoMp(avisosMp.getId().intValue());
            detail.setFechaElaboracion(dateFormat.format(avisosMp.getFecElaboracion()));
            EstadosModel edos = cliente.getEstado(Integer.valueOf(avisosMp.getIdEstado()));
            String nombreEdo = Objects.isNull(edos) ? "No se encontro registro estados" : edos.getDes_nombre_completo();
            detail.setEstado(nombreEdo);
            DelegacionMunicipioModel del = cliente.getDelegacion(Integer.valueOf(avisosMp.getIdEstado()), Integer.valueOf(avisosMp.getDesDelegacionMunicipio()));
            String nombreDel = Objects.isNull(del) ? "No se encontro registros Delegacion/Municipio" : del.getDes_municipio();
            detail.setDelegacionMunicipio(nombreDel);
            detail.setAgenciaMp(avisosMp.getDesAgenciaMp());
            detail.setNombrePaciente(avisosMp.getNomPaciente());
            detail.setDesNss(avisosMp.getDesNss());
            detail.setUnidadMedica(avisosMp.getDesUnidadMedica());
            detail.setUbicacionHospital(avisosMp.getDesUbicacionUm());
            detail.setCveEspecialidad(avisosMp.getCveEspecialidad());
            List<ServiciosModel> servicios = cliente.getServicio(avisosMp.getCveEspecialidad());
            String nombreServicio = servicios.isEmpty() ? "No se encontro registro" : servicios.get(0).getDes_especialidad();
            detail.setEspecialidad(nombreServicio);
            detail.setCama(avisosMp.getCveCama());
            detail.setFechaIngreso(avisosMp.getFecIngreso().toString());
            detail.setHoraIngreso(avisosMp.getTimIngreso().toString());
            detail.setLesionesPaciente(avisosMp.getDesLesionesPaciente());
            detail.setNombreMedico(avisosMp.getNomMedico());
            detail.setMatriculaMedico(avisosMp.getCveMatriculaMedico());
            detail.setNombreTrabajadorSocial(avisosMp.getNomTrabajadorSocial());
            detail.setMatriculaTrabajadorSocial(avisosMp.getCveMatriculaTs());
            return detail;
        } catch (Exception e) {
            return new DetalleAvisoMp();
        }
    }
}
