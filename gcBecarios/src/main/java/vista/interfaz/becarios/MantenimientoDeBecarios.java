package vista.interfaz.becarios;

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

import vista.interfaz.Utils;
import at.controlador.ControladorMantenimiento;
import at.vista.IMantenimiento;
import at.vista.interfaz.ATDialog;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Combo;

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
	private ControladorMantenimiento controlador;
	
	/** Table que muestra los resultados del filtro **/
	private Table table;
	
	private Button btnGrabar;
	private Button btnEliminar;
	private Button btnBuscar;
	private Button btnNuevo;
	private Button btnSalir;
	
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
		shell.setSize(708, 722);
		super.createContents(shell);
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBounds(0, 0, 563, 495);
		
		createContentsBecario(tabFolder);
		createContentsPractica(tabFolder);
		
		controlador.inicializar();
	}
	
	private void createContentsBecario(TabFolder tabFolder) {
		TabItem tbtmBecario = new TabItem(tabFolder, SWT.NONE);
		tbtmBecario.setText("Becario");
		
		Composite compositeMain = new Composite(tabFolder, SWT.NONE);
		tbtmBecario.setControl(compositeMain);
		
		Group grpClase = new Group(compositeMain, SWT.NONE);
		grpClase.setText("Datos Clase");
		grpClase.setFont(getGroupFont());
		grpClase.setForeground(getAzul());
		grpClase.setBounds(5, 221, 545, 240);
		
		btnNuevo = new Button(grpClase, SWT.NONE);
		btnNuevo.setBounds(247, 204, 68, 23);
		btnNuevo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.nuevo();
			}
		});
		btnNuevo.setText("Nuevo");
		
		btnGrabar = new Button(grpClase, SWT.NONE);
		btnGrabar.setBounds(321, 204, 68, 23);
		btnGrabar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.grabar();
			}
		});
		btnGrabar.setEnabled(false);
		btnGrabar.setText("Grabar");
		
		btnEliminar = new Button(grpClase, SWT.NONE);
		btnEliminar.setBounds(395, 204, 68, 23);
		btnEliminar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.eliminar();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setText("Eliminar");
		
		btnSalir = new Button(grpClase, SWT.NONE);
		btnSalir.setBounds(467, 204, 68, 23);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.salir();
			}
		});
		btnSalir.setText("Salir");
		
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
		grpFiltro.setSize(545, 210);
		grpFiltro.setText("Filtro");
		grpFiltro.setFont(getGroupFont());
		grpFiltro.setForeground(getAzul());
		
		
		CLabel lblApellidoFiltro = new CLabel(grpFiltro, SWT.NONE);
		lblApellidoFiltro.setBounds(10, 20, 74, 21);
		lblApellidoFiltro.setFont(getLabelFont());
		lblApellidoFiltro.setForeground(getAzul());
		lblApellidoFiltro.setText("Apellidos: ");
		
		btnBuscar = new Button(grpFiltro, SWT.NONE);
		btnBuscar.setBounds(391, 18, 68, 23);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.buscar();
			}
		});
		btnBuscar.setText("Buscar");
		
		Button btnBorrar = new Button(grpFiltro, SWT.NONE);
		btnBorrar.setBounds(465, 18, 68, 23);
		btnBorrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.borrar();
			}
		});
		btnBorrar.setText("Borrar");
		
		table = new Table(grpFiltro, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 47, 523, 155);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.elementoFiltroSeleccionado();
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNombre = new TableColumn(table, SWT.NONE);
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		TableColumn tblclmnApellidos = new TableColumn(table, SWT.NONE);
		tblclmnApellidos.setWidth(119);
		tblclmnApellidos.setText("Apellidos");
		
		TableColumn tblclmnDocumentacin = new TableColumn(table, SWT.NONE);
		tblclmnDocumentacin.setWidth(100);
		tblclmnDocumentacin.setText("Documentación");
		
		TableColumn tblclmnNPrcticas = new TableColumn(table, SWT.NONE);
		tblclmnNPrcticas.setWidth(100);
		tblclmnNPrcticas.setText("Nº Prácticas");
		
		TableColumn tblclmnPracticaActiva = new TableColumn(table, SWT.NONE);
		tblclmnPracticaActiva.setWidth(100);
		tblclmnPracticaActiva.setText("Practica activa");
		
		textNombreFiltro = new Text(grpFiltro, SWT.BORDER);
		textNombreFiltro.setBounds(90, 20, 295, 21);
		
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
		grpClase.setBounds(5, 221, 545, 237);
		
		CLabel lblExpediente = new CLabel(grpClase, SWT.NONE);
		lblExpediente.setBounds(10, 20, 61, 21);
		lblExpediente.setText("Expediente: ");
		lblExpediente.setFont(getLabelFont());
		lblExpediente.setForeground(getAzul());
		
		CLabel lblTutorAcadmico = new CLabel(grpClase, SWT.NONE);
		lblTutorAcadmico.setBounds(10, 47, 61, 21);
		lblTutorAcadmico.setText("Tutor académico: ");
		lblTutorAcadmico.setFont(getLabelFont());
		lblTutorAcadmico.setForeground(getAzul());
		
		CLabel lblDepartamentoDestino = new CLabel(grpClase, SWT.NONE);
		lblDepartamentoDestino.setBounds(10, 74, 61, 21);
		lblDepartamentoDestino.setText("Departamento destino: ");
		lblDepartamentoDestino.setFont(getLabelFont());
		lblDepartamentoDestino.setForeground(getAzul());
		
		CLabel lblTipoDePrctica = new CLabel(grpClase, SWT.NONE);
		lblTipoDePrctica.setBounds(10, 101, 61, 21);
		lblTipoDePrctica.setText("Tipo de práctica: ");
		lblTipoDePrctica.setFont(getLabelFont());
		lblTipoDePrctica.setForeground(getAzul());
		
		CLabel lblFechaDeInicio = new CLabel(grpClase, SWT.NONE);
		lblFechaDeInicio.setBounds(10, 128, 61, 21);
		lblFechaDeInicio.setText("Fecha de inicio: ");
		lblFechaDeInicio.setFont(getLabelFont());
		lblFechaDeInicio.setForeground(getAzul());
		
		CLabel lblFechaFinal = new CLabel(grpClase, SWT.NONE);
		lblFechaFinal.setBounds(10, 155, 61, 21);
		lblFechaFinal.setText("Fecha final: ");
		lblFechaFinal.setFont(getLabelFont());
		lblFechaFinal.setForeground(getAzul());
		
		CLabel lblFechaFinalReal = new CLabel(grpClase, SWT.NONE);
		lblFechaFinalReal.setBounds(10, 182, 61, 21);
		lblFechaFinalReal.setText("Fecha final real: ");
		lblFechaFinalReal.setFont(getLabelFont());
		lblFechaFinalReal.setForeground(getAzul());
		
		Group grpFiltro = new Group(compositeMain, SWT.NONE);
		grpFiltro.setLocation(5, 5);
		grpFiltro.setSize(545, 210);
		grpFiltro.setText("Filtro");
		grpFiltro.setFont(getGroupFont());
		grpFiltro.setForeground(getAzul());
		
		table = new Table(grpFiltro, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 47, 523, 155);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.elementoFiltroSeleccionado();
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNombre = new TableColumn(table, SWT.NONE);
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		TableColumn tblclmnApellidos = new TableColumn(table, SWT.NONE);
		tblclmnApellidos.setWidth(119);
		tblclmnApellidos.setText("Apellidos");
		
		TableColumn tblclmnDocumentacin = new TableColumn(table, SWT.NONE);
		tblclmnDocumentacin.setWidth(100);
		tblclmnDocumentacin.setText("Documentación");
		
		TableColumn tblclmnNPrcticas = new TableColumn(table, SWT.NONE);
		tblclmnNPrcticas.setWidth(100);
		tblclmnNPrcticas.setText("Nº Prácticas");
		
		TableColumn tblclmnPracticaActiva = new TableColumn(table, SWT.NONE);
		tblclmnPracticaActiva.setWidth(100);
		tblclmnPracticaActiva.setText("Practica activa");
		
		Combo combo = new Combo(grpFiltro, SWT.NONE);
		combo.setBounds(88, 18, 445, 23);
		
		CLabel lblSeleccionar = new CLabel(grpFiltro, SWT.NONE);
		lblSeleccionar.setBounds(10, 20, 72, 21);
		lblSeleccionar.setText("Seleccionar: ");
		lblSeleccionar.setFont(getLabelFont());
		lblSeleccionar.setForeground(getAzul());
		
		btnNuevo = new Button(grpClase, SWT.NONE);
		btnNuevo.setBounds(247, 204, 68, 23);
		btnNuevo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.nuevo();
			}
		});
		btnNuevo.setText("Nuevo");
		
		btnGrabar = new Button(grpClase, SWT.NONE);
		btnGrabar.setBounds(321, 204, 68, 23);
		btnGrabar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.grabar();
			}
		});
		btnGrabar.setEnabled(false);
		btnGrabar.setText("Grabar");
		
		btnEliminar = new Button(grpClase, SWT.NONE);
		btnEliminar.setBounds(395, 204, 68, 23);
		btnEliminar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.eliminar();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setText("Eliminar");
		
		btnSalir = new Button(grpClase, SWT.NONE);
		btnSalir.setBounds(467, 204, 68, 23);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.salir();
			}
		});
		btnSalir.setText("Salir");
		
		CLabel lblEstudiosCursados = new CLabel(grpClase, SWT.NONE);
		lblEstudiosCursados.setBounds(177, 20, 61, 21);
		lblEstudiosCursados.setText("Estudios cursados: ");
		lblEstudiosCursados.setFont(getLabelFont());
		lblEstudiosCursados.setForeground(getAzul());
		
		CLabel lblNHoras = new CLabel(grpClase, SWT.NONE);
		lblNHoras.setBounds(177, 47, 61, 21);
		lblNHoras.setText("Nº horas: ");
		lblNHoras.setFont(getLabelFont());
		lblNHoras.setForeground(getAzul());
		
		CLabel lblBolsaDeEstudios = new CLabel(grpClase, SWT.NONE);
		lblBolsaDeEstudios.setBounds(177, 74, 61, 21);
		lblBolsaDeEstudios.setText("Bolsa de estudios: ");
		lblBolsaDeEstudios.setFont(getLabelFont());
		lblBolsaDeEstudios.setForeground(getAzul());
		
		CLabel lblTutorAyuntamiento = new CLabel(grpClase, SWT.NONE);
		lblTutorAyuntamiento.setBounds(177, 101, 61, 21);
		lblTutorAyuntamiento.setText("Tutor ayuntamiento: ");
		lblTutorAyuntamiento.setFont(getLabelFont());
		lblTutorAyuntamiento.setForeground(getAzul());
		
		CLabel lblDecretoAutorizacin = new CLabel(grpClase, SWT.NONE);
		lblDecretoAutorizacin.setBounds(177, 128, 61, 21);
		lblDecretoAutorizacin.setText("Decreto autorización: ");
		lblDecretoAutorizacin.setFont(getLabelFont());
		lblDecretoAutorizacin.setForeground(getAzul());
		
		CLabel lblReferenciaClica = new CLabel(grpClase, SWT.NONE);
		lblReferenciaClica.setBounds(297, 20, 61, 21);
		lblReferenciaClica.setText("Referencia clica: ");
		lblReferenciaClica.setFont(getLabelFont());
		lblReferenciaClica.setForeground(getAzul());
		
		CLabel lblObservaciones = new CLabel(grpClase, SWT.NONE);
		lblObservaciones.setBounds(297, 47, 61, 21);
		lblObservaciones.setText("Observaciones: ");
		lblObservaciones.setFont(getLabelFont());
		lblObservaciones.setForeground(getAzul());
		
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
		TableItem item = new TableItem(table,SWT.NONE);
		item.setText(fila);
	}

	@Override
	public int elementoElegidoTabla() {
		return table.getSelectionIndex();
	}

	@Override
	public void vaciarTabla() {
		table.removeAll();
	}

	@Override
	public void setBtnBuscarEnabled(boolean arg0) {
		btnBuscar.setEnabled(arg0);
	}

	@Override
	public void btnBuscarSelected() {
		btnBuscar.notifyListeners(SWT.Selection, new Event());		
	}

	@Override
	public void setBtnEliminarEnabled(boolean arg0) {
		btnEliminar.setEnabled(arg0);		
	}

	@Override
	public void btnEliminarSelected() {
		btnEliminar.notifyListeners(SWT.Selection, new Event());
	}

	@Override
	public void setBtnGrabarEnabled(boolean arg0) {
		btnGrabar.setEnabled(arg0);
	}

	@Override
	public void btnGrabarSelected() {
		btnGrabar.notifyListeners(SWT.Selection, new Event());
	}

	@Override
	public void setBtnNuevoEnabled(boolean arg0) {
		btnNuevo.setEnabled(arg0);
	}

	@Override
	public void btnNuevoSelected() {
		btnNuevo.notifyListeners(SWT.Selection, new Event());		
	}

	@Override
	public void setBtnSalirEnabled(boolean arg0) {
		btnSalir.setEnabled(arg0);
	}

	@Override
	public void btnSalirSelected() {
		btnSalir.notifyListeners(SWT.Selection, new Event());	
	}


	@Override
	public void cerrarDialog() {
		shell.close();
	}
}