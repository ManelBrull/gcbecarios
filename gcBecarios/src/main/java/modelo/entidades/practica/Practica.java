package modelo.entidades.practica;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import modelo.dao.BecarioDAO;
import modelo.dao.PracticaDAO;
import modelo.entidades.Becario;
import modelo.entidades.Departamento;
import modelo.entidades.Expediente;
import modelo.entidades.TutorAcademico;

import org.hibernate.HibernateException;

import vista.interfaz.utils.Utils;
import at.modelo.entidades.ICrud;
import at.modelo.entidades.IEsFiltro;

@Entity(name = "practica")
public class Practica implements ICrud <Practica> , IEsFiltro{
	
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
	}


	@Override
	public void delete() throws HibernateException {
		// TODO Auto-generated method stub
		new PracticaDAO().delete(this);
		
	}


	@Override
	public Practica get(int id) throws HibernateException {
		// TODO Auto-generated method stub
		return new PracticaDAO().get(id);
	}


	@Override
	public Iterator<Practica> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return (new PracticaDAO().getAll().iterator());
	}


	@Override
	public void save() throws HibernateException {
		// TODO Auto-generated method stub
		new PracticaDAO().save(this);
	}


	@Override
	public void update(Practica nuevo) throws HibernateException {
		nuevo.setId(this.getId());
		new PracticaDAO().update(this);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bolsaDeEstudios;
		result = prime
				* result
				+ ((decretoAutorizacion == null) ? 0 : decretoAutorizacion
						.hashCode());
		result = prime
				* result
				+ ((departamentoDestino == null) ? 0 : departamentoDestino
						.hashCode());
		result = prime
				* result
				+ ((estudiosCursados == null) ? 0 : estudiosCursados.hashCode());
		result = prime * result
				+ ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result
				+ ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result
				+ ((fechaFinalReal == null) ? 0 : fechaFinalReal.hashCode());
		result = prime
				* result
				+ ((fechaFinalTeorica == null) ? 0 : fechaFinalTeorica
						.hashCode());
		result = prime * result
				+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + numHoras;
		result = prime * result
				+ ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime
				* result
				+ ((profesionalesFormacion == null) ? 0
						: profesionalesFormacion.hashCode());
		result = prime * result
				+ ((refClica == null) ? 0 : refClica.hashCode());
		result = prime
				* result
				+ ((tipoBolsaEstudios == null) ? 0 : tipoBolsaEstudios
						.hashCode());
		result = prime
				* result
				+ ((tipoNumeroDeHoras == null) ? 0 : tipoNumeroDeHoras
						.hashCode());
		result = prime * result
				+ ((tutorAcademico == null) ? 0 : tutorAcademico.hashCode());
		result = prime
				* result
				+ ((tutorAyuntamiento == null) ? 0 : tutorAyuntamiento
						.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Practica))
			return false;
		Practica other = (Practica) obj;
		if (bolsaDeEstudios != other.bolsaDeEstudios)
			return false;
		if (decretoAutorizacion == null) {
			if (other.decretoAutorizacion != null)
				return false;
		} else if (!decretoAutorizacion.equals(other.decretoAutorizacion))
			return false;
		if (departamentoDestino == null) {
			if (other.departamentoDestino != null)
				return false;
		} else if (!departamentoDestino.equals(other.departamentoDestino))
			return false;
		if (estudiosCursados == null) {
			if (other.estudiosCursados != null)
				return false;
		} else if (!estudiosCursados.equals(other.estudiosCursados))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (fechaFinalReal == null) {
			if (other.fechaFinalReal != null)
				return false;
		} else if (!fechaFinalReal.equals(other.fechaFinalReal))
			return false;
		if (fechaFinalTeorica == null) {
			if (other.fechaFinalTeorica != null)
				return false;
		} else if (!fechaFinalTeorica.equals(other.fechaFinalTeorica))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (numHoras != other.numHoras)
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (profesionalesFormacion != other.profesionalesFormacion)
			return false;
		if (refClica == null) {
			if (other.refClica != null)
				return false;
		} else if (!refClica.equals(other.refClica))
			return false;
		if (tipoBolsaEstudios != other.tipoBolsaEstudios)
			return false;
		if (tipoNumeroDeHoras != other.tipoNumeroDeHoras)
			return false;
		if (tutorAcademico == null) {
			if (other.tutorAcademico != null)
				return false;
		} else if (!tutorAcademico.equals(other.tutorAcademico))
			return false;
		if (tutorAyuntamiento == null) {
			if (other.tutorAyuntamiento != null)
				return false;
		} else if (!tutorAyuntamiento.equals(other.tutorAyuntamiento))
			return false;
		return true;
	}


	@Override
	public String[] toTable() {
		String[] fila = new String[6];
		if(expediente == null)
			fila[0] = "";
		else
			fila[0] = expediente.getCentroEducativoInstitucion();
		
		fila[1] = Utils.dateFormatShort(fechaInicio);
		fila[2] = Utils.dateFormatShort(fechaFinalReal);
		if(departamentoDestino == null)
			fila[3] = ""; 
		else
			fila[3] = departamentoDestino.getNombreDepartamento();
		
		fila[4] = profesionalesFormacion.getDisplayString();
		fila[5] = tutorAyuntamiento;
			
		return fila;
	}

}






























