package analizadorLexico;

/**
 * La clase SimboloLexico define los atributos de los símbolos y sus métodos
 * 
 * @author Jorge Leonardo Aguirre Martinez
 * 
 * @author Luis Alberto Delgado Ortiz
 */
public class SimboloLexico {
	
	/**
	 * Atributo que almacena el lexema
	 */
	String lexema;
	
	/**
	 *  Atributo que almacena el tipo de lexema
	 */
	String tipo;
	
	/**
	 * atributos que almacenan la fila y la columna en la que se encuentra el lexema
	 */
	int fila, columna;
	
	/**
	 *  Constructor de la clase SimboloLexico
	 * @param lexema 
	 * @param tipo
	 * @param fila
	 * @param columna
	 */
	public SimboloLexico(String lexema, String tipo, int fila, int columna) 
	{
		this.columna = columna;
		this.fila = fila;
		this.lexema = lexema;
		this.tipo = tipo;
	}
	
	/**
	 * Metodo que permite acceder a el atributo lexema
	 * @return retorna el valor del atributo lexema
	 */
	public String getLexema() {
		return lexema;
	}
	
	/**
	 * Metodo que permite modificar el atributo lexema
	 * @param lexema. conjunto de caracteres leidos del codigo fuente 
	 */
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	
	/**
	 * Metodo que permite acceder a el atributo tipo
	 * @return retorna el valor del atributo tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Metodo que permite modificar el atributo tipo
	 * @param tipo. contiene el tipo de lexema 
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Metodo que permite acceder a el atributo fila
	 * @return retorna el valor del atributo fila
	 */
	public int getFila() {
		return fila;
	}
	
	/**
	 * Metodo que permite modificar el atributo fila
	 * @param fila. contiene la fila en la que empieza el lexema
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}
	
	/**
	 * Metodo que permite acceder a el atributo columna
	 * @return retorna el valor del atributo columna
	 */
	public int getColumna() {
		return columna;
	}
	
	/**
	 * Metodo que permite modificar el atributo columna
	 * @param columna. contiene la columna en la que empieza el lexema
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	
}

