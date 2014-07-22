package vista.interfaz.becarios;

import vista.interfaz.utils.ComboBooleano;
import vista.interfaz.utils.EnumToCombo;

public enum ComboFiltroPracticas implements EnumToCombo<ComboFiltroPracticas> {
	practicasBecarios("Prácticas asignadas al becario"),
	todasPracticas("Todas las prácticas");
	
	private String displayString;
	
	private ComboFiltroPracticas(String displayString){
		setDisplayString(displayString);
	}

	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}
	
	public ComboFiltroPracticas getValue(String value){
		for(ComboFiltroPracticas c: ComboFiltroPracticas.values()){
			if(c.getDisplayString().equals(value))
				return c;
		}
		return null;
	}
	
	public ComboBooleano getValue(boolean value){
		for(ComboBooleano c: ComboBooleano.values()){
			if(c.isValue() == value)
				return c;
		}
		return null;
	}
}
