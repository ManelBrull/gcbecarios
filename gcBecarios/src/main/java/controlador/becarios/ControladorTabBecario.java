package controlador.becarios;

import java.util.Iterator;

import vista.interfaz.becarios.MantenimientoDeBecarios;
import modelo.entidades.Becario;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;
import at.vista.IMantenimiento;

public class ControladorTabBecario extends ControladorMantenimiento<Becario>{

	MantenimientoDeBecarios mBecarios;
	
	public ControladorTabBecario(MantenimientoDeBecarios mant) {
		super(mant);
		mBecarios = mant;
	}

	@Override
	public void borrarInterfaz() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Becario creaObjeto() throws CampoRequeridoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Becario> getIteratorFiltro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rellenarInterfaz() {
		// TODO Auto-generated method stub
		
	}

}
