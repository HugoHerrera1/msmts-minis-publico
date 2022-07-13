package mx.gob.imss.componentes;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.modelo.DelegacionMunicipioModel;
import mx.gob.imss.avisosmp.modelo.EstadosModel;
import mx.gob.imss.avisosmp.modelo.ServiciosModel;
import mx.gob.imss.constantes.AvisosMPConstantes;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Component
public class AgendaDigitalCliente {

    @Value("${app.agenda.digital.url}")
    private String agendaDigitalUrl;

    @Autowired
    private MessageSource messageSource;
    @Cacheable(cacheNames = "servicios")
    public List<ServiciosModel> getServicio(String idServicio) {
        log.error("Se hace la consulta servicios por medio del cliente - no caching- ");
        try {
            Client client = ClientBuilder.newClient().register(new JacksonFeature());
            return client.target(agendaDigitalUrl + AvisosMPConstantes.GET_SERVICIOS_PATH + "/" + idServicio)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<List<ServiciosModel>>() {
                    });
        } catch (Exception e) {
            log.error(messageSource.getMessage("SERVICIO_NO_ENCONTRADO", new Object[]{"SERVICIOS [" + idServicio + "]", e.getMessage()}, Locale.getDefault()));
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Cacheable(cacheNames = "edos")
    public EstadosModel getEstado(Integer idEstado) {
        log.error("Se hace la consulta estados por medio del cliente - no caching- ");
        try {
            Client client = ClientBuilder.newClient().register(new JacksonFeature());
            return client.target(agendaDigitalUrl + AvisosMPConstantes.GET_ESTADO_PATH + "/" + idEstado)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<EstadosModel>() {
                    });
        } catch (Exception e) {
            log.error(messageSource.getMessage("ESTADO_NO_ENCONTRADO", new Object[]{"ESTADO [" + idEstado + "]", e.getMessage()}, Locale.getDefault()));
            e.printStackTrace();
            return new EstadosModel();
        }
    }


    @Cacheable(cacheNames = "delegacion")
    public DelegacionMunicipioModel getDelegacion(Integer idEstado, Integer idDelegacion) {
        log.error("Se hace la consulta delegacion por medio del cliente - no caching- ");
        try {
            Client cliente = ClientBuilder.newClient().register(new JacksonFeature());
            return cliente.target(agendaDigitalUrl + AvisosMPConstantes.GET_DELEGACION_PATH + "/" + idEstado + "/" + idDelegacion)
                    .request(MediaType.APPLICATION_JSON).get(new GenericType<DelegacionMunicipioModel>() {
                    });
        } catch (Exception ex) {
            log.error(messageSource.getMessage("DELEGACION_NO_ENCONTRADO", new Object[]{"DELEGACION [" + idDelegacion + "] : ESTADO [" + idEstado + "]", ex.getMessage()}, Locale.getDefault()));
            ex.printStackTrace();
            return new DelegacionMunicipioModel();
        }
    }

}
