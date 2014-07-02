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

import vista.interfaz.Utils;
import at.controlador.ControladorMantenimiento;
import at.vista.IMantenimiento;
import at.vista.interfaz.ATDialog;
import org.eclipse.swt.widgets.TableColumn;

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
public class MantenimientoDeTiposDeExpediente extends ATDialog implements IMantenimiento {

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
	private TableColumn tblclmnNombreDelDepartamento;
	private Text textNombreTipoDeExpediente;

	/**
	 * Crea el dialog
	 * @param parent
	 */
	public MantenimientoDeTiposDeExpediente(Shell parent) {
		super(parent,Utils.nombreProyecto + " - Mantenimiento de tipos de expediente");
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
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				controlador.salir();
			}
		});
		shell.setSize(433, 349);
		super.createContents(shell);
		
		Composite compositeMain = new Composite(shell, SWT.NONE);
		compositeMain.setBounds(0, 0, 424, 320);
		
		
		Group grpClase = new Group(compositeMain, SWT.NONE);
		grpClase.setText("Datos tipo de expediente");
		grpClase.setFont(getGroupFont());
		grpClase.setForeground(getAzul());
		grpClase.setBounds(5, 221, 414, 93);
		
		btnNuevo = new Button(grpClase, SWT.NONE);
		btnNuevo.setBounds(116, 57, 68, 23);
		btnNuevo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.nuevo();
			}
		});
		btnNuevo.setText("Nuevo");
		
		btnGrabar = new Button(grpClase, SWT.NONE);
		btnGrabar.setBounds(190, 57, 68, 23);
		btnGrabar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.grabar();
			}
		});
		btnGrabar.setEnabled(false);
		btnGrabar.setText("Grabar");
		
		btnEliminar = new Button(grpClase, SWT.NONE);
		btnEliminar.setBounds(264, 57, 68, 23);
		btnEliminar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.eliminar();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setText("Eliminar");
		
		btnSalir = new Button(grpClase, SWT.NONE);
		btnSalir.setBounds(336, 57, 68, 23);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.salir();
			}
		});
		btnSalir.setText("Salir");
		
		CLabel lblNombre = new CLabel(grpClase, SWT.NONE);
		lblNombre.setBounds(10, 20, 61, 21);
		lblNombre.setForeground(getAzul());
		lblNombre.setFont(getLabelFont());
		lblNombre.setText("Nombre: ");
		
		textNombreTipoDeExpediente = new Text(grpClase, SWT.BORDER);
		textNombreTipoDeExpediente.setBounds(77, 20, 327, 21);
		
		Group grpFiltro = new Group(compositeMain, SWT.NONE);
		grpFiltro.setLocation(5, 5);
		grpFiltro.setSize(414, 210);
		grpFiltro.setText("Filtro");
		grpFiltro.setFont(getGroupFont());
		grpFiltro.setForeground(getAzul());
		
		
		CLabel lblNombreFiltro = new CLabel(grpFiltro, SWT.NONE);
		lblNombreFiltro.setBounds(10, 20, 115, 21);
		lblNombreFiltro.setFont(getLabelFont());
		lblNombreFiltro.setForeground(getAzul());
		lblNombreFiltro.setText("Filtro por nombre: ");
		
		btnBuscar = new Button(grpFiltro, SWT.NONE);
		btnBuscar.setBounds(264, 18, 68, 23);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.buscar();
			}
		});
		btnBuscar.setText("Buscar");
		
		Button btnBorrar = new Button(grpFiltro, SWT.NONE);
		btnBorrar.setBounds(338, 18, 68, 23);
		btnBorrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.borrar();
			}
		});
		btnBorrar.setText("Borrar");
		
		table = new Table(grpFiltro, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 47, 396, 155);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.elementoFiltroSeleccionado();
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnNombreDelDepartamento = new TableColumn(table, SWT.NONE);
		tblclmnNombreDelDepartamento.setWidth(392);
		tblclmnNombreDelDepartamento.setText("Nombre del Tipo");
		
		textNombreFiltro = new Text(grpFiltro, SWT.BORDER);
		textNombreFiltro.setBounds(131, 20, 127, 21);
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
	
	protected String getStringNombreFiltro() {
		return textNombreFiltro.getText();
	}

	protected void setStringNombreFiltro(String nombreFiltro) {
		this.textNombreFiltro.setText(nombreFiltro);
	}

	protected String getStringTipoDeExpediente() {
		return textNombreTipoDeExpediente.getText();
	}

	protected void setStringTipoDeExpediente(String textNombreTipoDeExpediente) {
		this.textNombreTipoDeExpediente.setText(textNombreTipoDeExpediente);
	}

}