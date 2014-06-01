package controlador;
import vista.interfaz.Inicio;
import vista.interfaz.MantenimientoDeTutoresAcademicos;
import vista.interfaz.MantenimientoDeUsuarios;
import at.vista.informes.ReportManager;

public class ControladorInicio {
	
	Inicio inicio;
	ReportManager reportManager;
	
	public ControladorInicio(Inicio mInicio){
		this.inicio = mInicio;
		this.reportManager = new ReportManager();
	}

	public void cargarInforme() {
		
	}
	
	public void close() {
		inicio.dispose();
		inicio.getShell().dispose();
	}

	public void cargarMantenimientoUsuarios() {
		MantenimientoDeUsuarios mdu = new MantenimientoDeUsuarios(inicio.getShell());
		mdu.open();
	}

	public void cargarMantenimiento() {
		
		
	}

	public void cargarMantenimientoTutor() {
		MantenimientoDeTutoresAcademicos mt = new MantenimientoDeTutoresAcademicos(inicio.getShell());
		mt.open();
		
	}
	
}
