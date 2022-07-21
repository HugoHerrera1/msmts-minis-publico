package mx.gob.imss.avisosmp.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.sql.Time;

@Entity
@Table(name = "MTST_AVISOS_MP")
public class MtstAvisosMp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AVISO_MP", nullable = false)
    private Long id;

    @Column(name = "FEC_ELABORACION")
    private Date fecElaboracion;

    @Column(name = "DES_DELEGACION_MUNICIPIO", length = 100)
    private String desDelegacionMunicipio;

    @Column(name = "DES_AGENCIA_MP", length = 100)
    private String desAgenciaMp;

    @Column(name = "NOM_PACIENTE", length = 100)
    private String nomPaciente;

    @Column(name = "DES_UNIDAD_MEDICA", length = 100)
    private String desUnidadMedica;

    @Column(name = "DES_UBICACION_UM", length = 1000)
    private String desUbicacionUm;
    @Column(name = "CVE_ESPECIALIDAD", length = 100)
    private String cveEspecialidad;

    @Column(name = "CVE_CAMA", length = 100)
    private String cveCama;

    @Column(name = "FEC_INGRESO")
    private Date fecIngreso;

    @Column(name = "TIM_INGRESO")
    private Time timIngreso;

    @Column(name = "DES_LESIONES_PACIENTE", length = 2000)
    private String desLesionesPaciente;

    @Column(name = "NOM_MEDICO", length = 100)
    private String nomMedico;

    @Column(name = "NOM_TRABAJADOR_SOCIAL", length = 100)
    private String nomTrabajadorSocial;

    @Column(name = "FEC_ALTA")
    private Date fecAlta;

    @Column(name = "FEC_ACTUALIZACION")
    private Date fecActualizacion;

    @Column(name = "FEC_BAJA")
    private Date fecBaja;

    @Column(name = "IND_ACTIVO")
    private Boolean indActivo;

    @Column(name = "ID_ESTADO")
    private String idEstado;

    @Column(name = "CVE_MATRICULA_MEDICO", length = 100)
    private String cveMatriculaMedico;

    @Column(name = "CVE_MATRICULA_TS", length = 100)
    private String cveMatriculaTs;

    @Column(name = "FEC_EXPIRA")
    private Date fecExpira;

    @Column(name = "DES_NSS", length = 20)
    private String desNss;

    public String getDesNss() {
        return desNss;
    }

    public void setDesNss(String desNss) {
        this.desNss = desNss;
    }

    public Date getFecExpira() {
        return fecExpira;
    }

    public void setFecExpira(Date fecExpira) {
        this.fecExpira = fecExpira;
    }

    public String getCveMatriculaTs() {
        return cveMatriculaTs;
    }

    public void setCveMatriculaTs(String cveMatriculaTs) {
        this.cveMatriculaTs = cveMatriculaTs;
    }

    public String getCveMatriculaMedico() {
        return cveMatriculaMedico;
    }

    public void setCveMatriculaMedico(String cveMatriculaMedico) {
        this.cveMatriculaMedico = cveMatriculaMedico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecElaboracion() {
        return fecElaboracion;
    }

    public void setFecElaboracion(Date fecElaboracion) {
        this.fecElaboracion = fecElaboracion;
    }

    public String getDesDelegacionMunicipio() {
        return desDelegacionMunicipio;
    }

    public void setDesDelegacionMunicipio(String desDelegacionMunicipio) {
        this.desDelegacionMunicipio = desDelegacionMunicipio;
    }

    public String getDesAgenciaMp() {
        return desAgenciaMp;
    }

    public void setDesAgenciaMp(String desAgenciaMp) {
        this.desAgenciaMp = desAgenciaMp;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getDesUnidadMedica() {
        return desUnidadMedica;
    }

    public void setDesUnidadMedica(String desUnidadMedica) {
        this.desUnidadMedica = desUnidadMedica;
    }

    public String getDesUbicacionUm() {
        return desUbicacionUm;
    }

    public void setDesUbicacionUm(String desUbicacionUm) {
        this.desUbicacionUm = desUbicacionUm;
    }

    public String getCveEspecialidad() {
        return cveEspecialidad;
    }

    public void setCveEspecialidad(String cveEspecialidad) {
        this.cveEspecialidad = cveEspecialidad;
    }

    public String getCveCama() {
        return cveCama;
    }

    public void setCveCama(String cveCama) {
        this.cveCama = cveCama;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Time getTimIngreso() {
        return timIngreso;
    }

    public void setTimIngreso(Time timIngreso) {
        this.timIngreso = timIngreso;
    }

    public String getDesLesionesPaciente() {
        return desLesionesPaciente;
    }

    public void setDesLesionesPaciente(String desLesionesPaciente) {
        this.desLesionesPaciente = desLesionesPaciente;
    }

    public String getNomMedico() {
        return nomMedico;
    }

    public void setNomMedico(String nomMedico) {
        this.nomMedico = nomMedico;
    }
    public String getNomTrabajadorSocial() {
        return nomTrabajadorSocial;
    }

    public void setNomTrabajadorSocial(String nomTrabajadorSocial) {
        this.nomTrabajadorSocial = nomTrabajadorSocial;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecActualizacion() {
        return fecActualizacion;
    }

    public void setFecActualizacion(Date fecActualizacion) {
        this.fecActualizacion = fecActualizacion;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Boolean getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(Boolean indActivo) {
        this.indActivo = indActivo;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }
}