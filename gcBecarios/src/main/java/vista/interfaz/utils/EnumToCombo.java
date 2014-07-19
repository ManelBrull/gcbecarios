package vista.interfaz.utils;
/**
 * Necessary for all the enums who will be in a Combo
 * 
 * @author ManelBrull
 *
 * @param <T>
 */
public interface EnumToCombo<T> {
	
	public String getDisplayString();
	public void setDisplayString(String displayString);
	public T getValue(String value);

}
