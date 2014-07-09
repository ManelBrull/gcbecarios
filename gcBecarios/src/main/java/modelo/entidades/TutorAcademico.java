package modelo.entidades;

import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import modelo.dao.BecarioDAO;
import modelo.dao.TutorAcademicoDAO;

import org.hibernate.HibernateException;

import at.modelo.entidades.ICrud;
import at.modelo.entidades.IEsFiltro;

@Entity(name="tutoracademico")
public class TutorAcademico implements ICrud <TutorAcademico>, IEsFiltro{
	@Id @GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String nombre;
	
	private String apellidos;
	private String telefono;
	private String email;
	
	public TutorAcademico(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void delete() throws HibernateException {
		// TODO Auto-generated method stub
		new TutorAcademicoDAO().delete(this);
		
	}

	@Override
	public TutorAcademico get(int id) throws HibernateException {
		// TODO Auto-generated method stub
		return new TutorAcademicoDAO().get(id);
	}

	@Override
	public Iterator<TutorAcademico> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return (new TutorAcademicoDAO().getAll().iterator());
	}

	@Override
	public void save() throws HibernateException {
		// TODO Auto-generated method stub
		new TutorAcademicoDAO().save(this);
	}

	@Override
	public void update(TutorAcademico nuevo) throws HibernateException {
		// TODO Auto-generated method stub
		nuevo.setId(this.getId());
		new TutorAcademicoDAO().update(this);
	}

	@Override
	public String[] toTable() {
		return new String[]{getNombre(), getApellidos(), getEmail(), getTelefono()};
	};
	

}
