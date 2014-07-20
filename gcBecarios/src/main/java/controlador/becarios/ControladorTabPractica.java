package controlador.becarios;

import java.util.Iterator;

import modelo.entidades.practica.Practica;
import vista.interfaz.becarios.MantenimientoDeBecarios;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorTabPractica extends ControladorMantenimiento<Practica> {

	MantenimientoDeBecarios mBecarios;
	
	public ControladorTabPractica(MantenimientoDeBecarios mant) {
		super(mant);
		mBecarios = mant;
	}
	
	@Override
	public void inicializar() {
		visibilidadBtn();
	}
	
	@Override
	public void visibilidadBtn() {
		if(entidadSeleccionado == null){
			mBecarios.setBtnGrabarEnabled(false);
			mBecarios.setBtnEliminarEnabled(false);
		}else {
			mBecarios.setBtnGrabarEnabled(true);
			mBecarios.setBtnEliminarEnabled(true);
		}
		
	}
	
	@Override
	public void borrarInterfaz() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Practica creaObjeto() throws CampoRequeridoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Practica> getIteratorFiltro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rellenarInterfaz() {
		// TODO Auto-generated method stub
		
	}

}
