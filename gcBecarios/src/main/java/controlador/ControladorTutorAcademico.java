package controlador;

import java.util.Iterator;

import modelo.entidades.TutorAcademico;
import vista.interfaz.MantenimientoDeTutoresAcademicos;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorTutorAcademico extends ControladorMantenimiento<TutorAcademico> {

	private MantenimientoDeTutoresAcademicos mTutor;
	boolean isSeleccionable;
	
	public ControladorTutorAcademico(MantenimientoDeTutoresAcademicos mant, boolean isSeleccionable) {
		super(mant);
		this.mTutor = mant;
		this.isSeleccionable = isSeleccionable;
	}
	
	@Override
	public void visibilidadBtn() {
		if(!isSeleccionable){
			mTutor.setBtnSeleccionarVisible(false);
		}
		if(entidadSeleccionado == null){
			mantenimiento.setBtnGrabarEnabled(false);
			mantenimiento.setBtnEliminarEnabled(false);
			mTutor.setBtnSeleccionarEnabled(false);
		}else {
			mantenimiento.setBtnGrabarEnabled(true);
			mantenimiento.setBtnEliminarEnabled(true);
			mTutor.setBtnSeleccionarEnabled(true);
		}
		
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
		ta.checkRequiredCamps();
		return ta;
	}

	@Override
	public Iterator<TutorAcademico> getIteratorFiltro() {
		return new TutorAcademico().getFiltro(mTutor.getStringNombreFiltro());
	}

	@Override
	public void rellenarInterfaz() {
		mTutor.setStringApellidos(entidadSeleccionado.getApellidos());
		mTutor.setStringEmail(entidadSeleccionado.getEmail());
		mTutor.setStringNombre(entidadSeleccionado.getNombre());
		mTutor.setStringTelefono(entidadSeleccionado.getTelefono());
	}
	
	/** Selecciona la entidad activa **/
	public void seleccionar() {
		mTutor.setResult(entidadSeleccionado);
		mTutor.cerrarDialog();
	}


}
