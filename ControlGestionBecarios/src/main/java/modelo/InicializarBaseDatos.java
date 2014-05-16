package modelo;

import java.util.Date;

import modelo.entidades.Expediente;
import modelo.entidades.TipoDeExpediente;
import modelo.entidades.usuario.Permisos;
import modelo.entidades.usuario.Usuario;
import at.modelo.entidades.excepciones.CampoRequeridoException;


public class InicializarBaseDatos {
	public InicializarBaseDatos(){
		inicializarUsuarios();
		inicializarTiposDeExpediente();
		inicializarExpediente();
	}

	public void inicializarUsuarios(){
		Usuario developer = new Usuario();
		try {
			developer.setNombreUsuario("brullp");
			developer.setPermisos(Permisos.Administrador);
			developer.save();
		} catch (CampoRequeridoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inicializarTiposDeExpediente(){
		TipoDeExpediente acuerdo = new TipoDeExpediente();
		acuerdo.setTipoDeExpediente("Acuerdo con institución/centro educativo");
		
	}
	
	public void inicializarExpediente(){
		TipoDeExpediente acuerdo = new TipoDeExpediente();
		acuerdo.setTipoDeExpediente("Acuerdo con institución/centro educativo");
		acuerdo.save();
		
		Expediente exp = new Expediente();
		
		exp.setTipoDeExpediente(acuerdo);
		exp.setAcuerdoDecreto("012/2014");
		exp.setCentroEducativoInstitucion("Virgen de la cabeza");
		exp.setFechaExpediente(new Date());
		exp.setRefClica("2506/2014");
		exp.save();
		
		Expediente exp2 = new Expediente();
		exp2.setTipoDeExpediente(acuerdo);
		exp2.setAcuerdoDecreto("013/2014");
		exp2.setCentroEducativoInstitucion("Sagrado corazón");
		exp2.setFechaExpediente(new Date());
		exp2.setRefClica("2507/2014");
		exp2.save();
		
	}
}
