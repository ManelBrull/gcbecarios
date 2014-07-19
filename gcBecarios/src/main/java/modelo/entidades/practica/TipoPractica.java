package modelo.entidades.practica;

import vista.interfaz.utils.EnumToCombo;

public enum TipoPractica implements EnumToCombo<TipoPractica>{
	profesionales("Profesionales"),
	deFormacion("De formación");

	private String displayString;
	
	private TipoPractica(String displayString){
		setDisplayString(displayString);
	}
	
	@Override
	public String getDisplayString() {
		return this.displayString;
	}

	@Override
	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}

	@Override
	public TipoPractica getValue(String value) {
		for(TipoPractica c: TipoPractica.values()){
			if(c.getDisplayString().equals(value))
				return c;
		}
		return null;
	}
	
	
}
