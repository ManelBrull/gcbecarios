package modelo.entidades.practica;

import vista.interfaz.utils.EnumToCombo;

public enum TipoHoras implements EnumToCombo<TipoHoras> {
	semanales("Semanales"),
	mensuales("Mensuales"),
	totales("Totales");

	private String displayString;
	
	private TipoHoras(String displayString){
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
	public TipoHoras getValue(String value) {
		for(TipoHoras c: TipoHoras.values()){
			if(c.getDisplayString().equals(value))
				return c;
		}
		return null;
	}
}
