package modelo.entidades;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import modelo.DateUtil;
import modelo.dao.BecarioDAO;
import modelo.dao.ExpedienteDAO;

import org.hibernate.HibernateException;

import vista.interfaz.Utils;
import at.modelo.entidades.ICrud;
import at.modelo.entidades.IEsFiltro;

@Entity(name="expediente")
public class Expediente implements ICrud <Expediente>, IEsFiltro{
	@Id @GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String centroEducativoInstitucion;
	private String acuerdoDecreto;
	private String refClica;
	private Date fechaExpediente;
	
	@OneToOne 
	@JoinColumn(name = "idTipoDeExpediente", nullable = false)
	private TipoDeExpediente tipoDeExpediente;
	
	public Expediente(){};
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentroEducativoInstitucion() {
		return centroEducativoInstitucion;
	}

	public void setCentroEducativoInstitucion(String centroEducativoInstitucion) {
		this.centroEducativoInstitucion = centroEducativoInstitucion;
	}

	public String getAcuerdoDecreto() {
		return acuerdoDecreto;
	}

	public void setAcuerdoDecreto(String acuerdoDecreto) {
		this.acuerdoDecreto = acuerdoDecreto;
	}

	public String getRefClica() {
		return refClica;
	}

	public void setRefClica(String refClica) {
		this.refClica = refClica;
	}

	public Date getFechaExpediente() {
		return fechaExpediente;
	}

	public void setFechaExpediente(Date fechaExpediente) {
		this.fechaExpediente = fechaExpediente;
	}

	public TipoDeExpediente getTipoDeExpediente() {
		return tipoDeExpediente;
	}

	public void setTipoDeExpediente(TipoDeExpediente tipoDeExpediente) {
		this.tipoDeExpediente = tipoDeExpediente;
	}


	@Override
	public void delete() throws HibernateException {
		// TODO Auto-generated method stub
		new ExpedienteDAO().delete(this);
	}


	@Override
	public Expediente get(int id) throws HibernateException {
		return new ExpedienteDAO().get(id);
	}


	@Override
	public Iterator<Expediente> getAll() throws HibernateException {
		return (new ExpedienteDAO().getAll().iterator());
	}


	@Override
	public void save() throws HibernateException {
		new ExpedienteDAO().save(this);
	}


	@Override
	public void update(Expediente nuevo) throws HibernateException {
		nuevo.setId(this.getId());
		new ExpedienteDAO().update(this);
	}


	@Override
	public String[] toTable() {
		return new String[]{
				getTipoDeExpediente().getTipoDeExpediente(), 
				getCentroEducativoInstitucion(), 
				getRefClica(), 
				getAcuerdoDecreto(), 
				Utils.dateFormatShort(getFechaExpediente())
				};
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((acuerdoDecreto == null) ? 0 : acuerdoDecreto.hashCode());
		result = prime
				* result
				+ ((centroEducativoInstitucion == null) ? 0
						: centroEducativoInstitucion.hashCode());
		result = prime * result
				+ ((fechaExpediente == null) ? 0 : fechaExpediente.hashCode());
		result = prime * result
				+ ((refClica == null) ? 0 : refClica.hashCode());
		result = prime
				* result
				+ ((tipoDeExpediente == null) ? 0 : tipoDeExpediente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Expediente))
			return false;
		Expediente other = (Expediente) obj;
		if (acuerdoDecreto == null) {
			if (other.acuerdoDecreto != null)
				return false;
		} else if (!acuerdoDecreto.equals(other.acuerdoDecreto))
			return false;
		if (centroEducativoInstitucion == null) {
			if (other.centroEducativoInstitucion != null)
				return false;
		} else if (!centroEducativoInstitucion
				.equals(other.centroEducativoInstitucion))
			return false;
		if (fechaExpediente == null) {
			if (other.fechaExpediente != null)
				return false;
		} else if (!DateUtil.equalDateddMMyyyy(fechaExpediente, other.fechaExpediente))
			return false;
		if (refClica == null) {
			if (other.refClica != null)
				return false;
		} else if (!refClica.equals(other.refClica))
			return false;
		if (tipoDeExpediente == null) {
			if (other.tipoDeExpediente != null)
				return false;
		} else if (!tipoDeExpediente.equals(other.tipoDeExpediente))
			return false;
		return true;
	}
	
}
