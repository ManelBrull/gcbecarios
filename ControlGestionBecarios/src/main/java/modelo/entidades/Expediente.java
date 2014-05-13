package modelo.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="expediente")
public class Expediente {
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
}
