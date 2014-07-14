package vista.interfaz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	static public String nombreProyecto = "Gestión de becarios";
	
	static public String dateFormatShort(Date date){
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
}
