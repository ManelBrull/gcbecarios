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
import at.modelo.entidades.excepciones.CampoRequeridoException;

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
		new TutorAcademicoDAO().update(nuevo);
	}

	@Override
	public String[] toTable() {
		return new String[]{getNombre(), getApellidos(), getEmail(), getTelefono()};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TutorAcademico))
			return false;
		TutorAcademico other = (TutorAcademico) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	public Iterator<TutorAcademico> getFiltro(String stringNombreFiltro) {
		return new TutorAcademicoDAO().getFiltro(stringNombreFiltro).iterator();
	};
	
	public void checkRequiredCamps() throws CampoRequeridoException {
		if(getNombre().isEmpty())
			throw new CampoRequeridoException("No ha introducido el nombre");
	}
	

}
