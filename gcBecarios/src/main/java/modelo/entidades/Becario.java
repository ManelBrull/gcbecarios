package modelo.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import modelo.dao.BecarioDAO;
import modelo.entidades.practica.Practica;

import org.hibernate.HibernateException;

import at.modelo.entidades.ICrud;
import at.modelo.entidades.IEsFiltro;
import at.modelo.entidades.excepciones.CampoRequeridoException;

@Entity(name = "becario")
public class Becario implements ICrud <Becario>, IEsFiltro {
	@Id @GeneratedValue
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set <Practica> practicas;

	@Column(nullable = false, unique = true)
	private String documentacion;
	
	
	@Column(nullable = false)
	private String nombre;
	private String apellidos;
	private String direccion;
	private String localidad;
	private String provincia;
	private String telefono;
	private String email;
	private Boolean darleAltaEnSeguridadSocial;
	private String numAfiliacionSeguridadSocial;
	private String cuentaBancaria;
	private Date fechaCreacion;
	
	public Becario(){}
	
	@Override
	public void delete() throws HibernateException {
		new BecarioDAO().delete(this);
	}
	@Override
	public Becario get(int id) throws HibernateException {
		return new BecarioDAO().get(id);
	}
	@Override
	public Iterator<Becario> getAll() throws HibernateException {
		return (new BecarioDAO().getAll().iterator());
	}
	@Override
	public void save() throws HibernateException {
		new BecarioDAO().save(this);
	}
	@Override
	public void update(Becario nuevo) throws HibernateException {
		nuevo.setId(this.getId());
		new BecarioDAO().update(this);
	};
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Practica> getPracticas() {
		if(this.practicas == null) 
			this.practicas = new HashSet<>();
		return practicas;
	}

	public void setPracticas(Set<Practica> practicas) {
		if(practicas == null) {
			this.practicas = new HashSet<>();
		} else {
			this.practicas = practicas;
		}
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

	public String getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(String documentacion) {
		this.documentacion = documentacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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

	public Boolean getDarleAltaEnSeguridadSocial() {
		return darleAltaEnSeguridadSocial;
	}

	public void setDarleAltaEnSeguridadSocial(Boolean darleAltaEnSeguridadSocial) {
		this.darleAltaEnSeguridadSocial = darleAltaEnSeguridadSocial;
	}

	public String getNumAfiliacionSeguridadSocial() {
		return numAfiliacionSeguridadSocial;
	}

	public void setNumAfiliacionSeguridadSocial(String numAfiliacionSeguridadSocial) {
		this.numAfiliacionSeguridadSocial = numAfiliacionSeguridadSocial;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	private String hasPracticaActiva(){
		Date dateAhora = new Date();
		for(Practica p: getPracticas()){
			if(dateAhora.before(p.getFechaFinalReal()) && dateAhora.after(p.getFechaInicio()))
				return "Si";
		}
		return "No";
		
	}

	@Override
	public String[] toTable() {
		return new String[]{
				getNombre(), 
				getApellidos(), 
				getDocumentacion(), 
				String.valueOf(getPracticas().size()), 
				this.hasPracticaActiva()
		};
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result
				+ ((cuentaBancaria == null) ? 0 : cuentaBancaria.hashCode());
		result = prime
				* result
				+ ((darleAltaEnSeguridadSocial == null) ? 0
						: darleAltaEnSeguridadSocial.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result
				+ ((documentacion == null) ? 0 : documentacion.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime
				* result
				+ ((numAfiliacionSeguridadSocial == null) ? 0
						: numAfiliacionSeguridadSocial.hashCode());
		result = prime * result
				+ ((provincia == null) ? 0 : provincia.hashCode());
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
		if (!(obj instanceof Becario))
			return false;
		Becario other = (Becario) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (cuentaBancaria == null) {
			if (other.cuentaBancaria != null)
				return false;
		} else if (!cuentaBancaria.equals(other.cuentaBancaria))
			return false;
		if (darleAltaEnSeguridadSocial == null) {
			if (other.darleAltaEnSeguridadSocial != null)
				return false;
		} else if (!darleAltaEnSeguridadSocial
				.equals(other.darleAltaEnSeguridadSocial))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (documentacion == null) {
			if (other.documentacion != null)
				return false;
		} else if (!documentacion.equals(other.documentacion))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numAfiliacionSeguridadSocial == null) {
			if (other.numAfiliacionSeguridadSocial != null)
				return false;
		} else if (!numAfiliacionSeguridadSocial
				.equals(other.numAfiliacionSeguridadSocial))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	public void checkRequiredCamps() throws CampoRequeridoException {
		if(getDocumentacion().isEmpty())
			throw new CampoRequeridoException("No ha introducido la documentación");
	}

	public Iterator<Becario> getFiltro(String stringNombreFiltro) {
		return new BecarioDAO().getFiltro(stringNombreFiltro).iterator();
	}

}
