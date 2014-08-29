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
import at.modelo.entidades.IEsFiltro;

@Entity(name="tipoDeExpediente")
public class TipoDeExpediente implements ICrud <TipoDeExpediente>, IEsFiltro, IEsCombo {
	
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
		new TipoDeExpedienteDAO().update(nuevo);
	}

	@Override
	public String toCombo() {
		return getTipoDeExpediente();
	}

	@Override
	public String[] toTable() {
		return new String[]{getTipoDeExpediente()};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!(obj instanceof TipoDeExpediente))
			return false;
		TipoDeExpediente other = (TipoDeExpediente) obj;
		if (tipoDeExpediente == null) {
			if (other.tipoDeExpediente != null)
				return false;
		} else if (!tipoDeExpediente.equals(other.tipoDeExpediente))
			return false;
		return true;
	}

	public Iterator<TipoDeExpediente> getFiltro(String stringNombreFiltro) {
		return new TipoDeExpedienteDAO().getFiltro(stringNombreFiltro).iterator();
	}

	
}
