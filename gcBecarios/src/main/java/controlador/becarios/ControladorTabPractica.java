package controlador.becarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;

import modelo.entidades.Departamento;
import modelo.entidades.Expediente;
import modelo.entidades.TutorAcademico;
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
	/**
	 * TODO: Proviene de un seleccionable de departamento
	 */
	private Departamento departamentoDestino;
	/**
	 * TODO: proviene de un seleccionable de Expediente
	 */
	private Expediente expediente;
	/**
	 * TODO: proviene de un seleccionable de Tutores
	 */
	private TutorAcademico tutorAcademico;
	
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
		mBecarios.selectItemComboTipoPracticas(0);
	}
	
	private void inicializarTipoNumeroHoras(){
		for(TipoHoras cfp : TipoHoras.values()){
			mBecarios.addItemComboTipoNumeroHoras(cfp.getDisplayString());
		}
		mBecarios.selectItemComboTipoNumeroHoras(0);
	}
	
	private void inicializarTipoBolsaEstudios(){
		for(TipoBolsaEstudios cfp : TipoBolsaEstudios.values()){
			mBecarios.addItemComboTipoBolsaEstudios(cfp.getDisplayString());
		}
		mBecarios.selectItemComboTipoBolsaEstudios(0);
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
		
		departamentoDestino = null;
		expediente = null;
		tutorAcademico = null;
		
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
		Practica p = new Practica();
		p.setBolsaDeEstudios(Integer.parseInt(mBecarios.getStringBolsaEstudios()));
		p.setDecretoAutorizacion(mBecarios.getStringDecretoAutorizacion());
		p.setDepartamentoDestino(departamentoDestino);
		p.setEstudiosCursados(mBecarios.getStringEstudiosCursados());
		p.setExpediente(expediente);
		p.setFechaCreacion(new Date());
		p.setFechaFinalReal(mBecarios.getDateFechaFinalRealPractica());
		p.setFechaFinalTeorica(mBecarios.getDateFechaFinalPractica());
		p.setFechaInicio(mBecarios.getDateFechaInicioPractica());
		p.setNumHoras(Integer.parseInt(mBecarios.getStringNumeroHoras()));
		p.setObservaciones(mBecarios.getStringObservaciones());
		p.setProfesionalesFormacion(TipoPractica.values()[mBecarios.getSelectedComboTipoPracticas()]);
		p.setRefClica(mBecarios.getStringReferenciaClica());
		p.setTipoBolsaEstudios(TipoBolsaEstudios.values()[mBecarios.getSelectedComboTipoBolsaEstudios()]);
		p.setTipoNumeroDeHoras(TipoHoras.values()[mBecarios.getSelectedComboTipoNumeroHoras()]);
		p.setTutorAcademico(tutorAcademico);
		p.setTutorAyuntamiento(mBecarios.getStringTutorAyuntamiento());
		return p;
	}

	@Override
	public Iterator<Practica> getIteratorFiltro() {
		switch(ComboFiltroPracticas.values()[mBecarios.getSelectedComboFiltroPracticas()]){
		case practicasBecarios:
			if(controladorBecarios.getEntidadSeleccionado() != null && 
					controladorBecarios.getEntidadSeleccionado().getPracticas() != null)
				return controladorBecarios.getEntidadSeleccionado().getPracticas().iterator();
			else
				return (new ArrayList<Practica>()).iterator();
		case todasPracticas:
			return new Practica().getAll();
		}
		return null;
	}
	
	@Override
	public void nuevo() {
		try {
			Practica practica = creaObjeto();
			if (practica != null){
				controladorBecarios.getEntidadSeleccionado().getPracticas().add(practica);
				controladorBecarios.getEntidadSeleccionado().save();
				mantenimiento.openInformation(
						"Informacion", 
						"Se ha creado el elemento satisfactoriamente"
						);
				entidadSeleccionado = practica;
		}
		} catch (HibernateException he){
			mantenimiento.openError(
					"Error",
					"No se ha podido guardar el elemento en la base de datos"
					);
		} catch (CampoRequeridoException ex){
			mantenimiento.openError(
					"Error",
					"No se ha podido guardar el elemento porque hay campos requeridos"
					+ " que no se han dado un valor v�lido");
		}
	}

	@Override
	public void rellenarInterfaz() {
		departamentoDestino = entidadSeleccionado.getDepartamentoDestino();
		expediente = entidadSeleccionado.getExpediente();
		tutorAcademico = entidadSeleccionado.getTutorAcademico();
		
		if(expediente == null)
			mBecarios.setStringExpediente("");
		else
			mBecarios.setStringExpediente(expediente.toString());
		
		if(departamentoDestino == null)
			mBecarios.setStringDepartamentoDestino("");
		else
			mBecarios.setStringDepartamentoDestino(departamentoDestino.getNombreDepartamento());
		
		if(tutorAcademico == null)
			mBecarios.setStringTutorAcademico("");
		else
			mBecarios.setStringTutorAcademico(tutorAcademico.toString());
		
		
		mBecarios.setStringEstudiosCursados(entidadSeleccionado.getEstudiosCursados());
		mBecarios.setDateFechaInicioPractica(entidadSeleccionado.getFechaInicio());
		
		mBecarios.setDateFechaFinalPractica(entidadSeleccionado.getFechaFinalTeorica());
		mBecarios.setDateFechaFinalRealPractica(entidadSeleccionado.getFechaFinalReal());
		mBecarios.setStringNumeroHoras(String.valueOf(entidadSeleccionado.getNumHoras()));
		mBecarios.setStringBolsaEstudios(String.valueOf(entidadSeleccionado.getBolsaDeEstudios()));
		mBecarios.setStringTutorAyuntamiento(entidadSeleccionado.getTutorAyuntamiento());
		mBecarios.setStringDecretoAutorizacion(entidadSeleccionado.getDecretoAutorizacion());
		mBecarios.setStringReferenciaClica(entidadSeleccionado.getRefClica());
		mBecarios.setStringObservaciones(entidadSeleccionado.getObservaciones());
	}
	
	public void refreshEntidadSeleccionada(){
		if(controladorBecarios.getEntidadSeleccionado() != null){
			mBecarios.setStringNomreBecarioEnPractica(controladorBecarios.getEntidadSeleccionado().getNombre());
			mBecarios.setStringApellidosBecarioEnPractica(controladorBecarios.getEntidadSeleccionado().getApellidos());
			mBecarios.selectItemComboFiltroPracticas(ComboFiltroPracticas.practicasBecarios);
			this.buscar();
		} else {
			mBecarios.setStringNomreBecarioEnPractica("");
			mBecarios.setStringApellidosBecarioEnPractica("");
		}
	}
	
}
