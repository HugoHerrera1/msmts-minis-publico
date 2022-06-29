package mx.gob.imss.componentes;

import org.springframework.stereotype.Component;

@Component
public class ValidaUsuario {
	
	public final int AUXILIAR_TRABAJO_SOCIAL = 1;
	public final int ASISTENTE_TRABAJADOR_SOCIAL = 2;
	public final int TRABAJADOR_SOCIAL = 3;
	public final int TRABAJADOR_SOCIAL_CLINICO = 4;
	public final int JEFE_TRABAJO_SOCIAL = 5;
	public final int SUBJEFE_TRABAJO_SOCIAL = 6;
	
	public boolean validaUsuario ( int tipoUsuario ) {
		
		if ( tipoUsuario <= 0 ) {
			return false;
		}
		
		switch ( tipoUsuario ) {
		case AUXILIAR_TRABAJO_SOCIAL:
			return true;
			
		case ASISTENTE_TRABAJADOR_SOCIAL:
			return true;
			
		case TRABAJADOR_SOCIAL:
			return true;
			
		case TRABAJADOR_SOCIAL_CLINICO:
			return true;
			
		case JEFE_TRABAJO_SOCIAL:
			return true;
			
		case SUBJEFE_TRABAJO_SOCIAL:
			return true;
		}
		
		return false;
	}
}
