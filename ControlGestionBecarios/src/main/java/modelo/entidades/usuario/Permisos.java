package modelo.entidades.usuario;


public enum Permisos {
	Administrador,
	Escritura, 
	Lectura;
	
	public static String[] getValues(){
		return new String[]{"Administrador", "Escritura", "Lectura"};
	}
	
	public static Permisos myValueOf(String str){
		for(int i = 0; i < getValues().length; i++){
			if(str.equals(getValues()[i]))
				return values()[i];
		}
		return null;
	}
}
