package mx.gob.imss.avisosmp.controladores;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.AvisoMPRequest;
import mx.gob.imss.avisosmp.dto.ReporteAvisosMPDto;
import mx.gob.imss.avisosmp.servicios.AvisosMpServices;
import mx.gob.imss.avisosmp.servicios.ReporteAvisosMPServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/msmts-minis-publico/api")
public class AvisosMPControlador {

    @Autowired
    AvisosMpServices avisosServices;

    @Autowired
    private ReporteAvisosMPServicio reporteAvisosMPServicio;

    @PostMapping(value = "/insertAvisoMP", produces = "application/json",
            consumes = "application/json")
    @CacheEvict(value = {"avisosMpfindAvisosMp", "avisosMpFindAvisosMpById"}, allEntries = true)
    public ResponseEntity guardaAvisoMP(@RequestBody AvisoMPRequest avisoMp) {
        try {
            return new ResponseEntity(avisosServices.insertAvisoMp(avisoMp), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/findAvisosMpByFechas/{fechaInicial}/{fechaFinal}", produces = "application/json")
    public ResponseEntity findAvisosByFechas(@PathVariable String fechaInicial, @PathVariable String fechaFinal) {
        try {
            return new ResponseEntity(avisosServices.findAvisosByFechas(fechaInicial, fechaFinal), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/findAvisoById/{idAviso}", produces = "application/json")
    public ResponseEntity findDetalleAviso(@PathVariable Integer idAviso) {
        try {
            return new ResponseEntity(avisosServices.findAvisosById(idAviso), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/reporteAvisoMP", consumes = "application/json")
    public ResponseEntity<Resource> download(@RequestBody ReporteAvisosMPDto reporte) {

        byte[] filePdf = reporteAvisosMPServicio.imprimeAvisosMP(reporte);
        ByteArrayResource resource = new ByteArrayResource(filePdf);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Reporte_AvisosMP.pdf")
                .contentType(MediaType.APPLICATION_OCTET_STREAM).contentLength(filePdf.length).body(resource);
    }

    @GetMapping(path = "/findAvisosMpAdmin/{fechaInicial}/{fechaFinal}", produces = "application/json")
    public ResponseEntity findAvisosAdministracion(@PathVariable String fechaInicial, @PathVariable String fechaFinal) {
        try {
            return new ResponseEntity(avisosServices.findAvisosAdministracion(fechaInicial, fechaFinal), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/evictallcaches", produces = "application/json")
    public ResponseEntity<String> evictAllcaches() {

        return new ResponseEntity<>(avisosServices.evictAllcaches(), HttpStatus.OK);

    }

}


