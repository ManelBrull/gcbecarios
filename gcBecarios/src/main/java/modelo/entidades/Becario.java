package modelo.entidades;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import modelo.dao.BecarioDAO;
import modelo.entidades.practica.Practica;

import org.hibernate.HibernateException;

import at.modelo.entidades.ICrud;
import at.modelo.entidades.IEsFiltro;

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
		return practicas;
	}

	public void setPracticas(Set<Practica> practicas) {
		this.practicas = practicas;
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

	@Override
	public String[] toTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
