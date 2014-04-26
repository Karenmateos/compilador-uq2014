package analizadorSintactico;

public class UnidadDeCompilacion {
	
	static DeclaracionClase declaracionClase;
	
	@SuppressWarnings("static-access")
	public UnidadDeCompilacion(DeclaracionClase declaracionClase) 
	{
		this.declaracionClase = declaracionClase;
	}
	
	public static DeclaracionClase getDeclaracionClase() {
		return declaracionClase;
	}
}
