package controlador;

import java.util.Iterator;

import modelo.entidades.usuario.Permisos;
import modelo.entidades.usuario.Usuario;
import vista.interfaz.MantenimientoDeUsuarios;
import at.controlador.ControladorMantenimiento;
import at.controlador.GestionError;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorUsuarios extends ControladorMantenimiento<Usuario> {

	MantenimientoDeUsuarios mantenimientoUsuarios;
	
	public ControladorUsuarios(MantenimientoDeUsuarios mant) {
		super(mant);
		this.mantenimientoUsuarios = mant;
	}

	@Override
	public Iterator<Usuario> getIteratorFiltro() {
		return new Usuario().getFiltro(
				mantenimientoUsuarios.getTextNombreFiltro().getText());
	}

	@Override
	public void rellenarInterfaz() {
		mantenimientoUsuarios.getTextNombre().setText(entidadSeleccionado.getNombreUsuario());
		mantenimientoUsuarios.getComboPermisos().select(entidadSeleccionado.getPermisos().ordinal());
	}

	@Override
	public void borrarInterfaz() {
		mantenimientoUsuarios.getTextNombre().setText("");
		mantenimientoUsuarios.getTextNombreFiltro().setText("");
		mantenimientoUsuarios.getComboPermisos().select(0);
	}

	@Override
	public Usuario creaObjeto() {
		Usuario usr = new Usuario();
		try {
			usr.inicializaUsuario(
					mantenimientoUsuarios.getTextNombre().getText(), 
					Permisos.values()[mantenimientoUsuarios.getComboPermisos().getSelectionIndex()]);
		} catch (CampoRequeridoException e) {
			new GestionError(mantenimientoUsuarios.getShell(), e);
			return null;
		}
		return usr;
	}
	
	@Override
	public Usuario creaObjetoSilencioso() {
		Usuario usr = new Usuario();
		try {
			usr.inicializaUsuario(
					mantenimientoUsuarios.getTextNombre().getText(), 
					Permisos.values()[mantenimientoUsuarios.getComboPermisos().getSelectionIndex()]);
		} catch (CampoRequeridoException e) {
			return null;
		}
		return usr;
	}

}
