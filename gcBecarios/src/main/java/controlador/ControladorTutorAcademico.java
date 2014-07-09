package controlador;

import java.util.Iterator;

import modelo.entidades.TutorAcademico;
import vista.interfaz.MantenimientoDeTutoresAcademicos;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorTutorAcademico extends ControladorMantenimiento<TutorAcademico> {

	private MantenimientoDeTutoresAcademicos mTutor;
	
	public ControladorTutorAcademico(MantenimientoDeTutoresAcademicos mant) {
		super(mant);
		this.mTutor = mant;
	}

	@Override
	public void borrarInterfaz() {
		mTutor.setStringApellidos("");
		mTutor.setStringEmail("");
		mTutor.setStringNombre("");
		mTutor.setStringNombreFiltro("");
		mTutor.setStringTelefono("");
	}

	@Override
	public TutorAcademico creaObjeto() throws CampoRequeridoException {
		TutorAcademico ta = new TutorAcademico();
		ta.setNombre(mTutor.getStringNombre());
		ta.setApellidos(mTutor.getStringApellidos());
		ta.setEmail(mTutor.getStringEmail());
		ta.setTelefono(mTutor.getStringTelefono());
		return ta;
	}

	@Override
	public Iterator<TutorAcademico> getIteratorFiltro() {
		return new TutorAcademico().getAll();
	}

	@Override
	public void rellenarInterfaz() {
		mTutor.setStringApellidos(entidadSeleccionado.getApellidos());
		mTutor.setStringEmail(entidadSeleccionado.getEmail());
		mTutor.setStringNombre(entidadSeleccionado.getNombre());
		mTutor.setStringTelefono(entidadSeleccionado.getTelefono());
	}

}
