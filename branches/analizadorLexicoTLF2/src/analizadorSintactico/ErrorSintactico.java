package analizadorSintactico;

public class ErrorSintactico {
	
	private String msn;
	private int fila, columna;
	
	/**
	 * Metodo Constructor de la Clase Error Sintactico
	 * @param mensaje
	 * @param fila
	 * @param columna
	 */
	public ErrorSintactico(String mensaje, int fila, int columna) 
	{
		this.msn = mensaje;
		this.fila = fila;
		this.columna = columna;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
}
