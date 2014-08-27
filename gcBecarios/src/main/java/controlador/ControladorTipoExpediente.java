package controlador;

import java.util.Iterator;

import vista.interfaz.MantenimientoDeTiposDeExpediente;
import modelo.entidades.TipoDeExpediente;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;
import at.vista.IMantenimiento;

public class ControladorTipoExpediente extends ControladorMantenimiento<TipoDeExpediente> {

	private MantenimientoDeTiposDeExpediente mTExpediente;
	
	public ControladorTipoExpediente(MantenimientoDeTiposDeExpediente mant) {
		super(mant);
		mTExpediente = mant;
	}

	@Override
	public void borrarInterfaz() {
		mTExpediente.setStringTipoDeExpediente("");
		mTExpediente.setStringNombreFiltro("");
	}

	@Override
	public TipoDeExpediente creaObjeto() throws CampoRequeridoException {
		TipoDeExpediente tExp = new TipoDeExpediente();
		tExp.setTipoDeExpediente(mTExpediente.getStringTipoDeExpediente());
		return tExp;
	}

	@Override
	public Iterator<TipoDeExpediente> getIteratorFiltro() {
		return new TipoDeExpediente().getFiltro(mTExpediente.getStringNombreFiltro());
	}

	@Override
	public void rellenarInterfaz() {
		mTExpediente.setStringTipoDeExpediente(entidadSeleccionado.getTipoDeExpediente());
	}

}
