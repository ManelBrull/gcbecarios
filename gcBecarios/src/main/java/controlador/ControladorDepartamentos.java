package controlador;

import java.util.Iterator;

import modelo.entidades.Departamento;
import vista.interfaz.MantenimientoDeDepartamentos;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorDepartamentos extends ControladorMantenimiento<Departamento> {
	
	MantenimientoDeDepartamentos mantenimientoDepartamentos;
	boolean isSeleccionable;
	
	public ControladorDepartamentos(MantenimientoDeDepartamentos mant, boolean isSeleccionable) {
		super(mant);
		this.mantenimientoDepartamentos = mant;
		this.isSeleccionable = isSeleccionable;
	}
	
	@Override
	public void visibilidadBtn() {
		if(!isSeleccionable){
			mantenimientoDepartamentos.setBtnSeleccionarVisible(false);
		}
		if(entidadSeleccionado == null){
			mantenimiento.setBtnGrabarEnabled(false);
			mantenimiento.setBtnEliminarEnabled(false);
			mantenimientoDepartamentos.setBtnSeleccionarEnabled(false);
		}else {
			mantenimiento.setBtnGrabarEnabled(true);
			mantenimiento.setBtnEliminarEnabled(true);
			mantenimientoDepartamentos.setBtnSeleccionarEnabled(true);
		}
		
	}
	
	@Override
	public void borrarInterfaz() {
		mantenimientoDepartamentos.setStringNombreDepartamento("");
		mantenimientoDepartamentos.setStringNombreFiltro("");
	}

	@Override
	public Departamento creaObjeto() throws CampoRequeridoException {
		// TODO Auto-generated method stub
		Departamento dep = new Departamento();
		dep.setNombreDepartamento(mantenimientoDepartamentos.getStringNombreDepartamento());
		dep.checkRequiredCamps();
		return dep;
	}

	@Override
	public Iterator<Departamento> getIteratorFiltro() {
		// TODO Auto-generated method stub
		return new Departamento().getFiltro(mantenimientoDepartamentos.getStringNombreFiltro());
	}

	@Override
	public void rellenarInterfaz() {
		mantenimientoDepartamentos.setStringNombreDepartamento(entidadSeleccionado.getNombreDepartamento());		
	}
	
	/** Selecciona la entidad activa **/
	public void seleccionar() {
		mantenimientoDepartamentos.setResult(entidadSeleccionado);
		mantenimientoDepartamentos.cerrarDialog();
	}

}