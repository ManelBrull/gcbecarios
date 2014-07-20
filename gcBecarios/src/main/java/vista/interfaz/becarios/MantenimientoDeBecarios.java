package vista.interfaz.becarios;

import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import vista.interfaz.utils.Utils;
import at.controlador.ControladorMantenimiento;
import at.vista.IMantenimiento;
import at.vista.interfaz.ATDialog;

import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;

import controlador.becarios.ControladorMantenimientoBecarios;

/**
 * 
 * Clase que sirve de plantilla para el mantenimiento de una clase
 * Se utiliza como una plantilla para crear nuestras propias clases
 * concretas de mantenimiento
 * 
 * 
 * @author brullp
 *
 */
public class MantenimientoDeBecarios extends ATDialog implements IMantenimiento {

	protected Object result;
	protected Shell shell;
	
	/** Controlador de las acciones de la interfaz **/
	private ControladorMantenimientoBecarios controlador;
	
	/** Table que muestra los resultados del filtro **/
	private Table tablePracticas;
	private Table tableBecarios;
	
	private Button btnGrabarPractica;
	private Button btnGrabarBecario;
	private Button btnEliminarPractica;
	private Button btnEliminarBecario;
	private Button btnBuscarBecario;
	private Button btnNuevoPractica;
	private Button btnNuevoBecario;
	private Button btnSalirPractica;
	private Button btnSalirBecario;
	
	private Text textNombreFiltro;
	private Text textNombre;
	private Text textApellidos;
	private Text textCuentaBancaria;
	private Text textDireccion;
	private Text textLocalidad;
	private Text textProvincia;
	private Text textTelefono;
	private Text textEmail;
	private Text textNumafiliacionSS;
	private Text textExpediente;
	private Text textDepartamentoDestino;
	private Text textEstudiosCursados;
	private Text textTutorAcademico;
	private Text textNumeroHoras;
	private Text textBolsaEstudios;
	private Text textTutorAyuntamiento;
	private Text textDecretoAutorizacion;
	private Text textReferenciaClica;
	private Text textObservaciones;
	private Combo comboTipoPractica;
	private Combo comboTipoNumeroHoras;
	private Combo comboTipoBolsaEstudios;
	private Combo comboFiltroPracticas;
	private Button btnSeleccionarExpediente;
	private Button btnSeleccionarDepartamentoDestino;
	private Button btnSeleccionar;
	private DateTime dateTimeFechaInicioPractica;
	private DateTime dateTimeFechaFinalPractica;
	private DateTime dateTimeFechaFinalRealPractica;
	private TabFolder tabFolder;
	private TabItem tbtmBecario;

	/**
	 * Crea el dialog
	 * @param parent
	 */
	public MantenimientoDeBecarios(Shell parent) {
		super(parent,Utils.nombreProyecto + " - Mantenimiento de becarios");
//		controlador = new ControladorConcreto();
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(657, 699);
		super.createContents(shell);
		
		tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(0, 0, 651, 674);
		
		createContentsBecario(tabFolder);
		createContentsPractica(tabFolder);
		
		controlador.inicializar();
	}
	
	private void createContentsBecario(TabFolder tabFolder) {
		tbtmBecario = new TabItem(tabFolder, SWT.NONE);
		tbtmBecario.setText("Becario");
				
		Composite compositeMain = new Composite(tabFolder, SWT.NONE);
		tbtmBecario.setControl(compositeMain);
		
		Group grpClase = new Group(compositeMain, SWT.NONE);
		grpClase.setText("Datos Clase");
		grpClase.setFont(getGroupFont());
		grpClase.setForeground(getAzul());
		grpClase.setBounds(5, 221, 638, 425);
		
		btnNuevoBecario = new Button(grpClase, SWT.NONE);
		btnNuevoBecario.setBounds(341, 392, 68, 23);
		btnNuevoBecario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.nuevo();
			}
		});
		btnNuevoBecario.setText("Nuevo");
		
		btnGrabarBecario = new Button(grpClase, SWT.NONE);
		btnGrabarBecario.setBounds(415, 392, 68, 23);
		btnGrabarBecario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.grabar();
			}
		});
		btnGrabarBecario.setEnabled(false);
		btnGrabarBecario.setText("Grabar");
		
		btnEliminarBecario = new Button(grpClase, SWT.NONE);
		btnEliminarBecario.setBounds(489, 392, 68, 23);
		btnEliminarBecario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.eliminar();
			}
		});
		btnEliminarBecario.setEnabled(false);
		btnEliminarBecario.setText("Eliminar");
		
		btnSalirBecario = new Button(grpClase, SWT.NONE);
		btnSalirBecario.setBounds(561, 392, 68, 23);
		btnSalirBecario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.salir();
			}
		});
		btnSalirBecario.setText("Salir");
		
		CLabel lblNombre = new CLabel(grpClase, SWT.NONE);
		lblNombre.setBounds(10, 20, 103, 21);
		lblNombre.setText("Nombre: ");
		lblNombre.setFont(getLabelFont());
		lblNombre.setForeground(getAzul());
		
		CLabel lblApellidos = new CLabel(grpClase, SWT.NONE);
		lblApellidos.setBounds(247, 20, 68, 21);
		lblApellidos.setText("Apellidos: ");
		lblApellidos.setFont(getLabelFont());
		lblApellidos.setForeground(getAzul());
		
		CLabel lblDocumentacin = new CLabel(grpClase, SWT.NONE);
		lblDocumentacin.setBounds(10, 47, 103, 21);
		lblDocumentacin.setText("Documentación: ");
		lblDocumentacin.setFont(getLabelFont());
		lblDocumentacin.setForeground(getAzul());
		
		CLabel lblDireccion = new CLabel(grpClase, SWT.NONE);
		lblDireccion.setBounds(10, 74, 103, 21);
		lblDireccion.setText("Dirección: ");
		lblDireccion.setFont(getLabelFont());
		lblDireccion.setForeground(getAzul());
		
		CLabel lblLocalidad = new CLabel(grpClase, SWT.NONE);
		lblLocalidad.setBounds(10, 101, 103, 21);
		lblLocalidad.setText("Localidad: ");
		lblLocalidad.setFont(getLabelFont());
		lblLocalidad.setForeground(getAzul());
		
		CLabel lblProvincia = new CLabel(grpClase, SWT.NONE);
		lblProvincia.setBounds(247, 101, 68, 21);
		lblProvincia.setText("Provincia: ");
		lblProvincia.setFont(getLabelFont());
		lblProvincia.setForeground(getAzul());
		
		CLabel lblTelefono = new CLabel(grpClase, SWT.NONE);
		lblTelefono.setBounds(10, 128, 103, 21);
		lblTelefono.setText("Teléfono:");
		lblTelefono.setFont(getLabelFont());
		lblTelefono.setForeground(getAzul());
		
		CLabel lblEmail = new CLabel(grpClase, SWT.NONE);
		lblEmail.setBounds(247, 128, 68, 21);
		lblEmail.setText("Email: ");
		lblEmail.setFont(getLabelFont());
		lblEmail.setForeground(getAzul());
		
		CLabel lblAltaEnSeguridad = new CLabel(grpClase, SWT.NONE);
		lblAltaEnSeguridad.setBounds(10, 155, 151, 21);
		lblAltaEnSeguridad.setText("Alta en seguridad social: ");
		lblAltaEnSeguridad.setFont(getLabelFont());
		lblAltaEnSeguridad.setForeground(getAzul());
		
		CLabel lblNumeroAfiliacinSeguridad = new CLabel(grpClase, SWT.NONE);
		lblNumeroAfiliacinSeguridad.setText("Nº afiliación SS: ");
		lblNumeroAfiliacinSeguridad.setBounds(247, 155, 108, 21);
		lblNumeroAfiliacinSeguridad.setFont(getLabelFont());
		lblNumeroAfiliacinSeguridad.setForeground(getAzul());
		
		CLabel lblCuentaBancaria = new CLabel(grpClase, SWT.NONE);
		lblCuentaBancaria.setBounds(247, 47, 108, 21);
		lblCuentaBancaria.setText("Cuenta bancaria: ");
		lblCuentaBancaria.setFont(getLabelFont());
		lblCuentaBancaria.setForeground(getAzul());
		
		textNombre = new Text(grpClase, SWT.BORDER);
		textNombre.setBounds(141, 20, 100, 21);
		
		textApellidos = new Text(grpClase, SWT.BORDER);
		textApellidos.setBounds(361, 20, 174, 21);
		
		Text textDocumentacion = new Text(grpClase, SWT.BORDER);
		textDocumentacion.setBounds(141, 47, 100, 21);
		
		textCuentaBancaria = new Text(grpClase, SWT.BORDER);
		textCuentaBancaria.setBounds(361, 47, 174, 21);
		
		textDireccion = new Text(grpClase, SWT.BORDER);
		textDireccion.setBounds(141, 74, 394, 21);
		
		textLocalidad = new Text(grpClase, SWT.BORDER);
		textLocalidad.setBounds(141, 101, 100, 21);
		
		textProvincia = new Text(grpClase, SWT.BORDER);
		textProvincia.setBounds(361, 101, 174, 21);
		
		textTelefono = new Text(grpClase, SWT.BORDER);
		textTelefono.setBounds(141, 128, 103, 21);
		
		textEmail = new Text(grpClase, SWT.BORDER);
		textEmail.setBounds(361, 128, 174, 21);
		
		Combo comboAltaSeguridadSocial = new Combo(grpClase, SWT.NONE);
		comboAltaSeguridadSocial.setBounds(167, 153, 74, 23);
		
		textNumafiliacionSS = new Text(grpClase, SWT.BORDER);
		textNumafiliacionSS.setBounds(361, 155, 174, 21);
		
		Group grpFiltro = new Group(compositeMain, SWT.NONE);
		grpFiltro.setLocation(5, 5);
		grpFiltro.setSize(628, 210);
		grpFiltro.setText("Filtro");
		grpFiltro.setFont(getGroupFont());
		grpFiltro.setForeground(getAzul());
		
		
		CLabel lblApellidoFiltro = new CLabel(grpFiltro, SWT.NONE);
		lblApellidoFiltro.setBounds(10, 20, 74, 21);
		lblApellidoFiltro.setFont(getLabelFont());
		lblApellidoFiltro.setForeground(getAzul());
		lblApellidoFiltro.setText("Apellidos: ");
		
		btnBuscarBecario = new Button(grpFiltro, SWT.NONE);
		btnBuscarBecario.setBounds(476, 18, 68, 23);
		btnBuscarBecario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.buscar();
			}
		});
		btnBuscarBecario.setText("Buscar");
		
		Button btnBorrarBecario = new Button(grpFiltro, SWT.NONE);
		btnBorrarBecario.setBounds(550, 18, 68, 23);
		btnBorrarBecario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.borrar();
			}
		});
		btnBorrarBecario.setText("Borrar");
		
		tableBecarios = new Table(grpFiltro, SWT.BORDER | SWT.FULL_SELECTION);
		tableBecarios.setBounds(10, 47, 608, 155);
		tableBecarios.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.elementoFiltroSeleccionado();
			}
		});
		tableBecarios.setHeaderVisible(true);
		tableBecarios.setLinesVisible(true);
		
		TableColumn tblclmnNombre = new TableColumn(tableBecarios, SWT.NONE);
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		TableColumn tblclmnApellidos = new TableColumn(tableBecarios, SWT.NONE);
		tblclmnApellidos.setWidth(119);
		tblclmnApellidos.setText("Apellidos");
		
		TableColumn tblclmnDocumentacin = new TableColumn(tableBecarios, SWT.NONE);
		tblclmnDocumentacin.setWidth(100);
		tblclmnDocumentacin.setText("Documentación");
		
		TableColumn tblclmnNPrcticas = new TableColumn(tableBecarios, SWT.NONE);
		tblclmnNPrcticas.setWidth(100);
		tblclmnNPrcticas.setText("Nº Prácticas");
		
		TableColumn tblclmnPracticaActiva = new TableColumn(tableBecarios, SWT.NONE);
		tblclmnPracticaActiva.setWidth(100);
		tblclmnPracticaActiva.setText("Practica activa");
		
		textNombreFiltro = new Text(grpFiltro, SWT.BORDER);
		textNombreFiltro.setBounds(90, 20, 380, 21);
		
	}
	
	private void createContentsPractica(TabFolder tabFolder){
		TabItem tbtmPrctica = new TabItem(tabFolder, SWT.NONE);
		tbtmPrctica.setText("Práctica");
		
		Composite compositeMain = new Composite(tabFolder, SWT.NONE);
		tbtmPrctica.setControl(compositeMain);
		
		Group grpClase = new Group(compositeMain, SWT.NONE);
		grpClase.setText("Datos Clase");
		grpClase.setFont(getGroupFont());
		grpClase.setForeground(getAzul());
		grpClase.setBounds(5, 221, 638, 425);
		
		CLabel lblExpediente = new CLabel(grpClase, SWT.NONE);
		lblExpediente.setBounds(10, 20, 152, 21);
		lblExpediente.setText("Expediente: ");
		lblExpediente.setFont(getLabelFont());
		lblExpediente.setForeground(getAzul());
		
		CLabel lblTutorAcadmico = new CLabel(grpClase, SWT.NONE);
		lblTutorAcadmico.setBounds(10, 184, 152, 21);
		lblTutorAcadmico.setText("Tutor académico: ");
		lblTutorAcadmico.setFont(getLabelFont());
		lblTutorAcadmico.setForeground(getAzul());
		
		CLabel lblDepartamentoDestino = new CLabel(grpClase, SWT.NONE);
		lblDepartamentoDestino.setBounds(10, 47, 152, 21);
		lblDepartamentoDestino.setText("Departamento destino: ");
		lblDepartamentoDestino.setFont(getLabelFont());
		lblDepartamentoDestino.setForeground(getAzul());
		
		CLabel lblTipoDePrctica = new CLabel(grpClase, SWT.NONE);
		lblTipoDePrctica.setBounds(10, 101, 152, 21);
		lblTipoDePrctica.setText("Tipo de práctica: ");
		lblTipoDePrctica.setFont(getLabelFont());
		lblTipoDePrctica.setForeground(getAzul());
		
		CLabel lblFechaDeInicio = new CLabel(grpClase, SWT.NONE);
		lblFechaDeInicio.setBounds(354, 101, 108, 21);
		lblFechaDeInicio.setText("Fecha de inicio: ");
		lblFechaDeInicio.setFont(getLabelFont());
		lblFechaDeInicio.setForeground(getAzul());
		
		CLabel lblFechaFinal = new CLabel(grpClase, SWT.NONE);
		lblFechaFinal.setBounds(354, 128, 108, 21);
		lblFechaFinal.setText("Fecha final: ");
		lblFechaFinal.setFont(getLabelFont());
		lblFechaFinal.setForeground(getAzul());
		
		CLabel lblFechaFinalReal = new CLabel(grpClase, SWT.NONE);
		lblFechaFinalReal.setBounds(354, 155, 108, 21);
		lblFechaFinalReal.setText("Fecha final real: ");
		lblFechaFinalReal.setFont(getLabelFont());
		lblFechaFinalReal.setForeground(getAzul());
		
		Group grpFiltro = new Group(compositeMain, SWT.NONE);
		grpFiltro.setLocation(5, 5);
		grpFiltro.setSize(638, 210);
		grpFiltro.setText("Filtro");
		grpFiltro.setFont(getGroupFont());
		grpFiltro.setForeground(getAzul());
		
		tablePracticas = new Table(grpFiltro, SWT.BORDER | SWT.FULL_SELECTION);
		tablePracticas.setBounds(10, 47, 618, 155);
		tablePracticas.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.elementoFiltroSeleccionado();
			}
		});
		tablePracticas.setHeaderVisible(true);
		tablePracticas.setLinesVisible(true);
		
		TableColumn tblclmnNombre = new TableColumn(tablePracticas, SWT.NONE);
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		TableColumn tblclmnApellidos = new TableColumn(tablePracticas, SWT.NONE);
		tblclmnApellidos.setWidth(119);
		tblclmnApellidos.setText("Apellidos");
		
		TableColumn tblclmnDocumentacin = new TableColumn(tablePracticas, SWT.NONE);
		tblclmnDocumentacin.setWidth(100);
		tblclmnDocumentacin.setText("Documentación");
		
		TableColumn tblclmnNPrcticas = new TableColumn(tablePracticas, SWT.NONE);
		tblclmnNPrcticas.setWidth(100);
		tblclmnNPrcticas.setText("Nº Prácticas");
		
		TableColumn tblclmnPracticaActiva = new TableColumn(tablePracticas, SWT.NONE);
		tblclmnPracticaActiva.setWidth(100);
		tblclmnPracticaActiva.setText("Practica activa");
		
		comboFiltroPracticas = new Combo(grpFiltro, SWT.NONE);
		comboFiltroPracticas.setBounds(113, 18, 515, 23);
		
		CLabel lblSeleccionar = new CLabel(grpFiltro, SWT.NONE);
		lblSeleccionar.setBounds(10, 20, 97, 21);
		lblSeleccionar.setText("Seleccionar: ");
		lblSeleccionar.setFont(getLabelFont());
		lblSeleccionar.setForeground(getAzul());
		
		btnNuevoPractica = new Button(grpClase, SWT.NONE);
		btnNuevoPractica.setBounds(341, 392, 68, 23);
		btnNuevoPractica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.nuevo();
			}
		});
		btnNuevoPractica.setText("Nuevo");
		
		btnGrabarPractica = new Button(grpClase, SWT.NONE);
		btnGrabarPractica.setBounds(415, 392, 68, 23);
		btnGrabarPractica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.grabar();
			}
		});
		btnGrabarPractica.setEnabled(false);
		btnGrabarPractica.setText("Grabar");
		
		btnEliminarPractica = new Button(grpClase, SWT.NONE);
		btnEliminarPractica.setBounds(489, 392, 68, 23);
		btnEliminarPractica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.eliminar();
			}
		});
		btnEliminarPractica.setEnabled(false);
		btnEliminarPractica.setText("Eliminar");
		
		btnSalirPractica = new Button(grpClase, SWT.NONE);
		btnSalirPractica.setBounds(561, 392, 68, 23);
		btnSalirPractica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.salir();
			}
		});
		btnSalirPractica.setText("Salir");
		
		CLabel lblEstudiosCursados = new CLabel(grpClase, SWT.NONE);
		lblEstudiosCursados.setBounds(10, 74, 152, 21);
		lblEstudiosCursados.setText("Estudios cursados: ");
		lblEstudiosCursados.setFont(getLabelFont());
		lblEstudiosCursados.setForeground(getAzul());
		
		CLabel lblNHoras = new CLabel(grpClase, SWT.NONE);
		lblNHoras.setBounds(10, 128, 152, 21);
		lblNHoras.setText("Nº horas: ");
		lblNHoras.setFont(getLabelFont());
		lblNHoras.setForeground(getAzul());
		
		CLabel lblBolsaDeEstudios = new CLabel(grpClase, SWT.NONE);
		lblBolsaDeEstudios.setBounds(10, 155, 123, 21);
		lblBolsaDeEstudios.setText("Bolsa de estudios: ");
		lblBolsaDeEstudios.setFont(getLabelFont());
		lblBolsaDeEstudios.setForeground(getAzul());
		
		CLabel lblTutorAyuntamiento = new CLabel(grpClase, SWT.NONE);
		lblTutorAyuntamiento.setBounds(10, 211, 152, 21);
		lblTutorAyuntamiento.setText("Tutor ayuntamiento: ");
		lblTutorAyuntamiento.setFont(getLabelFont());
		lblTutorAyuntamiento.setForeground(getAzul());
		
		CLabel lblDecretoAutorizacin = new CLabel(grpClase, SWT.NONE);
		lblDecretoAutorizacin.setBounds(10, 238, 138, 21);
		lblDecretoAutorizacin.setText("Decreto autorización: ");
		lblDecretoAutorizacin.setFont(getLabelFont());
		lblDecretoAutorizacin.setForeground(getAzul());
		
		CLabel lblReferenciaClica = new CLabel(grpClase, SWT.NONE);
		lblReferenciaClica.setBounds(354, 238, 108, 21);
		lblReferenciaClica.setText("Referencia clica: ");
		lblReferenciaClica.setFont(getLabelFont());
		lblReferenciaClica.setForeground(getAzul());
		
		CLabel lblObservaciones = new CLabel(grpClase, SWT.NONE);
		lblObservaciones.setBounds(10, 265, 108, 21);
		lblObservaciones.setText("Observaciones: ");
		lblObservaciones.setFont(getLabelFont());
		lblObservaciones.setForeground(getAzul());
		
		textExpediente = new Text(grpClase, SWT.BORDER);
		textExpediente.setBounds(168, 20, 380, 21);
		
		btnSeleccionarExpediente = new Button(grpClase, SWT.NONE);
		btnSeleccionarExpediente.setBounds(554, 20, 75, 21);
		btnSeleccionarExpediente.setText("Seleccionar");
		
		textDepartamentoDestino = new Text(grpClase, SWT.BORDER);
		textDepartamentoDestino.setBounds(168, 47, 380, 21);
		
		btnSeleccionarDepartamentoDestino = new Button(grpClase, SWT.NONE);
		btnSeleccionarDepartamentoDestino.setBounds(554, 47, 75, 21);
		btnSeleccionarDepartamentoDestino.setText("Seleccionar");
		
		textEstudiosCursados = new Text(grpClase, SWT.BORDER);
		textEstudiosCursados.setBounds(168, 74, 380, 21);
		
		dateTimeFechaInicioPractica = new DateTime(grpClase, SWT.BORDER);
		dateTimeFechaInicioPractica.setBounds(468, 101, 80, 21);
		
		textTutorAcademico = new Text(grpClase, SWT.BORDER);
		textTutorAcademico.setBounds(168, 184, 380, 21);
		
		btnSeleccionar = new Button(grpClase, SWT.NONE);
		btnSeleccionar.setBounds(554, 184, 75, 21);
		btnSeleccionar.setText("Seleccionar");
		
		comboTipoPractica = new Combo(grpClase, SWT.NONE);
		comboTipoPractica.setBounds(168, 101, 180, 23);
		
		dateTimeFechaFinalPractica = new DateTime(grpClase, SWT.BORDER);
		dateTimeFechaFinalPractica.setBounds(468, 128, 80, 21);
		
		dateTimeFechaFinalRealPractica = new DateTime(grpClase, SWT.BORDER);
		dateTimeFechaFinalRealPractica.setBounds(468, 155, 80, 21);
		
		comboTipoNumeroHoras = new Combo(grpClase, SWT.NONE);
		comboTipoNumeroHoras.setBounds(168, 128, 91, 23);
		
		textNumeroHoras = new Text(grpClase, SWT.BORDER);
		textNumeroHoras.setBounds(272, 128, 76, 21);
		
		comboTipoBolsaEstudios = new Combo(grpClase, SWT.NONE);
		comboTipoBolsaEstudios.setBounds(168, 155, 91, 23);
		
		textBolsaEstudios = new Text(grpClase, SWT.BORDER);
		textBolsaEstudios.setText("");
		textBolsaEstudios.setBounds(272, 155, 76, 21);
		
		textTutorAyuntamiento = new Text(grpClase, SWT.BORDER);
		textTutorAyuntamiento.setBounds(168, 211, 180, 21);
		
		textDecretoAutorizacion = new Text(grpClase, SWT.BORDER);
		textDecretoAutorizacion.setBounds(168, 238, 180, 21);
		
		textReferenciaClica = new Text(grpClase, SWT.BORDER);
		textReferenciaClica.setBounds(468, 238, 76, 21);
		
		textObservaciones = new Text(grpClase, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		textObservaciones.setBounds(10, 292, 619, 94);
		
	}
	
	public TabActivaBecarios getTabActiva(){
		return TabActivaBecarios.values()[tabFolder.getSelectionIndex()];
	}
	
	@Override
	protected void myDispose() {

	}
	
	@Override
	public void openError(String cabecera, String mensaje) {
		MessageDialog.openError(
				shell,
				cabecera,
				mensaje);
	}

	@Override
	public void openInformation(String cabecera, String mensaje) {
		MessageDialog.openInformation(
				shell,
				cabecera,
				mensaje);
	}

	@Override
	public int openQuestion(String cabecera, String mensaje, String[] opciones) {
		MessageDialog dialog = new MessageDialog(
				shell, 
				cabecera, 
				null,
				mensaje,
				MessageDialog.QUESTION,
				opciones,
				0 );
		return dialog.open();
	}

	@Override
	public void anadirElemento(String[] fila) {
		switch(getTabActiva()){
		case becarios:
			TableItem item = new TableItem(tableBecarios,SWT.NONE);
			item.setText(fila);
			break;
		case practica:
			TableItem itemPrac = new TableItem(tablePracticas,SWT.NONE);
			itemPrac.setText(fila);
			break;
		}
	}

	@Override
	public int elementoElegidoTabla() {
		switch(getTabActiva()){
		case becarios:
			return tableBecarios.getSelectionIndex();
		case practica:
			return tablePracticas.getSelectionIndex();
		}
		return -1;
	}

	@Override
	public void vaciarTabla() {
		switch(getTabActiva()){
		case becarios:
			tableBecarios.removeAll();
			break;
		case practica:
			tablePracticas.removeAll();
			break;
		}
	}
	
	@Override
	public void setBtnBuscarEnabled(boolean arg0) {
		btnBuscarBecario.setEnabled(arg0);
	}

	@Override
	public void btnBuscarSelected() {
		btnBuscarBecario.notifyListeners(SWT.Selection, new Event());		
	}

	@Override
	public void setBtnEliminarEnabled(boolean arg0) {
		btnEliminarPractica.setEnabled(arg0);
		btnEliminarBecario.setEnabled(arg0);
	}

	@Override
	public void btnEliminarSelected() {
		switch (getTabActiva()) {
		case becarios:
			btnEliminarBecario.notifyListeners(SWT.Selection, new Event());
			break;
		case practica:
			btnEliminarPractica.notifyListeners(SWT.Selection, new Event());
			break;
		}
	}

	@Override
	public void setBtnGrabarEnabled(boolean arg0) {
		btnGrabarPractica.setEnabled(arg0);
		btnGrabarBecario.setEnabled(arg0);
	}

	@Override
	public void btnGrabarSelected() {
		switch (getTabActiva()) {
		case becarios:
			btnGrabarBecario.notifyListeners(SWT.Selection, new Event());
			break;
		case practica:
			btnGrabarPractica.notifyListeners(SWT.Selection, new Event());
			break;
		}
	}

	@Override
	public void setBtnNuevoEnabled(boolean arg0) {
		btnNuevoPractica.setEnabled(arg0);
		btnNuevoBecario.setEnabled(arg0);
	}

	@Override
	public void btnNuevoSelected() {
		switch (getTabActiva()) {
		case becarios:
			btnNuevoBecario.notifyListeners(SWT.Selection, new Event());
			break;
		case practica:
			btnNuevoPractica.notifyListeners(SWT.Selection, new Event());
			break;
		}
	}

	@Override
	public void setBtnSalirEnabled(boolean arg0) {
		btnSalirPractica.setEnabled(arg0);
		btnSalirBecario.setEnabled(arg0);
	}

	@Override
	public void btnSalirSelected() {
		switch (getTabActiva()) {
		case becarios:
			btnSalirBecario.notifyListeners(SWT.Selection, new Event());
			break;
		case practica:
			btnSalirPractica.notifyListeners(SWT.Selection, new Event());
			break;
		}
			
	}

	@Override
	public void cerrarDialog() {
		shell.close();
	}
	
	protected String getStringNombreFiltro() {
		return textNombreFiltro.getText();
	}

	protected void setStringNombreFiltro(String textNombreFiltro) {
		this.textNombreFiltro.setText(textNombreFiltro);
	}

	protected String getStringNombre() {
		return textNombre.getText();
	}

	protected void setStringNombre(String textNombre) {
		this.textNombre.setText(textNombre);
	}

	protected String getStringApellidos() {
		return textApellidos.getText();
	}

	protected void setStringApellidos(String textApellidos) {
		this.textApellidos.setText(textApellidos);
	}

	protected String getStringCuentaBancaria() {
		return textCuentaBancaria.getText();
	}

	protected void setStringCuentaBancaria(String textCuentaBancaria) {
		this.textCuentaBancaria.setText(textCuentaBancaria);
	}

	protected String getStringDireccion() {
		return textDireccion.getText();
	}

	protected void setStringDireccion(String textDireccion) {
		this.textDireccion.setText(textDireccion);
	}

	protected String getStringLocalidad() {
		return textLocalidad.getText();
	}

	protected void setStringLocalidad(String textLocalidad) {
		this.textLocalidad.setText(textLocalidad);
	}

	protected String getStringProvincia() {
		return textProvincia.getText();
	}

	protected void setStringProvincia(String textProvincia) {
		this.textProvincia.setText(textProvincia);
	}

	protected String getStringTelefono() {
		return textTelefono.getText();
	}

	protected void setStringTelefono(String textTelefono) {
		this.textTelefono.setText(textTelefono);
	}

	protected String getStringEmail() {
		return textEmail.getText();
	}

	protected void setStringEmail(String textEmail) {
		this.textEmail.setText(textEmail);
	}

	protected String getStringNumafiliacionSS() {
		return textNumafiliacionSS.getText();
	}

	protected void setStringNumafiliacionSS(String textNumafiliacionSS) {
		this.textNumafiliacionSS.setText(textNumafiliacionSS);
	}

	protected String getStringExpediente() {
		return textExpediente.getText();
	}

	protected void setStringExpediente(String textExpediente) {
		this.textExpediente.setText(textExpediente);
	}

	protected String getStringDepartamentoDestino() {
		return textDepartamentoDestino.getText();
	}

	protected void setStringDepartamentoDestino(String textDepartamentoDestino) {
		this.textDepartamentoDestino.setText(textDepartamentoDestino);
	}

	protected String getStringEstudiosCursados() {
		return textEstudiosCursados.getText();
	}

	protected void setStringEstudiosCursados(String textEstudiosCursados) {
		this.textEstudiosCursados.setText(textEstudiosCursados);
	}

	protected String getStringTutorAcademico() {
		return textTutorAcademico.getText();
	}

	protected void setStringTutorAcademico(String textTutorAcademico) {
		this.textTutorAcademico.setText(textTutorAcademico);
	}

	protected String getStringNumeroHoras() {
		return textNumeroHoras.getText();
	}

	protected void setStringNumeroHoras(String textNumeroHoras) {
		this.textNumeroHoras.setText(textNumeroHoras);
	}

	protected String getStringBolsaEstudios() {
		return textBolsaEstudios.getText();
	}

	protected void setStringBolsaEstudios(String textBolsaEstudios) {
		this.textBolsaEstudios.setText(textBolsaEstudios);
	}

	protected String getStringTutorAyuntamiento() {
		return textTutorAyuntamiento.getText();
	}

	protected void setStringTutorAyuntamiento(String textTutorAyuntamiento) {
		this.textTutorAyuntamiento.setText(textTutorAyuntamiento);
	}

	protected String getStringDecretoAutorizacion() {
		return textDecretoAutorizacion.getText();
	}

	protected void setStringDecretoAutorizacion(String textDecretoAutorizacion) {
		this.textDecretoAutorizacion.setText(textDecretoAutorizacion);
	}

	protected String getStringReferenciaClica() {
		return textReferenciaClica.getText();
	}

	protected void setStringReferenciaClica(String textReferenciaClica) {
		this.textReferenciaClica.setText(textReferenciaClica);
	}

	protected String getStringObservaciones() {
		return textObservaciones.getText();
	}

	protected void setStringObservaciones(String textObservaciones) {
		this.textObservaciones.setText(textObservaciones);
	}

	protected Combo getComboTipoPractica() {
		return comboTipoPractica;
	}

	protected void setComboTipoPractica(Combo comboTipoPractica) {
		this.comboTipoPractica = comboTipoPractica;
	}

	protected Combo getComboTipoNumeroHoras() {
		return comboTipoNumeroHoras;
	}

	protected void setComboTipoNumeroHoras(Combo comboTipoNumeroHoras) {
		this.comboTipoNumeroHoras = comboTipoNumeroHoras;
	}

	protected Combo getComboTipoBolsaEstudios() {
		return comboTipoBolsaEstudios;
	}

	protected void setComboTipoBolsaEstudios(Combo comboTipoBolsaEstudios) {
		this.comboTipoBolsaEstudios = comboTipoBolsaEstudios;
	}

	protected Combo getComboFiltroPracticas() {
		return comboFiltroPracticas;
	}

	protected void setComboFiltroPracticas(Combo comboFiltroPracticas) {
		this.comboFiltroPracticas = comboFiltroPracticas;
	}

	protected Button getBtnSeleccionarExpediente() {
		return btnSeleccionarExpediente;
	}

	protected void setBtnSeleccionarExpediente(Button btnSeleccionarExpediente) {
		this.btnSeleccionarExpediente = btnSeleccionarExpediente;
	}

	protected Button getBtnSeleccionarDepartamentoDestino() {
		return btnSeleccionarDepartamentoDestino;
	}

	protected void setBtnSeleccionarDepartamentoDestino(
			Button btnSeleccionarDepartamentoDestino) {
		this.btnSeleccionarDepartamentoDestino = btnSeleccionarDepartamentoDestino;
	}

	protected Button getBtnSeleccionar() {
		return btnSeleccionar;
	}

	protected void setBtnSeleccionar(Button btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}

	protected Date getDateFechaInicioPractica() {
		return Utils.getDate(dateTimeFechaInicioPractica);
	}

	protected void setDateFechaInicioPractica(
			Date dateFechaInicioPractica) {
		Utils.setDate(dateTimeFechaInicioPractica, dateFechaInicioPractica);
	}

	protected Date getDateFechaFinalPractica() {
		return Utils.getDate(dateTimeFechaFinalPractica);
	}

	protected void setDateFechaFinalPractica(Date dateFechaFinalPractica) {
		Utils.setDate(dateTimeFechaFinalPractica,dateFechaFinalPractica);
	}

	protected Date getDateFechaFinalRealPractica() {
		return Utils.getDate(dateTimeFechaFinalRealPractica);
	}

	protected void setDateFechaFinalRealPractica(
			Date dateFechaFinalRealPractica) {
		Utils.setDate(dateTimeFechaFinalRealPractica,dateFechaFinalRealPractica);
	}
}