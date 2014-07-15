package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase con metodos utiles para fechas
 * 
 * @author ManelBrull
 *
 */
public class DateUtil {
	
	public static boolean equalDateddMMyyyy(Date d1, Date d2){
		return (
				new SimpleDateFormat("ddMMyyyy").format(d1))
					.equals(
						new SimpleDateFormat("ddMMyyyy").format(d2)
				);
	}

}
