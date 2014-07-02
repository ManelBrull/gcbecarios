package modelo.entidades;

import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import modelo.dao.BecarioDAO;
import modelo.dao.TipoDeExpedienteDAO;

import org.hibernate.HibernateException;

import at.modelo.entidades.ICrud;
import at.modelo.entidades.IEsCombo;

@Entity(name="tipoDeExpediente")
public class TipoDeExpediente implements ICrud <TipoDeExpediente>, IEsCombo{
	
	@Id @GeneratedValue
	private int id;
	@Column(nullable = false)
	private String tipoDeExpediente;
	
	public TipoDeExpediente(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDeExpediente() {
		return tipoDeExpediente;
	}

	public void setTipoDeExpediente(String tipoDeExpediente) {
		this.tipoDeExpediente = tipoDeExpediente;
	}

	@Override
	public void delete() throws HibernateException {
		new TipoDeExpedienteDAO().delete(this);
	}

	@Override
	public TipoDeExpediente get(int id) throws HibernateException {
		return new TipoDeExpedienteDAO().get(id);
	}

	@Override
	public Iterator<TipoDeExpediente> getAll() throws HibernateException {
		return (new TipoDeExpedienteDAO().getAll().iterator());
	}

	@Override
	public void save() throws HibernateException {
		new TipoDeExpedienteDAO().save(this);
	}

	@Override
	public void update(TipoDeExpediente nuevo) throws HibernateException {
		nuevo.setId(this.getId());
		new TipoDeExpedienteDAO().update(this);
	}

	@Override
	public String toCombo() {
		return getTipoDeExpediente();
	}

}
