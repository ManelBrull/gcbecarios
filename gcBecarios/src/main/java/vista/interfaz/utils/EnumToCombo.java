package vista.interfaz.utils;

public interface EnumToCombo<T> {
	
	public String getDisplayString();
	public void setDisplayString(String displayString);
	public String toString();
	public T getValue(String value);

}
