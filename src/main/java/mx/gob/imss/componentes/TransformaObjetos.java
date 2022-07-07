package mx.gob.imss.componentes;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.AvisoMPRequest;
import mx.gob.imss.avisosmp.dto.AvisosMpList;
import mx.gob.imss.avisosmp.modelo.MtstAvisosMp;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Component
public class TransformaObjetos {

    public MtstAvisosMp buildInsert(AvisoMPRequest avisoMPRequest) throws ParseException {
        MtstAvisosMp mp = new MtstAvisosMp();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        Date date = format.parse(avisoMPRequest.getFechaRegistroAviso());
        mp.setFecElaboracion(date);
        mp.setDesDelegacionMunicipio(avisoMPRequest.getAlcaldia());
        mp.setDesAgenciaMp(avisoMPRequest.getAgenciaMP());
        mp.setNomPaciente(avisoMPRequest.getNombrePaciente());
        mp.setDesUnidadMedica(avisoMPRequest.getIdUnidadHospital());
        mp.setCveEspecialidad(avisoMPRequest.getCveServicio());
        mp.setCveCama(avisoMPRequest.getNumCama());
        mp.setFecIngreso(format.parse(avisoMPRequest.getFechaIngreso()));
        mp.setTimIngreso(new Time(formatTime.parse(avisoMPRequest.getHoraIngreso()).getTime()));
        mp.setDesLesionesPaciente(avisoMPRequest.getLesionesPaciente());
        mp.setNomMedico(avisoMPRequest.getNombreMedicoTratante());
        mp.setDesMatriculaMedico(avisoMPRequest.getMatriculaMedicoTratante());
        mp.setNomTrabajadorSocial(avisoMPRequest.getNombreTrabajadorSocial());
        mp.setDesMatriculaTs(avisoMPRequest.getMatriculaTrabajadorSocial());
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
            return response;
        } catch (Exception ex) {
            response.setIdAvisoMp(null);
            response.setNombrePaciente("");
            response.setFechaElaboracion("");
            return response;
        }
    }
}
