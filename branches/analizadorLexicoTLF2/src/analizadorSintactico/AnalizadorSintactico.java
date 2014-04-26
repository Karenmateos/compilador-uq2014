package analizadorSintactico;

import java.util.ArrayList;

import analizadorLexico.SimboloLexico;

public class AnalizadorSintactico {
	
	private ArrayList<SimboloLexico> listaSimbolosLexicos;
	private ArrayList<ErrorSintactico> listaErroresSintacticos;
	private SimboloLexico tokenActual;
	private int indice;
	private UnidadDeCompilacion miUnidadDeCompilacion;


/**
 * Constructor de la clase AnalizadorSintactico
 * @param listaSimbolos
 */
public AnalizadorSintactico(ArrayList<SimboloLexico> listaSimbolos)
{
	this.listaSimbolosLexicos = listaSimbolos;
	listaErroresSintacticos = new ArrayList<ErrorSintactico>();
	indice = 0;
	tokenActual = listaSimbolosLexicos.get(indice);
	miUnidadDeCompilacion = esUnidadDeCompilacion();
}

/**
 * Obtiene el siguiente token de la lista de simbolos lexicos
 */
public void darSiguienteToken()
{
	if(indice == listaSimbolosLexicos.size()-1)
	{
		return;

	}else
	{
		indice++;
		tokenActual = listaSimbolosLexicos.get(indice);
	}
}

/**
 * Realiza Backtracking - devuelve la posicion y el token anterior
 * @param posBT
 */
public void realizarBactracking(int posBT)
{
	indice = posBT;
	tokenActual = listaSimbolosLexicos.get(indice);
}
}