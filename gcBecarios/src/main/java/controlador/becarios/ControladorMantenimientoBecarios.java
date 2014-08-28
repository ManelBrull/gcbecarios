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
		cBecario = new ControladorTabBecario(mb);
		cPractica = new ControladorTabPractica(mb, cBecario);
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
			cBecario.visibilidadBtn();
			break;
		case practica:
			cPractica.visibilidadBtn();
			break;
		default:
		}

	}

	@Override
	public void borrar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			cBecario.borrar();
			break;
		case practica:
			cPractica.borrar();
			break;
		default:
		}
	}

	@Override
	public void buscar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			cBecario.buscar();
			break;
		case practica:
			cPractica.buscar();
			break;
		default:
		}

	}

	@Override
	public boolean comprobarCambiosObjetoActivo() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			return cBecario.comprobarCambiosObjetoActivo();
		case practica:
			return cPractica.comprobarCambiosObjetoActivo();
		default:
			return false;
		}
		
	}

	@Override
	public void elementoFiltroSeleccionado() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			cBecario.elementoFiltroSeleccionado();
			break;
		case practica:
			cBecario.elementoFiltroSeleccionado();
			break;
		default:
		}

	}

	@Override
	public void eliminar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			cBecario.eliminar();
			break;
		case practica:
			cPractica.eliminar();
			break;
		default:
		}

	}

	@Override
	public void grabar() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			cBecario.grabar();
			break;
		case practica:
			cPractica.grabar();
			break;
		default:
		}

	}

	@Override
	public void nuevo() {
		switch(mBecarios.getTabActiva()){
		case becarios:
			cBecario.nuevo();
			cPractica.refreshEntidadSeleccionada();
			break;
		case practica:
			cPractica.nuevo();
			break;
		default:
		}

	}


}
