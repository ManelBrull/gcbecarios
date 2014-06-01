package vista.interfaz;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import at.vista.interfaz.ATDialog;
import controlador.ControladorDialogEjemplo;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

public class DialogEjemplo extends ATDialog {

	protected Object result;
	protected Shell shell;
	private Text textNombre;
	private Text textApellidos;
	private Text textDNI;
	private Button btnCrear;
	private Button btnSalir;
	
	@SuppressWarnings("unused")
	
	private ControladorDialogEjemplo controlador;
	public DialogEjemplo(Shell parent, int style) {
		super(parent, Utils.nombreProyecto);
		controlador = new ControladorDialogEjemplo(this);
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
		shell.setSize(270, 177);
		super.createContents(shell);
		shell.setLayout(null);
		
		CLabel lblLabelDeMuestra = new CLabel(shell, SWT.NONE);
		lblLabelDeMuestra.setBounds(10, 10, 67, 21);
		lblLabelDeMuestra.setForeground(getAzul());
		lblLabelDeMuestra.setFont(getLabelFont());
		lblLabelDeMuestra.setText("Nombre:");
		
		CLabel lblApellidos = new CLabel(shell, SWT.NONE);
		lblApellidos.setBounds(10, 37, 67, 21);
		lblApellidos.setText("Apellidos: ");
		lblApellidos.setForeground(getAzul());
		lblApellidos.setFont(getLabelFont());
		
		CLabel lblDni = new CLabel(shell, SWT.NONE);
		lblDni.setText("DNI: ");
		lblDni.setBounds(10, 64, 67, 21);
		lblDni.setForeground(getAzul());
		lblDni.setFont(getLabelFont());
		
		
		textNombre = new Text(shell, SWT.BORDER);
		textNombre.setBounds(83, 10, 138, 21);
		
		textApellidos = new Text(shell, SWT.BORDER);
		textApellidos.setBounds(83, 37, 138, 21);
		
		textDNI = new Text(shell, SWT.BORDER);
		textDNI.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				event.doit = filtrarNumeros(event);
			}
			private boolean filtrarNumeros(VerifyEvent event) {
				switch (event.keyCode) 
				{  
				case SWT.BS:   case SWT.DEL:  
				case SWT.HOME: case SWT.END:  
				case SWT.ARROW_LEFT: case SWT.ARROW_RIGHT:   
					return true;  
				}  
				if (!Character.isDigit(event.character))   
					return false;  
				else
					return true;
			}
		});
		textDNI.setBounds(83, 64, 138, 21);
		
		btnCrear = new Button(shell, SWT.NONE);
		btnCrear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				controlador.crearPersona();
			}
		});
		btnCrear.setText("Crear");
		
		btnCrear.setBounds(93, 114, 75, 25);
		
		
		btnSalir = new Button(shell, SWT.NONE);
		btnSalir.setText("Salir");
		btnSalir.setBounds(179, 114, 75, 25);

	}

	@Override
	protected void myDispose() {
		// TODO Auto-generated method stub
		
	}
}
