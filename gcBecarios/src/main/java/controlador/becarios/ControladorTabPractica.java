package controlador.becarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import modelo.entidades.Becario;
import modelo.entidades.Departamento;
import modelo.entidades.Expediente;
import modelo.entidades.TutorAcademico;
import modelo.entidades.practica.Practica;
import modelo.entidades.practica.TipoBolsaEstudios;
import modelo.entidades.practica.TipoHoras;
import modelo.entidades.practica.TipoPractica;

import org.eclipse.swt.widgets.Shell;
import org.hibernate.HibernateException;

import vista.interfaz.MantenimientoDeDepartamentos;
import vista.interfaz.MantenimientoDeExpedientes;
import vista.interfaz.MantenimientoDeTutoresAcademicos;
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
		
		if(mBecarios.getStringBolsaEstudios().isEmpty())
			p.setBolsaDeEstudios(0);
		else
			p.setBolsaDeEstudios(Integer.parseInt(mBecarios.getStringBolsaEstudios()));
		
		if(mBecarios.getStringNumeroHoras().isEmpty())
			p.setNumHoras(0);
		else
			p.setNumHoras(Integer.parseInt(mBecarios.getStringNumeroHoras()));
		
		p.setDecretoAutorizacion(mBecarios.getStringDecretoAutorizacion());
		p.setDepartamentoDestino(departamentoDestino);
		p.setEstudiosCursados(mBecarios.getStringEstudiosCursados());
		p.setExpediente(expediente);
		p.setFechaCreacion(new Date());
		p.setFechaFinalReal(mBecarios.getDateFechaFinalRealPractica());
		p.setFechaFinalTeorica(mBecarios.getDateFechaFinalPractica());
		p.setFechaInicio(mBecarios.getDateFechaInicioPractica());
		
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
	public void buscar() {
		if(entidadSeleccionado != null){
			borrar();
		}
		mBecarios.vaciarTablaPractica();
		filtro = new ArrayList <Practica>();
		try {
			Iterator <Practica> iter = getIteratorFiltro();
			while(iter.hasNext()){
				Practica u = iter.next();
				filtro.add(u);
				mBecarios.anadirElementoPractica(u.toTable());
			}
		} catch (HibernateException he){
			mantenimiento.openError(
					"Error",
					"Ha ocurrido un error en la base de datos");
		}
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
				controladorBecarios.getEntidadSeleccionado().update();
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
	public void grabar() {
		try {
			Practica usr = creaObjeto();
			if (usr != null){
				if(entidadSeleccionado.equals(usr)){
					mantenimiento.openInformation(
							"Error",
							"No se puede editar porque no se han realizado cambios");
				}
				else{
					Becario becario = controladorBecarios.getEntidadSeleccionado();
					
					Set<Practica> newSet = new HashSet<>();
					for(Practica p: becario.getPracticas()){
						if(!p.equals(entidadSeleccionado)){
							newSet.add(p);
						}
					}
					newSet.add(usr);
					becario.setPracticas(newSet);
					
					becario.update();
					borrar();
					mantenimiento.btnBuscarSelected();
					mantenimiento.openInformation(
							"Información",
							"Se ha editado satisfactoriamente");
				}
			}
		} catch(HibernateException he) {
			mantenimiento.openError(
					"Error",
					"No se ha podido editar");
		} catch (CampoRequeridoException ex){
			mantenimiento.openError(
					"Error",
					"No se ha podido guardar el elemento porque hay campos requeridos"
							+ " que no se han dado un valor v�lido");
		}
	}

	@Override
	public void eliminar() {
		if(entidadSeleccionado == null){
			mantenimiento.openError(
					"Error",
					"No ha seleccionado un elemento para eliminar");
		}
		else{
			int result = mantenimiento.openQuestion(
					"Eliminar",
					"Va a eliminar el elemento seleccionada"
							+". �Desea continuar?",
					new String[]{"Si", "No"}
					);
			
			if(result == 0){
				try {
					Becario becario = controladorBecarios.getEntidadSeleccionado();
					Practica toRemove = new Practica();
					for(Practica p: becario.getPracticas()){
						if(p.equals(entidadSeleccionado)){
							toRemove = p;
						}
					}
					becario.getPracticas().remove(toRemove);
					becario.update();
					entidadSeleccionado = null;
					borrar();
					visibilidadBtn();
					mantenimiento.btnBuscarSelected();
					mantenimiento.openInformation(
							"Informacion",
							"El elemento seleccionado se ha borrado satisfactoriamente "
							);
					mantenimiento.btnBuscarSelected();
				} catch(HibernateException he){
					mantenimiento.openError(
							"Error",
							"No se ha podido eliminar la actuacion");
				} 
			}
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
			mBecarios.setStringExpediente(expediente.getCentroEducativoInstitucion());
		
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

	public void seleccionarExpediente() {
		Expediente e = (Expediente) new MantenimientoDeExpedientes(new Shell(), true).open();
		if(e == null){
			expediente = null;
			mBecarios.setStringExpediente("");
		}
		else {
			expediente = e;
			mBecarios.setStringExpediente(expediente.getCentroEducativoInstitucion());
		}
	}
	
	public void seleccionarDepartamento() {
		Departamento e = (Departamento) new MantenimientoDeDepartamentos(new Shell(), true).open();
		if(e == null){
			departamentoDestino = null;
			mBecarios.setStringDepartamentoDestino("");
		}
		else {
			departamentoDestino = e;
			mBecarios.setStringDepartamentoDestino(departamentoDestino.getNombreDepartamento());
		}
	}
	
	public void seleccionarTutorAcademico() {
		TutorAcademico e = (TutorAcademico) new MantenimientoDeTutoresAcademicos(new Shell(), true).open();
		if(e == null){
			tutorAcademico = null;
			mBecarios.setStringTutorAcademico("");
		}
		else {
			tutorAcademico = e;
			mBecarios.setStringTutorAcademico(tutorAcademico.getApellidos() + " ," + tutorAcademico.getNombre());
		}
	}
}
