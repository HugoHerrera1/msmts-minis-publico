package mx.gob.imss.avisosmp.servicios.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.Region;

import org.codehaus.stax2.validation.Validatable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.componentes.ValidaUsuario;
import mx.gob.imss.constantes.Querys;
import mx.gob.imss.avisosmp.dto.Bitacora;
import mx.gob.imss.avisosmp.dto.RequestPorRangoDeFechasPaginado;
import mx.gob.imss.avisosmp.dto.AvisosMPDto;
import mx.gob.imss.avisosmp.dto.Response;
import mx.gob.imss.avisosmp.dto.Ubicacion;
import mx.gob.imss.avisosmp.dto.UnidadesMedicasDto;
import mx.gob.imss.avisosmp.modelo.MsmtsAvisosMP;
import mx.gob.imss.avisosmp.modelo.MsmtsUnidadesMedicas;
import mx.gob.imss.avisosmp.repositorios.MsmtsAvisosMPRepository;
import mx.gob.imss.avisosmp.repositorios.MsmtsUnidadesMedicasRepository;
import mx.gob.imss.avisosmp.servicios.AvisosMPServicio;

@Slf4j
@Service
public class AvisosMPServicioImpl implements AvisosMPServicio{
	@Autowired
	private MsmtsAvisosMPRepository avisosMPRepository;
	
	@Autowired
	private MsmtsUnidadesMedicasRepository unidadesMedicasRepository;
	
	@Autowired
	private ValidaUsuario validaUsuario;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Response consultaAvisosMPPorIdAmp(AvisosMPDto avisosMPJson) { 
		List<AvisosMPDto> listaAvisosMP = new ArrayList<>();
		List<String> listaDeAvisos = new ArrayList<>();
		
		Response response = new Response();
		Bitacora bitacora = avisosMPJson.getBitacora();
		//avisosMPJson.setPersonalQueElaboro(bitacora.getIdUsuario()+"");
		
		if ( validaUsuario.validaUsuario(bitacora.getTipoUsuario()) ) {
			
			MsmtsAvisosMP consulta = new MsmtsAvisosMP();
			try {
				consulta = avisosMPRepository.consultaPorId(avisosMPJson.getIdAmp());
			} catch (Exception e) {
				response.setMensaje("Algo salio mal al realizar la consulta");
				response.setStatus(HttpStatus.NOT_FOUND);
				
				Gson gson = new Gson();
				String responseJson = gson.toJson(response);
				response.setMensaje(responseJson);
				
				response.setListaAvisosMPDto(listaAvisosMP);
				return response;
			}
			
			/*
			String ubicacion =  "";
			try {
				ubicacion = ubicacionEndpoint(consulta.getUbicacion());
			} catch (Exception e) {
				e.getMessage();
			}*/
			
			AvisosMPDto avisosMPDto = new AvisosMPDto();
			avisosMPDto.setIdAmp(consulta.getIdApm());
			avisosMPDto.setFecFecha(consulta.getFecFecha());
			avisosMPDto.setNumCama(consulta.getNumCama());
			avisosMPDto.setIdEspecialidad(consulta.getIdEspecialidad());
			avisosMPDto.setNombrePaciente(consulta.getNombrePaciente());
			avisosMPDto.setUnidadesMedicas(null);
			avisosMPDto.setUbicadoEn(consulta.getUbicadoEn());;
			avisosMPDto.setFecIngreso(consulta.getFecIngreso());
			avisosMPDto.setLesionesPaciente(consulta.getLesionesPaciente());
			avisosMPDto.setNombreMedico(consulta.getNombreMedico());
			avisosMPDto.setMatriculaMedico(consulta.getMatriculaMedico());
			avisosMPDto.setNombreTS(consulta.getNombreTS());
			avisosMPDto.setMatriculaTS(consulta.getMatriculaTS());	
			
			List<MsmtsUnidadesMedicas> listaDeUnidadesMedicas = unidadesMedicasRepository.consultaUnidadesMedicasPorIdUm(consulta.getIdUnidadMed());
			for ( MsmtsUnidadesMedicas unidadesMedicas : listaDeUnidadesMedicas ) {
				UnidadesMedicasDto unidadesMedicasDto = new UnidadesMedicasDto();
				unidadesMedicasDto.setIdUnidadMed(unidadesMedicas.getIdUnidadMed());
				unidadesMedicasDto.setUnidadMedicaDescripcion(unidadesMedicas.getUnidadMedicaDescripcion());
				listaDeAvisos.add(unidadesMedicasDto.getUnidadMedicaDescripcion());
			}
			avisosMPDto.setAvisosArray(listaDeAvisos);
			
			response.setMensaje("Operacion correcta");
			response.setStatus(HttpStatus.OK);
			
			response.setAvisosMPDto(avisosMPDto);
			return response; 	
		}
		
		return response; 	
	}
	
	
	@Override
	public Response consultaAvisosMPPorRangoDeFechasPaginado(RequestPorRangoDeFechasPaginado consultaPorRangoDeFechasPaginado) {
		Response response = new Response();
		int paginaInicial = 1;
		int paginaFinal = 50;
		int paginado = 50;
		
		if ( consultaPorRangoDeFechasPaginado.getPagina() > 1 ) {
			paginaInicial *= paginado;
			paginaFinal = paginaInicial + paginado;
		}
		
		List<AvisosMPDto> listaAvisosMP = new ArrayList<>();
		List<MsmtsAvisosMP> consulta = 
				avisosMPRepository.consultaAvisosMPPorRangoDeFechasPaginado(
						consultaPorRangoDeFechasPaginado.getFechaInicial(), 
						consultaPorRangoDeFechasPaginado.getFechaFinal(), 
						consultaPorRangoDeFechasPaginado.getClavePaciente(),
						paginaInicial, paginaFinal);
				
		for ( MsmtsAvisosMP registro : consulta ) {
			AvisosMPDto avisosMPDto = new AvisosMPDto();
			avisosMPDto.setIdAmp(registro.getIdApm());
			avisosMPDto.setFecFecha(registro.getFecFecha());
			avisosMPDto.setNombrePaciente(registro.getNombrePaciente());
			avisosMPDto.setNombreMedico(registro.getNombreMedico());
			avisosMPDto.setNombreTS(registro.getNombreTS());
			
			listaAvisosMP.add(avisosMPDto);
		}
		
		response.setMensaje("Operacion correcta");
		response.setStatus(HttpStatus.OK);
		response.setListaAvisosMPDto(listaAvisosMP);
		
		return response;
	}
	
	public String formatearFecha (String fecha) {
		if ( fecha == null || fecha.isEmpty() ) {
			return null;
		}
		
		String[] fechaSplit = fecha.split("/");
		fecha = fechaSplit[2]+fechaSplit[1]+fechaSplit[0];
		
		return fecha;
	}
	
	@Override
	public Response guardarAvisosMP(AvisosMPDto avisosMPJson) {
		MsmtsAvisosMP avisosMP = new MsmtsAvisosMP();
		
		Response response = new Response();
		Bitacora bitacora = avisosMPJson.getBitacora();
		//avisosMPJson.setPersonalQueElaboro(bitacora.getIdUsuario()+"");
		
		if ( validaUsuario.validaUsuario(bitacora.getTipoUsuario()) ) {
			//avisosMP.setPersonalQueElaboro(avisosMPJson.getPersonalQueElaboro());
			avisosMP.setIdApm(avisosMPJson.getIdAmp());
			avisosMP.setFecFecha(formatearFecha (avisosMPJson.getFecFecha()));
			avisosMP.setIdDelegacion(avisosMPJson.getIdDelegacion());
			avisosMP.setAgenciaDelMP(avisosMPJson.getAgenciaDelMP());
			avisosMP.setNombrePaciente(avisosMPJson.getNombrePaciente());
			avisosMP.setUbicadoEn(avisosMPJson.getUbicadoEn());
			avisosMP.setIdEspecialidad(avisosMPJson.getIdEspecialidad());
			avisosMP.setNumCama(avisosMPJson.getNumCama());
			avisosMP.setFecIngreso(formatearFecha (avisosMPJson.getFecIngreso()));
			avisosMP.setHoraIngreso(avisosMPJson.getHoraIngreso());
			avisosMP.setLesionesPaciente(avisosMPJson.getLesionesPaciente());
			avisosMP.setNombreMedico(avisosMPJson.getNombreMedico());
			avisosMP.setMatriculaMedico(avisosMPJson.getMatriculaMedico());
			avisosMP.setNombreTS(avisosMPJson.getNombreTS());
			avisosMP.setMatriculaTS(avisosMPJson.getMatriculaTS());
			
			MsmtsAvisosMP consulta = new MsmtsAvisosMP();
			try {
				consulta = avisosMPRepository.saveAndFlush(avisosMP);
			} catch (Exception e) {
				response.setMensaje("Fallo al crear el registro principal: "+e.getMessage());
				response.setStatus(HttpStatus.NOT_FOUND);
				
				Gson gson = new Gson();
				String responseJson = gson.toJson(response);
				response.setMensaje(responseJson);
				
				return response;
			}
			
		//	String folio = calcularFolio(consulta.getIdApm());
		//	avisosMP.setNoFolioControl(folio);
			avisosMP.setIdApm(consulta.getIdApm());
			consulta = avisosMPRepository.save(avisosMP);
			
			
			if ( avisosMPJson.getAvisosArray() != null ) {
				List<String> avisosMp = avisosMPJson.getAvisosArray();
				for ( String aviso : avisosMp ) {
					if ( aviso != null ) {
						MsmtsUnidadesMedicas unidadesMedicasModel = new MsmtsUnidadesMedicas();
						unidadesMedicasModel.setIdUnidadMed(consulta.getIdUnidadMed());
						unidadesMedicasModel.setUnidadMedicaDescripcion(aviso);;
						unidadesMedicasModel.setIndActivo(1);
						
						unidadesMedicasRepository.saveAndFlush(unidadesMedicasModel);
						
						try {
							unidadesMedicasRepository.saveAndFlush(unidadesMedicasModel);
						} catch (Exception e) {
							response.setMensaje("Fallo al crear el guardar el aviso: "+aviso+", "+e.getMessage());
							response.setStatus(HttpStatus.NOT_FOUND);
							
							Gson gson = new Gson();
							String responseJson = gson.toJson(response);
							response.setMensaje(responseJson);
							
							return response;
						}
					}
					
				}
			}
			
			response.setMensaje("Operacion correcta ");
			response.setStatus(HttpStatus.OK);
			response.setIdAmp(avisosMP.getIdApm());
			
			Gson gson = new Gson();
			String responseJson = gson.toJson(response);
			response.setMensaje(responseJson);
			
			return response;
		}
		else {
			response.setMensaje("Usuario no valido");
			response.setStatus(HttpStatus.NOT_FOUND);
			
			return response;
		}
	}


	@Override
	public String ubicacionEndpoint(String cveUbicacion) {
		if ( cveUbicacion == null || cveUbicacion.isEmpty() ) {
			System.out.println("No se recibio clave de ubicacion");
			return null;
		}
		
		Response response = new Response();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(header);
		ResponseEntity<String> responseEntity = null ;
		
		try {
			responseEntity = restTemplate.exchange(
					"https://adt-qa.cloudapps.imss.gob.mx/msedsc-catalogos/api/listUbicacion/"+cveUbicacion, 
					HttpMethod.GET,entity, new ParameterizedTypeReference<String>() {
					});
		} catch (Exception e) {
			System.out.println("Fallo al consumir el servicio");
		}
		
		Gson gson = new Gson();
	//	List<Ubicacion> listaUbicaciones = new ArrayList<>();
				
		String descripcion = "";
		
		JSONArray json = new JSONArray(responseEntity.getBody());
		JSONObject ubicacion = json.getJSONObject(0);
		descripcion = ubicacion.getString("des_completa_ubicacion");
		System.out.println(descripcion);
		
		return descripcion;
	}

}


































