package modelo.entidades;

import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import modelo.dao.BecarioDAO;
import modelo.dao.DepartamentoDAO;

import org.hibernate.HibernateException;

import at.modelo.entidades.ICrud;
import at.modelo.entidades.IEsFiltro;

@Entity(name = "departamento")
public class Departamento implements ICrud <Departamento>, IEsFiltro{
	
	@Id @GeneratedValue
	private int id;
	@Column(nullable = false)
	private String nombreDepartamento;
	
	public Departamento(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	@Override
	public void delete() throws HibernateException {
		new DepartamentoDAO().delete(this);
	}

	@Override
	public Departamento get(int arg0) throws HibernateException {
		return new DepartamentoDAO().get(id);
	}

	@Override
	public Iterator<Departamento> getAll() throws HibernateException {
		return (new DepartamentoDAO().getAll().iterator());
	}

	@Override
	public void save() throws HibernateException {
		new DepartamentoDAO().save(this);
	}

	@Override
	public void update(Departamento nuevo) throws HibernateException {
		nuevo.setId(this.getId());
		new DepartamentoDAO().update(this);
	}

	@Override
	public String[] toTable() {
		return new String[]{getNombreDepartamento()};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((nombreDepartamento == null) ? 0 : nombreDepartamento
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Departamento))
			return false;
		Departamento other = (Departamento) obj;
		if (nombreDepartamento == null) {
			if (other.nombreDepartamento != null)
				return false;
		} else if (!nombreDepartamento.equals(other.nombreDepartamento))
			return false;
		return true;
	}

	public Iterator<Departamento> getFiltro(String stringNombreFiltro) {
		return new DepartamentoDAO().getFiltro(stringNombreFiltro).iterator();
	}

	
	
}
