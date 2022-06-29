package mx.gob.imss.constantes;


public class Querys {
	public final static String consultaAvisosMPPorRangoDeFechasPaginado = ""
			+ "SELECT  ROWNUM() fila, FEC_ELABORACION, NOM_PACIENTE, NOM_MEDICO, NOM_TS"
			+ "FROM MSMTST_AVISOS_MP AMP"
			+ "WHERE AMP.FEC_ELABORACION BETWEEN ? AND ? "
			+ "ORDER  BY AMP.ID_AMP  asc";
	
	public final static String consultaPorId = ""
	+ "SELECT  AMP.ID_AMP, "
	+ "DATE_FORMAT(FEC_ELABORACION,'%d/%m/%Y') FEC_ELABORACION , "
	+ "DATE_FORMAT(FEC_INGRESO ,'%d/%m/%Y') FEC_INGRESO, AMP.* "
	+ "FROM  MSMTST_AVISOS_MP AMP "
	+ "WHERE AMP.ID_AMP = 1";
	
	public final static String consultaUnidadesMedicasPorIdUm = "SELECT  CAR.* FROM    mtssdds.mtsc_ctl_articulos_recepcion CAR INNER   JOIN mtssdds.mtsc_control_articulos CA ON CA.ID_CONTROL_ARTICULOS = CAR.ID_CONTROL_ARTICULOS WHERE   CA.ID_CONTROL_ARTICULOS = ? ";
	
}
