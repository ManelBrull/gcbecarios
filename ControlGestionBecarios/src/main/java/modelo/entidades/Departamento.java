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

@Entity(name = "departamento")
public class Departamento implements ICrud <Departamento>{
	
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
	};
	
}
