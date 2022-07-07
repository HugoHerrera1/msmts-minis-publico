package mx.gob.imss.avisosmp.controladores;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.AvisoMPRequest;

import mx.gob.imss.avisosmp.servicios.AvisosMpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/msmts-avisos-mp/api")
public class AvisosMPControlador {
    @Autowired
    AvisosMpServices avisosServices;

    @PostMapping(value = "/insertAvisoMP", produces = "application/json",
            consumes = "application/json")
    public ResponseEntity guardaAvisoMP(@RequestBody AvisoMPRequest avisoMp) {
        try {
            return new ResponseEntity(avisosServices.insertAvisoMp(avisoMp), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity findAvisosByFechas(@PathVariable String fechaInicial, @PathVariable String fechaFinal) {
        try {
            return new ResponseEntity(avisosServices.findVolantesByFechas(fechaInicial, fechaFinal), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

