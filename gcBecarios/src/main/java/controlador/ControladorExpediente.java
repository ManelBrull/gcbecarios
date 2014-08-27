package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.entidades.Expediente;
import modelo.entidades.TipoDeExpediente;
import vista.interfaz.MantenimientoDeExpedientes;
import vista.interfaz.MantenimientoDeTiposDeExpediente;
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
		try {
			Expediente exp = new Expediente();
			exp.setAcuerdoDecreto(mExpedientes.getStringDecreto());
			exp.setCentroEducativoInstitucion(mExpedientes.getStringCentro());
			exp.setFechaExpediente(mExpedientes.getFechaExpediente());
			exp.setRefClica(mExpedientes.getStringReferenciaClica());
			exp.setTipoDeExpediente(tiposDeExpediente.get(mExpedientes.getSelectedTipoDeExpediente()));
			return exp;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public Iterator<Expediente> getIteratorFiltro() {
		return new Expediente().getFiltro(mExpedientes.getStringNombreFiltro());
	}

	@Override
	public void rellenarInterfaz() {
		mExpedientes.setStringCentro(entidadSeleccionado.getCentroEducativoInstitucion());
		mExpedientes.setStringDecreto(entidadSeleccionado.getAcuerdoDecreto());
		mExpedientes.setStringReferenciaClica(entidadSeleccionado.getRefClica());
		mExpedientes.setFechaExpediente(entidadSeleccionado.getFechaExpediente());
		
		int comboSelect = 0;
		for(TipoDeExpediente te: tiposDeExpediente){
			if(te.getTipoDeExpediente().equals(entidadSeleccionado.getTipoDeExpediente())){
				mExpedientes.selectItemComboTipoDeExpediente(comboSelect);
				break;
			}
			comboSelect++;
		}
		
	}

	public void anadirTipoExpediente() {
		mExpedientes.vaciarComboTipoDeExpediente();
		inicializarCombo();
		
	}

}
