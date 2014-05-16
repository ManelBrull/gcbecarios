package modelo.entidades;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import modelo.dao.BecarioDAO;
import modelo.dao.ExpedienteDAO;

import org.hibernate.HibernateException;

import at.modelo.entidades.ICrud;

@Entity(name="expediente")
public class Expediente implements ICrud <Expediente>{
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
}
