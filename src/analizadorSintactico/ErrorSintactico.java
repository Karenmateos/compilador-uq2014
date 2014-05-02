package analizadorSintactico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* 
*/
public class ErrorSintactico {
	// Variable que almacema el mensaje de error
	private String msn;
	// Variables que almaceman la fila y la colunma del token donde comienza el error
	private int fila, columna;
	
	/**
	 * Metodo Constructor de la Clase Error Sintactico
	 * @param mensaje de error
	 * @param fila del token
	 * @param columna del token
	 */
	public ErrorSintactico(String mensaje, int fila, int columna) 
	{
		this.msn = mensaje;
		this.fila = fila;
		this.columna = columna;
	}

	/**
	 * Metodo que permite obtener el mensaje de error
	 * @return el mensaje de error
	 */
	public String getMsn() {
		return msn;
	}

	/**
	 * Metodo que permite modificar el mensaje de error
	 * @param el mensaje de error
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}

	/**
	 * Metodo que permite obtener la fila del token
	 * @return la posicion de fila del token
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Metodo que permite modificar la fila
	 * @param fila
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}

	/**
	 * Metodo que permite obtener la columna del token
	 * @return la posicion de columna del token
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * Metodo que permite modificar la columna
	 * @param columna
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}
}
