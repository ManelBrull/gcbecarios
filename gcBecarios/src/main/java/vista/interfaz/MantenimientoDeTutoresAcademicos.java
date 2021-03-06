package vista.interfaz;

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

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;

import controlador.ControladorTutorAcademico;

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
public class MantenimientoDeTutoresAcademicos extends ATDialog implements IMantenimiento {

	protected Object result;
	protected Shell shell;
	
	/** Controlador de las acciones de la interfaz **/
	private ControladorTutorAcademico controlador;
	
	/** Table que muestra los resultados del filtro **/
	private Table table;
	
	private Button btnGrabar;
	private Button btnEliminar;
	private Button btnBuscar;
	private Button btnNuevo;
	private Button btnSalir;
	
	private Text textNombreFiltro;
	private CLabel lblNombre;
	private CLabel lblApellidos;
	private CLabel lblCorreo;
	private CLabel lblEmail;
	private Text textNombre;
	private Text textTelefono;
	private Text textApellidos;
	private Text textEmail;
	private TableColumn tblclmnNombre;
	private TableColumn tblclmnApellidos;
	private TableColumn tblclmnTeefono;
	private TableColumn tblclmnEmail;
	private Button btnSeleccionar;

	/**
	 * Crea el dialog
	 * @param parent
	 */
	public MantenimientoDeTutoresAcademicos(Shell parent, boolean isSeleccionable) {
		super(parent,Utils.nombreProyecto + " - Mantenimiento de tutores académicos");
		controlador = new ControladorTutorAcademico(this, isSeleccionable);
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
		shell.setSize(491, 373);
		super.createContents(shell);
		
		Composite compositeMain = new Composite(shell, SWT.NONE);
		compositeMain.setBounds(0, 0, 483, 341);
		
		
		Group grpClase = new Group(compositeMain, SWT.NONE);
		grpClase.setText("Datos tutor académico");
		grpClase.setFont(getGroupFont());
		grpClase.setForeground(getAzul());
		grpClase.setBounds(5, 221, 473, 115);
		
		btnNuevo = new Button(grpClase, SWT.NONE);
		btnNuevo.setBounds(176, 84, 68, 23);
		btnNuevo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.nuevo();
			}
		});
		btnNuevo.setText("Nuevo");
		
		btnGrabar = new Button(grpClase, SWT.NONE);
		btnGrabar.setBounds(250, 84, 68, 23);
		btnGrabar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.grabar();
			}
		});
		btnGrabar.setEnabled(false);
		btnGrabar.setText("Grabar");
		
		btnEliminar = new Button(grpClase, SWT.NONE);
		btnEliminar.setBounds(324, 84, 68, 23);
		btnEliminar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.eliminar();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setText("Eliminar");
		
		btnSalir = new Button(grpClase, SWT.NONE);
		btnSalir.setBounds(396, 84, 68, 23);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.salir();
			}
		});
		btnSalir.setText("Salir");
		
		lblNombre = new CLabel(grpClase, SWT.NONE);
		lblNombre.setBounds(10, 20, 73, 21);
		lblNombre.setText("Nombre(*): ");
		lblNombre.setForeground(getAzul());
		lblNombre.setFont(getLabelFont());
		
		lblApellidos = new CLabel(grpClase, SWT.NONE);
		lblApellidos.setBounds(190, 20, 68, 21);
		lblApellidos.setText("Apellidos: ");
		lblApellidos.setForeground(getAzul());
		lblApellidos.setFont(getLabelFont());
		
		lblCorreo = new CLabel(grpClase, SWT.NONE);
		lblCorreo.setBounds(10, 47, 73, 21);
		lblCorreo.setText("Telefono: ");
		lblCorreo.setForeground(getAzul());
		lblCorreo.setFont(getLabelFont());
		
		lblEmail = new CLabel(grpClase, SWT.NONE);
		lblEmail.setBounds(190, 47, 68, 21);
		lblEmail.setText("Email: ");
		lblEmail.setForeground(getAzul());
		lblEmail.setFont(getLabelFont());
		
		textNombre = new Text(grpClase, SWT.BORDER);
		textNombre.setBounds(89, 20, 95, 21);
		
		textTelefono = new Text(grpClase, SWT.BORDER);
		textTelefono.setBounds(89, 47, 95, 21);
		
		textApellidos = new Text(grpClase, SWT.BORDER);
		textApellidos.setBounds(264, 20, 200, 21);
		
		textEmail = new Text(grpClase, SWT.BORDER);
		textEmail.setBounds(264, 47, 200, 21);
		
		btnSeleccionar = new Button(grpClase, SWT.NONE);
		btnSeleccionar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.seleccionar();
			}
		});
		btnSeleccionar.setBounds(95, 84, 75, 23);
		btnSeleccionar.setText("Seleccionar");
		
		Group grpFiltro = new Group(compositeMain, SWT.NONE);
		grpFiltro.setLocation(5, 5);
		grpFiltro.setSize(473, 210);
		grpFiltro.setText("Filtro");
		grpFiltro.setFont(getGroupFont());
		grpFiltro.setForeground(getAzul());
		
		
		CLabel lblNombreFiltro = new CLabel(grpFiltro, SWT.NONE);
		lblNombreFiltro.setBounds(10, 20, 97, 21);
		lblNombreFiltro.setFont(getLabelFont());
		lblNombreFiltro.setForeground(getAzul());
		lblNombreFiltro.setText("Filtro apellidos: ");
		
		btnBuscar = new Button(grpFiltro, SWT.NONE);
		btnBuscar.setBounds(317, 20, 68, 23);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.buscar();
			}
		});
		btnBuscar.setText("Buscar");
		
		Button btnBorrar = new Button(grpFiltro, SWT.NONE);
		btnBorrar.setBounds(391, 20, 68, 23);
		btnBorrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.borrar();
			}
		});
		btnBorrar.setText("Borrar");
		
		table = new Table(grpFiltro, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 47, 449, 155);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.elementoFiltroSeleccionado();
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnNombre = new TableColumn(table, SWT.NONE);
		tblclmnNombre.setWidth(100);
		tblclmnNombre.setText("Nombre");
		
		tblclmnApellidos = new TableColumn(table, SWT.NONE);
		tblclmnApellidos.setWidth(143);
		tblclmnApellidos.setText("Apellidos");
		
		tblclmnTeefono = new TableColumn(table, SWT.NONE);
		tblclmnTeefono.setWidth(100);
		tblclmnTeefono.setText("Teléfono");
		
		tblclmnEmail = new TableColumn(table, SWT.NONE);
		tblclmnEmail.setWidth(100);
		tblclmnEmail.setText("Email");
		
		textNombreFiltro = new Text(grpFiltro, SWT.BORDER);
		textNombreFiltro.setBounds(113, 20, 198, 21);
		controlador.inicializar();
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

	public void setBtnSeleccionarEnabled(boolean arg0){
		btnSeleccionar.setEnabled(arg0);
	}
	
	public void btnSeleccionarSelected(){
		btnSeleccionar.notifyListeners(SWT.Selection, new Event());
	}
	
	public void setBtnSeleccionarVisible(boolean arg0){
		btnSeleccionar.setVisible(arg0);
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

	public String getStringNombreFiltro() {
		return textNombreFiltro.getText();
	}

	public void setStringNombreFiltro(String textNombreFiltro) {
		this.textNombreFiltro.setText(textNombreFiltro);
	}

	public String getStringNombre() {
		return textNombre.getText();
	}

	public void setStringNombre(String textNombre) {
		this.textNombre.setText(textNombre);
	}

	public String getStringTelefono() {
		return textTelefono.getText();
	}

	public void setStringTelefono(String textTelefono) {
		this.textTelefono.setText(textTelefono);
	}

	public String getStringApellidos() {
		return textApellidos.getText();
	}

	public void setStringApellidos(String textApellidos) {
		this.textApellidos.setText(textApellidos);
	}

	public String getStringEmail() {
		return textEmail.getText();
	}

	public void setStringEmail(String textEmail) {
		this.textEmail.setText(textEmail);
	}
	
	public void setResult(Object entidadSeleccionado) {
		this.result = entidadSeleccionado;
	}

}