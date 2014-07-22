package controlador.becarios;

import java.util.Date;
import java.util.Iterator;

import modelo.entidades.practica.Practica;
import modelo.entidades.practica.TipoBolsaEstudios;
import modelo.entidades.practica.TipoHoras;
import modelo.entidades.practica.TipoPractica;
import vista.interfaz.becarios.ComboFiltroPracticas;
import vista.interfaz.becarios.MantenimientoDeBecarios;
import at.controlador.ControladorMantenimiento;
import at.modelo.entidades.excepciones.CampoRequeridoException;

public class ControladorTabPractica extends ControladorMantenimiento<Practica> {

	MantenimientoDeBecarios mBecarios;
	ControladorTabBecario controladorBecarios;
	
	public ControladorTabPractica(MantenimientoDeBecarios mant, ControladorTabBecario ctb) {
		super(mant);
		mBecarios = mant;
		controladorBecarios = ctb;
	}
	
	@Override
	public void inicializar() {
		visibilidadBtn();
		inicializarComboFiltroPracticas();
		inicializarTipoPractica();
		inicializarTipoNumeroHoras();
		inicializarTipoBolsaEstudios();
	}
	
	private void inicializarComboFiltroPracticas(){
		for(ComboFiltroPracticas cfp : ComboFiltroPracticas.values()){
			mBecarios.addItemComboFiltroPracticas(cfp.getDisplayString());
		}
	}
	
	private void inicializarTipoPractica(){
		for(TipoPractica cfp : TipoPractica.values()){
			mBecarios.addItemComboTipoPractica(cfp.getDisplayString());
		}
	}
	
	private void inicializarTipoNumeroHoras(){
		for(TipoHoras cfp : TipoHoras.values()){
			mBecarios.addItemComboTipoNumeroHoras(cfp.getDisplayString());
		}
	}
	
	private void inicializarTipoBolsaEstudios(){
		for(TipoBolsaEstudios cfp : TipoBolsaEstudios.values()){
			mBecarios.addItemComboTipoBolsaEstudios(cfp.getDisplayString());
		}
	}
	
	
	@Override
	public void visibilidadBtn() {
		if(controladorBecarios.getEntidadSeleccionado() == null){
			mBecarios.setBtnGrabarPracticaEnabled(false);
			mBecarios.setBtnEliminarPracticaEnabled(false);
			mBecarios.setBtnNuevoPracticaEnabled(false);

		} else {
			mBecarios.setBtnNuevoPracticaEnabled(true);
			if(entidadSeleccionado == null){
				mBecarios.setBtnGrabarPracticaEnabled(false);
				mBecarios.setBtnEliminarPracticaEnabled(false);
			}else {
				mBecarios.setBtnGrabarPracticaEnabled(true);
				mBecarios.setBtnEliminarPracticaEnabled(true);
			}
		}
	}
	
	@Override
	public void borrarInterfaz() {
		mBecarios.setStringExpediente("");
		mBecarios.setStringDepartamentoDestino("");
		mBecarios.setStringEstudiosCursados("");
		mBecarios.setDateFechaInicioPractica(new Date());
		mBecarios.setStringTutorAcademico("");
		mBecarios.setDateFechaFinalPractica(new Date());
		mBecarios.setDateFechaFinalRealPractica(new Date());
		mBecarios.setStringNumeroHoras("");
		mBecarios.setStringBolsaEstudios("");
		mBecarios.setStringTutorAyuntamiento("");
		mBecarios.setStringDecretoAutorizacion("");
		mBecarios.setStringReferenciaClica("");
		mBecarios.setStringObservaciones("");
	}

	@Override
	public Practica creaObjeto() throws CampoRequeridoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Practica> getIteratorFiltro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rellenarInterfaz() {
		// TODO Auto-generated method stub
		
	}

}
