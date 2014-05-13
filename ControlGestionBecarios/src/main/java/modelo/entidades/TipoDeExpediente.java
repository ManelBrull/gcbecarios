package modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="tipoDeExpediente")
public class TipoDeExpediente {
	
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

}
