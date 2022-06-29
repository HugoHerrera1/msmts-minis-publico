package mx.gob.imss.avisosmp.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.Response;
import mx.gob.imss.avisosmp.servicios.CatalogosInt;

@Slf4j
@Service
public class CatalogosImpl implements CatalogosInt {
	
	public Response ConsultaHorarios() {
		return null;
		
	}
	/*
	@Autowired
	private AdtcorebddsHorarios catalogos;

	@Override
	public Response ConsultaHorarios() {
		
		List<AdtcorebddsHorariosModel> consulta = new ArrayList<>();
		
		try {
			consulta = catalogos.consultaHorarios();
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		List<Horarios> listaDeHorarios = new ArrayList<>();
		for ( AdtcorebddsHorariosModel horarioConsulta : consulta ) {
			Horarios horario = new Horarios();
			horario.setIdHorario(horarioConsulta.getIdHorario());
			
			String horaInicial = horarioConsulta.getHoraInicial();
			String horaFinal = horarioConsulta.getHoraFinal();
			
			String[] horaInicialSplit = horaInicial.split(":");
			String[] horaFinalSplit = horaFinal.split(":");
			
			horaInicial = horaInicialSplit[0] + ":" + horaInicialSplit[1];
			horaFinal = horaFinalSplit[0] + ":" + horaFinalSplit[1];
			
			String descripcion = horarioConsulta.getNomDia() + " " + horaInicial + "-" + horaFinal;
			horario.setNomDia(descripcion);
			
			listaDeHorarios.add(horario);
		}
		
		Response response = new Response();
		response.setMensaje("Consulta realizada con exito");
		response.setStatus(HttpStatus.OK);
		response.setListaDeHorarios(listaDeHorarios);
		
		
		return response;
		
	} */
	
}

