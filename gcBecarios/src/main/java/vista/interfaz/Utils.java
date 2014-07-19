package vista.interfaz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.widgets.DateTime;

public class Utils {
	static public String nombreProyecto = "Gestión de becarios";
	
	static public String dateFormatShort(Date date){
		return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
	static public Date getDate(DateTime dateTime){
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DAY_OF_MONTH, dateTime.getDay());
		instance.set(Calendar.MONTH, dateTime.getMonth());
		instance.set(Calendar.YEAR, dateTime.getYear());
		return instance.getTime();
	}
	
	static public void setDate(DateTime dateTime, Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		dateTime.setYear(instance.get(Calendar.YEAR));
		dateTime.setMonth(instance.get(Calendar.MONTH));
		dateTime.setDay(instance.get(Calendar.DAY_OF_MONTH));
	}
	
}
