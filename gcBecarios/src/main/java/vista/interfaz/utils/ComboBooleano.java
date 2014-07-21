package vista.interfaz.utils;

public enum ComboBooleano implements EnumToCombo<ComboBooleano> {
	si("Si", true),
	no("No", false);
	
	private String displayString;
	private boolean value;
	
	private ComboBooleano(String displayString, boolean value){
		setDisplayString(displayString);
		setValue(value);
	}

	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}
	
	public ComboBooleano getValue(String value){
		for(ComboBooleano c: ComboBooleano.values()){
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

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
}
