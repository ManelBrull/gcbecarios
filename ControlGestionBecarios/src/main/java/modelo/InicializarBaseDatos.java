package modelo;

import modelo.entidades.TipoDeExpediente;
import modelo.entidades.usuario.Permisos;
import modelo.entidades.usuario.Usuario;
import at.modelo.entidades.excepciones.CampoRequeridoException;


public class InicializarBaseDatos {
	public InicializarBaseDatos(){
		inicializarUsuarios();
		inicializarTiposDeExpediente();
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
}
