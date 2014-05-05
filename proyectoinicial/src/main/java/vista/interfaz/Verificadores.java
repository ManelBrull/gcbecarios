package vista.interfaz;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;

public class Verificadores {
	/**
	 * Comprueba que lo introducido en un text area es un numero
	 * Se implementa mediante un listener verify
	 * @param event
	 */
	public static boolean verificarNumeros(final VerifyEvent event){
		switch (event.keyCode) {  
		case SWT.BS:           // Backspace  
		case SWT.DEL:          // Delete  
		case SWT.HOME:         // Home  
		case SWT.END:          // End  
		case SWT.ARROW_LEFT:   // Left arrow  
		case SWT.ARROW_RIGHT:  // Right arrow  
			return true;  
		}  

		if (!Character.isDigit(event.character)) {  
			return false;  // disallow the action  
		}
		else{
			return true;
		}
	}
	
	/**
	 * Comprueba que lo introducido en un text area es un caracter
	 * Se implementa mediante un listener verify
	 * @param event
	 */
	public static boolean verificarCaracteres(final VerifyEvent event){
		switch (event.keyCode) {  
		case SWT.BS:           // Backspace  
		case SWT.DEL:          // Delete  
		case SWT.HOME:         // Home  
		case SWT.END:          // End  
		case SWT.ARROW_LEFT:   // Left arrow  
		case SWT.ARROW_RIGHT:  // Right arrow  
			return true;  
		}  

		if (Character.isLetter(event.character)){
			return true;  // disallow the action  
		}
		else{
			return false;
		}
	}
	/**
	 * Verifica si el evento es especial, como borrar, darle a fin, etc.
	 * @param event
	 * @return
	 */
	public static boolean verificarCaracterEspecial(final VerifyEvent event){
		switch (event.keyCode) {  
		case SWT.BS:           // Backspace  
		case SWT.DEL:          // Delete  
		case SWT.HOME:         // Home  
		case SWT.END:          // End  
		case SWT.ARROW_LEFT:   // Left arrow  
		case SWT.ARROW_RIGHT:  // Right arrow  
			return true;  
		}
		return false;
	}
}
