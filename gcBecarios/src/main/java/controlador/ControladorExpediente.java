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
	boolean isSeleccionable;
	
	public ControladorExpediente(MantenimientoDeExpedientes mant, boolean isSeleccionable) {
		super(mant);
		mExpedientes = mant;
		this.isSeleccionable = isSeleccionable;
	}
	
	@Override
	public void inicializar() {
		visibilidadBtn();
		inicializarCombo();
	}
	@Override
	public void visibilidadBtn() {
		if(!isSeleccionable){
			mExpedientes.setBtnSeleccionarVisible(false);
		}
		if(entidadSeleccionado == null){
			mantenimiento.setBtnGrabarEnabled(false);
			mantenimiento.setBtnEliminarEnabled(false);
			mExpedientes.setBtnSeleccionarEnabled(false);
		}else {
			mantenimiento.setBtnGrabarEnabled(true);
			mantenimiento.setBtnEliminarEnabled(true);
			mExpedientes.setBtnSeleccionarEnabled(true);
		}
		
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
		exp.checkRequiredCamps();
		return exp;
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
			if(te.toCombo().equals(entidadSeleccionado.getTipoDeExpediente().toCombo())){
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
	/** Selecciona la entidad activa **/
	public void seleccionar() {
		mExpedientes.setResult(entidadSeleccionado);
		mExpedientes.cerrarDialog();
	}

}
