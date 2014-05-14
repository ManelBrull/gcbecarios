package modelo.entidades.practica;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import modelo.entidades.Departamento;
import modelo.entidades.Expediente;
import modelo.entidades.TutorAcademico;

@Entity(name = "practica")
public class Practica {
	
	@Id @GeneratedValue
	private int id;
	@OneToOne 
	@JoinColumn(name = "idExpediente", nullable = false)
	private Expediente expediente;
	@OneToOne 
	@JoinColumn(name = "idTutorAcademico")
	private TutorAcademico tutorAcademico;
	@OneToOne 
	@JoinColumn(name = "idDepartamentoDestino", nullable = false)
	private Departamento departamentoDestino;
	
	@Enumerated(EnumType.STRING)
	private TipoPractica profesionalesFormacion;
	
	private Date fechaInicio;
	private Date fechaFinalTeorica;
	private Date fechaFinalReal;
	private Date fechaCreacion;
	private String estudiosCursados;
	@Enumerated(EnumType.STRING)
	private TipoHoras tipoNumeroDeHoras;
	private int numHoras;
	@Enumerated(EnumType.STRING)
	private TipoBolsaEstudios tipoBolsaEstudios;
	private int bolsaDeEstudios;
	private String tutorAyuntamiento;
	private String decretoAutorizacion;
	private String refClica;
	@Column(length = 1024)
	private String observaciones;
	
	
	public Practica(){}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public TutorAcademico getTutorAcademico() {
		return tutorAcademico;
	}

	public void setTutorAcademico(TutorAcademico tutorAcademico) {
		this.tutorAcademico = tutorAcademico;
	}

	public Departamento getDepartamentoDestino() {
		return departamentoDestino;
	}

	public void setDepartamentoDestino(Departamento departamentoDestino) {
		this.departamentoDestino = departamentoDestino;
	}

	public TipoPractica getProfesionalesFormacion() {
		return profesionalesFormacion;
	}

	public void setProfesionalesFormacion(TipoPractica profesionalesFormacion) {
		this.profesionalesFormacion = profesionalesFormacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalTeorica() {
		return fechaFinalTeorica;
	}

	public void setFechaFinalTeorica(Date fechaFinalTeorica) {
		this.fechaFinalTeorica = fechaFinalTeorica;
	}

	public Date getFechaFinalReal() {
		return fechaFinalReal;
	}

	public void setFechaFinalReal(Date fechaFinalReal) {
		this.fechaFinalReal = fechaFinalReal;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstudiosCursados() {
		return estudiosCursados;
	}

	public void setEstudiosCursados(String estudiosCursados) {
		this.estudiosCursados = estudiosCursados;
	}

	public TipoHoras getTipoNumeroDeHoras() {
		return tipoNumeroDeHoras;
	}

	public void setTipoNumeroDeHoras(TipoHoras tipoNumeroDeHoras) {
		this.tipoNumeroDeHoras = tipoNumeroDeHoras;
	}

	public int getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}

	public TipoBolsaEstudios getTipoBolsaEstudios() {
		return tipoBolsaEstudios;
	}

	public void setTipoBolsaEstudios(TipoBolsaEstudios tipoBolsaEstudios) {
		this.tipoBolsaEstudios = tipoBolsaEstudios;
	}

	public int getBolsaDeEstudios() {
		return bolsaDeEstudios;
	}

	public void setBolsaDeEstudios(int bolsaDeEstudios) {
		this.bolsaDeEstudios = bolsaDeEstudios;
	}

	public String getTutorAyuntamiento() {
		return tutorAyuntamiento;
	}

	public void setTutorAyuntamiento(String tutorAyuntamiento) {
		this.tutorAyuntamiento = tutorAyuntamiento;
	}

	public String getDecretoAutorizacion() {
		return decretoAutorizacion;
	}

	public void setDecretoAutorizacion(String decretoAutorizacion) {
		this.decretoAutorizacion = decretoAutorizacion;
	}

	public String getRefClica() {
		return refClica;
	}

	public void setRefClica(String refClica) {
		this.refClica = refClica;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	};
	
	
	

}
