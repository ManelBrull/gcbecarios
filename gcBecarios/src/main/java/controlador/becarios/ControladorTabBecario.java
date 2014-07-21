package controlador.becarios;

import java.util.Date;
import java.util.Iterator;

import modelo.entidades.Becario;
import vista.interfaz.becarios.MantenimientoDeBecarios;
import vista.interfaz.utils.ComboBooleano;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorTabBecario extends ControladorMantenimiento<Becario>{

	MantenimientoDeBecarios mBecarios;
	
	public ControladorTabBecario(MantenimientoDeBecarios mant) {
		super(mant);
		mBecarios = mant;
	}
	
	@Override
	public void inicializar() {
		visibilidadBtn();
		inicializarComboAltaSeguridadSocial();
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
	
	public void inicializarComboAltaSeguridadSocial(){
		for(ComboBooleano cb : ComboBooleano.values()){
			mBecarios.addItemComboAltaSeguridadSocial(cb.getDisplayString());
		}
	}
	
	@Override
	public void borrarInterfaz() {
		mBecarios.setStringNombre("");
		mBecarios.setStringDocumentacion("");
		mBecarios.setStringApellidos("");
		mBecarios.setStringCuentaBancaria("");
		mBecarios.setStringDireccion("");
		mBecarios.setStringLocalidad("");
		mBecarios.setStringProvincia("");
		mBecarios.setStringTelefono("");
		mBecarios.setStringEmail("");
		mBecarios.selectItemComboAltaSeguridadSocial(0);
		mBecarios.setStringNumafiliacionSS("");
		mBecarios.setStringNumafiliacionSS("");
	}

	@Override
	public Becario creaObjeto() throws CampoRequeridoException {
		Becario becario = new Becario();
		becario.setNombre(mBecarios.getStringNombre());
		becario.setApellidos(mBecarios.getStringApellidos());
		becario.setCuentaBancaria(mBecarios.getStringCuentaBancaria());
		becario.setDarleAltaEnSeguridadSocial(
				ComboBooleano.values()[mBecarios.getSelectedComboAltaSeguridadSocial()].isValue());
		becario.setDireccion(mBecarios.getStringDireccion());
		becario.setDocumentacion(mBecarios.getStringDocumentacion());
		becario.setEmail(mBecarios.getStringEmail());
		becario.setFechaCreacion(new Date());
		becario.setLocalidad(mBecarios.getStringLocalidad());
		becario.setNumAfiliacionSeguridadSocial(mBecarios.getStringNumafiliacionSS());
		becario.setProvincia(mBecarios.getStringProvincia());
		becario.setTelefono(mBecarios.getStringTelefono());
		return becario;
	}

	@Override
	public Iterator<Becario> getIteratorFiltro() {
		return new Becario().getAll();
	}

	@Override
	public void rellenarInterfaz() {
		mBecarios.setStringNombre(entidadSeleccionado.getNombre());
		mBecarios.setStringDocumentacion(entidadSeleccionado.getDocumentacion());
		mBecarios.setStringApellidos(entidadSeleccionado.getApellidos());
		mBecarios.setStringCuentaBancaria(entidadSeleccionado.getCuentaBancaria());
		mBecarios.setStringDireccion(entidadSeleccionado.getDireccion());
		mBecarios.setStringLocalidad(entidadSeleccionado.getLocalidad());
		mBecarios.setStringProvincia(entidadSeleccionado.getProvincia());
		mBecarios.setStringTelefono(entidadSeleccionado.getTelefono());
		mBecarios.setStringEmail(entidadSeleccionado.getEmail());
		mBecarios.selectItemComboAltaSeguridadSocial(
				ComboBooleano.no.getValue(
				entidadSeleccionado.getDarleAltaEnSeguridadSocial()
				).ordinal());
		mBecarios.setStringNumafiliacionSS(entidadSeleccionado.getNumAfiliacionSeguridadSocial());
	}

}
