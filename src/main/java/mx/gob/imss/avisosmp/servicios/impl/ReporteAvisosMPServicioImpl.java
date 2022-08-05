package mx.gob.imss.avisosmp.servicios.impl;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.avisosmp.dto.ReporteAvisosMPDto;
import mx.gob.imss.avisosmp.servicios.ReporteAvisosMPServicio;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ReporteAvisosMPServicioImpl implements ReporteAvisosMPServicio {
	
	 @SuppressWarnings("finally")
	public byte[] imprimeAvisosMP (ReporteAvisosMPDto reporte) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		byte[] filePdf = new byte [0];
		
		 parameters.put("estado", reporte.getEstado());
	        parameters.put("dia", reporte.getDia());
	        parameters.put("mes", reporte.getMes());
	        parameters.put("año", reporte.getAño());
	        parameters.put("alcaldia", reporte.getAlcaldia());
	        parameters.put("nombrePac", reporte.getNombrePac());
	        parameters.put("nombreHosp", reporte.getNombreHosp());
	        parameters.put("ubicacionHosp", reporte.getUbicacionHosp());
	        parameters.put("servicio", reporte.getServicio());
	        parameters.put("cama", reporte.getCama());
	        parameters.put("fecIngreso", reporte.getFecIngreso());
	        parameters.put("hrIngreso", reporte.getHrIngreso());
	        parameters.put("observaciones", reporte.getObservaciones());
	        parameters.put("nomMedico", reporte.getNomMedico());
	        parameters.put("matriculaMed", reporte.getMatriculaMed());
	        parameters.put("nomTS", reporte.getNomTS());
	        parameters.put("matTS", reporte.getMatTS());
	        parameters.put("imgSource2", new ClassPathResource("reports/logo_imss2.jpg").getPath());
	        parameters.put("imgSource", new ClassPathResource("reports/logo_imss1.jpg").getPath());
	        
	        try {

	            InputStream reportStream = new ClassPathResource("reports/Reporte_AvisoMP.jrxml").getInputStream();
	            
	            //Compila reporte
	            JasperReport report = JasperCompileManager.compileReport(reportStream);
	            reportStream.close();

	            //Generar PDF
	            filePdf = JasperRunManager.runReportToPdf(report, parameters, new JREmptyDataSource());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            return filePdf;
	        }
		
	}
	

}