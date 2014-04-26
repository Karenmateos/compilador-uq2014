package analizadorSintactico;

import java.util.ArrayList;

import analizadorLexico.SimboloLexico;

public class AnalizadorSintactico {
	private ArrayList<SimboloLexico> listaSimbolosLexicos;
	private ArrayList<ErrorSintactico> listaErroresSintacticos;
	private SimboloLexico tokenActual;
	private int indice;
	private UnidadDeCompilacion miUnidadDeCompilacion;
}
