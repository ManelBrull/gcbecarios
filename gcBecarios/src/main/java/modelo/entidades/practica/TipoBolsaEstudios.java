package modelo.entidades.practica;

import vista.interfaz.utils.EnumToCombo;

public enum TipoBolsaEstudios implements EnumToCombo<TipoBolsaEstudios> {
	hora("Hora"),
	mensual("Mensual"),
	total("Total");
	
	private String displayString;
	
	private TipoBolsaEstudios(String displayString){
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
	public TipoBolsaEstudios getValue(String value) {
		for(TipoBolsaEstudios c: TipoBolsaEstudios.values()){
			if(c.getDisplayString().equals(value))
				return c;
		}
		return null;
	}
}
