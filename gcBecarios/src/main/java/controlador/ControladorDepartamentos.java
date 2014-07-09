package controlador;

import java.util.Iterator;

import modelo.entidades.Departamento;
import vista.interfaz.MantenimientoDeDepartamentos;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorDepartamentos extends ControladorMantenimiento<Departamento> {
	
	MantenimientoDeDepartamentos mantenimientoDepartamentos;
	
	public ControladorDepartamentos(MantenimientoDeDepartamentos mant) {
		super(mant);
		this.mantenimientoDepartamentos = mant;
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
		return dep;
	}

	@Override
	public Iterator<Departamento> getIteratorFiltro() {
		// TODO Auto-generated method stub
		return new Departamento().getAll();
	}

	@Override
	public void rellenarInterfaz() {
		mantenimientoDepartamentos.setStringNombreDepartamento(entidadSeleccionado.getNombreDepartamento());		
	}
}