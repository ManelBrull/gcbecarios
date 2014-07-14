package vista.interfaz;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import at.controlador.ControladorMantenimiento;
import at.vista.IMantenimiento;
import at.vista.interfaz.ATDialog;

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
public class MantenimientoDeExpedientes extends ATDialog implements IMantenimiento {

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
	private CLabel lblTipoExpediente;
	private Combo comboTipoDeExpediente;

	private Button btnAadir;
	private Text textCentro;
	private Text textReferenciaClica;
	private Text textDecreto;
	private TableColumn tblclmnTipo;
	private TableColumn tblclmnCentro;
	private TableColumn tblclmnRefClica;
	private TableColumn tblclmnRefDecreto;
	private TableColumn tblclmnFecha;

	private DateTime dateFechaExpediente;
	
	/**
	 * Crea el dialog
	 * @param parent
	 */
	public MantenimientoDeExpedientes(Shell parent) {
		super(parent,Utils.nombreProyecto + " - Mantenimiento de Expedientes");
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
		shell.setSize(560, 456);
		super.createContents(shell);
		
		Composite compositeMain = new Composite(shell, SWT.NONE);
		compositeMain.setBounds(0, 0, 555, 426);
		
		
		Group grpClase = new Group(compositeMain, SWT.NONE);
		grpClase.setText("Datos expediente");
		grpClase.setFont(getGroupFont());
		grpClase.setForeground(getAzul());
		grpClase.setBounds(5, 221, 545, 200);
		
		btnNuevo = new Button(grpClase, SWT.NONE);
		btnNuevo.setBounds(247, 168, 68, 23);
		btnNuevo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.nuevo();
			}
		});
		btnNuevo.setText("Nuevo");
		
		btnGrabar = new Button(grpClase, SWT.NONE);
		btnGrabar.setBounds(321, 168, 68, 23);
		btnGrabar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.grabar();
			}
		});
		btnGrabar.setEnabled(false);
		btnGrabar.setText("Grabar");
		
		btnEliminar = new Button(grpClase, SWT.NONE);
		btnEliminar.setBounds(395, 168, 68, 23);
		btnEliminar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.eliminar();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setText("Eliminar");
		
		btnSalir = new Button(grpClase, SWT.NONE);
		btnSalir.setBounds(467, 168, 68, 23);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controlador.salir();
			}
		});
		btnSalir.setText("Salir");
		
		lblTipoExpediente = new CLabel(grpClase, SWT.NONE);
		lblTipoExpediente.setBounds(10, 20, 176, 21);
		lblTipoExpediente.setText("Tipo de expediente: ");
		lblTipoExpediente.setForeground(getAzul());
		lblTipoExpediente.setFont(getLabelFont());
		
		
		comboTipoDeExpediente = new Combo(grpClase, SWT.READ_ONLY);
		comboTipoDeExpediente.setBounds(206, 20, 248, 23);
		
		btnAadir = new Button(grpClase, SWT.NONE);
		btnAadir.setBounds(460, 20, 75, 25);
		btnAadir.setText("Añadir");
		
		CLabel lblCentroEducativoinstitucin = new CLabel(grpClase, SWT.NONE);
		lblCentroEducativoinstitucin.setBounds(10, 47, 176, 21);
		lblCentroEducativoinstitucin.setText("Centro educativo/institución: ");
		lblCentroEducativoinstitucin.setForeground(getAzul());
		lblCentroEducativoinstitucin.setFont(getLabelFont());
		
		
		CLabel lblReferenciaClica = new CLabel(grpClase, SWT.NONE);
		lblReferenciaClica.setBounds(10, 74, 176, 21);
		lblReferenciaClica.setText("Referencia clica: ");
		lblReferenciaClica.setForeground(getAzul());
		lblReferenciaClica.setFont(getLabelFont());
		
		
		CLabel lblReferenciaDecreto = new CLabel(grpClase, SWT.NONE);
		lblReferenciaDecreto.setBounds(10, 101, 176, 21);
		lblReferenciaDecreto.setText("Referencia decreto: ");
		lblReferenciaDecreto.setForeground(getAzul());
		lblReferenciaDecreto.setFont(getLabelFont());
		
		
		CLabel lblFecha = new CLabel(grpClase, SWT.NONE);
		lblFecha.setBounds(10, 128, 61, 21);
		lblFecha.setText("Fecha:");
		lblFecha.setForeground(getAzul());
		lblFecha.setFont(getLabelFont());
		
		textCentro = new Text(grpClase, SWT.BORDER);
		textCentro.setBounds(206, 49, 329, 21);
		
		textReferenciaClica = new Text(grpClase, SWT.BORDER);
		textReferenciaClica.setBounds(206, 74, 95, 21);
		
		textDecreto = new Text(grpClase, SWT.BORDER);
		textDecreto.setBounds(206, 101, 95, 21);
		
		dateFechaExpediente = new DateTime(grpClase, SWT.BORDER | SWT.DROP_DOWN);
		dateFechaExpediente.setBounds(206, 128, 95, 24);
		
		
		Group grpFiltro = new Group(compositeMain, SWT.NONE);
		grpFiltro.setLocation(5, 5);
		grpFiltro.setSize(545, 210);
		grpFiltro.setText("Filtro");
		grpFiltro.setFont(getGroupFont());
		grpFiltro.setForeground(getAzul());
		
		
		CLabel lblNombreFiltro = new CLabel(grpFiltro, SWT.NONE);
		lblNombreFiltro.setBounds(10, 20, 105, 21);
		lblNombreFiltro.setFont(getLabelFont());
		lblNombreFiltro.setForeground(getAzul());
		lblNombreFiltro.setText("Filtro por centro: ");
		
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
		
		tblclmnTipo = new TableColumn(table, SWT.NONE);
		tblclmnTipo.setWidth(100);
		tblclmnTipo.setText("Tipo");
		
		tblclmnCentro = new TableColumn(table, SWT.NONE);
		tblclmnCentro.setWidth(158);
		tblclmnCentro.setText("Centro");
		
		tblclmnRefClica = new TableColumn(table, SWT.NONE);
		tblclmnRefClica.setWidth(100);
		tblclmnRefClica.setText("Ref. Clica");
		
		tblclmnRefDecreto = new TableColumn(table, SWT.NONE);
		tblclmnRefDecreto.setWidth(100);
		tblclmnRefDecreto.setText("Ref. Decreto");
		
		tblclmnFecha = new TableColumn(table, SWT.NONE);
		tblclmnFecha.setWidth(100);
		tblclmnFecha.setText("Fecha");
		
		textNombreFiltro = new Text(grpFiltro, SWT.BORDER);
		textNombreFiltro.setBounds(121, 20, 264, 21);
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
	
	public int getSelectedTipoDeExpediente() {
		return comboTipoDeExpediente.getSelectionIndex();
	}

	public void addItemTipoDeExpediente(String elemento) {
		comboTipoDeExpediente.add(elemento);
	}
	
	public void selectItemComboTipoDeExpediente(int i) {
		if(i >= 0 && comboTipoDeExpediente.getItemCount() > i) {
			comboTipoDeExpediente.select(i);
		}
	}
	
	public void vaciarComboTipoDeExpediente(){
		comboTipoDeExpediente.removeAll();
	}

	public String getStringNombreFiltro() {
		return textNombreFiltro.getText();
	}

	public void setStringNombreFiltro(String textNombreFiltro) {
		this.textNombreFiltro.setText(textNombreFiltro);
	}

	public String getStringCentro() {
		return textCentro.getText();
	}

	public void setStringCentro(String textCentro) {
		this.textCentro.setText(textCentro);
	}

	public String getStringReferenciaClica() {
		return textReferenciaClica.getText();
	}

	public void setStringReferenciaClica(String textReferenciaClica) {
		this.textReferenciaClica.setText(textReferenciaClica);
	}

	public String getStringDecreto() {
		return textDecreto.getText();
	}

	public void setStringDecreto(String textDecreto) {
		this.textDecreto.setText(textDecreto);
	}
	
	public Date getFechaExpediente(){
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_MONTH, dateFechaExpediente.getDay());
		instance.set(Calendar.MONTH, dateFechaExpediente.getMonth());
		instance.set(Calendar.YEAR, dateFechaExpediente.getYear());
		return instance.getTime();
	}
}