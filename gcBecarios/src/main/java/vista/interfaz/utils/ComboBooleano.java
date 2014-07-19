package vista.interfaz.utils;

public enum ComboBooleano implements EnumToCombo<ComboBooleano> {
	si("Si"),
	no("No");
	
	private String displayString;
	
	private ComboBooleano(String displayString){
		setDisplayString(displayString);
	}

	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}
	
	public String toString(){
		return this.getDisplayString();
	}
	
	public ComboBooleano getValue(String value){
		for(ComboBooleano c: ComboBooleano.values()){
			if(c.toString().equals(value))
				return c;
		}
		return null;
	}
}
