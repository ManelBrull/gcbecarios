package controlador.becarios;

import at.controlador.IControladorMantenimiento;
import vista.interfaz.becarios.MantenimientoDeBecarios;
import vista.interfaz.becarios.TabActivaBecarios;

public class ControladorMantenimientoBecarios implements IControladorMantenimiento {

	ControladorTabBecario cBecario;
	ControladorTabPractica cPractica;
	MantenimientoDeBecarios mBecarios;

	public ControladorMantenimientoBecarios(MantenimientoDeBecarios mb){
		this.mBecarios = mb;
		cPractica = new ControladorTabPractica(mb);
		cBecario = new ControladorTabBecario(mb);
	}

	@Override
	public void inicializar() {
		cBecario.inicializar();
		cPractica.inicializar();
	}

	@Override
	public void salir() {
		mBecarios.cerrarDialog();
	}

	@Override
	public void visibilidadBtn() {
		switch(mBecarios.getTabActiva()){
		case becarios:
		case practica:
		default:
		}

	}

	@Override
	public void borrar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
		case practica:
		default:
		}
	}

	@Override
	public void buscar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
		case practica:
		default:
		}

	}

	@Override
	public boolean comprobarCambiosObjetoActivo() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			return false;
		case practica:
			return false;
		default:
			return false;
		}
		
	}

	@Override
	public void elementoFiltroSeleccionado() {
		switch(mBecarios.getTabActiva()){
		case becarios:
		case practica:
		default:
		}

	}

	@Override
	public void eliminar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
		case practica:
		default:
		}

	}

	@Override
	public void grabar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
		case practica:
		default:
		}

	}

	@Override
	public void nuevo() {
		switch(mBecarios.getTabActiva()){
		case becarios:
		case practica:
		default:
		}

	}


}
