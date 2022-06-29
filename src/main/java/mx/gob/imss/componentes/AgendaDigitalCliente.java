package mx.gob.imss.componentes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AgendaDigitalCliente {

    @Value("${app.agenda.digital.url}")
    private String agendaDigitalUrl;

    @Autowired
    private MessageSource messageSource;

//    public List<DiagnosticoMedico> getDiagnosticoMedico(String desDiagnostico) {
//
//        try {
//            Client client = ClientBuilder.newClient().register(new JacksonFeature());
//            return client.target(agendaDigitalUrl + messageSource.getMessage("DIAGNOSTICO_MEDICO_PATH", new Object[]{}, Locale.getDefault()))
//                    .request(MediaType.APPLICATION_JSON).get(new GenericType<List<DiagnosticoMedico>>() {
//                    });
//        } catch (Exception e) {
//            //log.error(messageSource.getMessage("AGENDA_DIGITAL_DIAGNOSTICO", new Object[]{e.getMessage()}, Locale.getDefault()));
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//
//    }



}
