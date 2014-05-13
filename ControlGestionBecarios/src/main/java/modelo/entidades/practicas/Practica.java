package modelo.entidades.practicas;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	private int departamentoDestino;
	
	private Date fechaInicio;
	private Date fechaFinalTeorica;
	private Date fechaFinalReal;
	private Date fechaCreacion;
	
	private String estudiosCursados;
	
	private String tipoNumeroDeHoras;
	private int numHoras;
	
	private String tipoBolsaEstudios;
	private String bolsaDeEstudios;
	
	
	private String tutorAyuntamiento;
	private String decretoAutorizacion;
	
	
	private String refClica;
	private String observaciones;
	
	
	
	

}
