package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.entidades.Expediente;
import modelo.entidades.TipoDeExpediente;
import vista.interfaz.MantenimientoDeExpedientes;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorExpediente extends ControladorMantenimiento<Expediente>{

	MantenimientoDeExpedientes mExpedientes;
	List <TipoDeExpediente> tiposDeExpediente;
	
	public ControladorExpediente(MantenimientoDeExpedientes mant) {
		super(mant);
		mExpedientes = mant;
	}
	
	@Override
	public void inicializar() {
		visibilidadBtn();
		inicializarCombo();
	}
	/**
	 * Crea los elementos para el combo de eleccion de tipo de expediente
	 */
	public void inicializarCombo() {
		tiposDeExpediente = new ArrayList<>();
		Iterator <TipoDeExpediente> iterator = new TipoDeExpediente().getAll(); 
		while(iterator.hasNext()) {
			TipoDeExpediente temp = iterator.next();
			tiposDeExpediente.add(temp);
			mExpedientes.addItemTipoDeExpediente(temp.toCombo());
		}
		mExpedientes.selectItemComboTipoDeExpediente(0);
	}
	
	@Override
	public void borrarInterfaz() {
		mExpedientes.setStringCentro("");
		mExpedientes.setStringDecreto("");
		mExpedientes.setStringNombreFiltro("");
		mExpedientes.setStringReferenciaClica("");
		mExpedientes.selectItemComboTipoDeExpediente(0);
	}

	@Override
	public Expediente creaObjeto() throws CampoRequeridoException {
		Expediente exp = new Expediente();
		exp.setAcuerdoDecreto(mExpedientes.getStringDecreto());
		exp.setCentroEducativoInstitucion(mExpedientes.getStringCentro());
		exp.setFechaExpediente(mExpedientes.getFechaExpediente());
		exp.setRefClica(mExpedientes.getStringReferenciaClica());
		exp.setTipoDeExpediente(tiposDeExpediente.get(mExpedientes.getSelectedTipoDeExpediente()));
		return exp;
	}

	@Override
	public Iterator<Expediente> getIteratorFiltro() {
		return new Expediente().getAll();
	}

	@Override
	public void rellenarInterfaz() {
		// TODO Auto-generated method stub
		
	}

}
