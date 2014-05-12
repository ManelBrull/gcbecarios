package controlador;
import vista.interfaz.Inicio;
import vista.interfaz.MantenimientoDeUsuarios;
import at.controlador.GestionError;
import at.vista.informes.ReportManager;

public class ControladorInicio {
	
	Inicio inicio;
	
	public ControladorInicio(Inicio mInicio){
		this.inicio = mInicio;
	}

	public void cargarInforme() {
		if(inicio.abrirInforme()){
			try {
				String pathReporte = "/es/atorrent/informes/miReporte.jasper"; 
				ReportManager.lanzarReporte(Inicio.class.getResourceAsStream(pathReporte));
			} catch (Exception e1) {
				new GestionError(inicio.getShell(), e1);
			}
		}
		
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
	
}
