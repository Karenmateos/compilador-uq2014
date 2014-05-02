package analizadorLexico;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;



/**
 * Este clase contiene los metodos predicados y es la encargada 
 * de analizar el codigo fuente y determinar que tipo de lexema es.
 * 
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz
 * 
 */

public class AnalizadorLexico {

	/**
	 * Atributo que contiene la fila Actual del lexema que esta analizando
	 */
	int filaActual ; 

	/**
	 * Atributo que contiene la Columna Actual del lexema que esta analizando 
	 */
	int columnaActual;

	/**
	 * Atributo que contiene la posicion Actual del codigo fuente que se esta analizando
	 */
	int posicionActual;

	/**
	 * Atributo que contiene el caracter Actual del codigo fuente que se esta analizando
	 */
	char  caracterActual;

	/**
	 * Atributo que contiene el codigo fuente que se va a analizar
	 */
	String codigoFuente;

	/**
	 * Lista que almacena los tokens
	 */
	ArrayList<SimboloLexico> tablaSimbolos;

	/**
	 * Lista que almacena los lexemas no reconocidos por el lenguaje 
	 */
	ArrayList<SimboloLexico> tablaErrores;

	/**
	 *  Lista que almacena las que van a ser 
	 *  palabras reservadas del lenguaje
	 */
	ArrayList<String> reservadas;

	/**
	 *  Constante que indica el fin del codigo fuente
	 */
	static final char EOC=0;

	/**
	 * Constructor de la clase AnalizadorLexico, en el cual se inicializan las listas
	 */
	public AnalizadorLexico(){


		reservadas = new ArrayList<String>();                // se crea la lista para almacenar las palabras reservadas
		tablaSimbolos = new ArrayList<SimboloLexico>();      // se crea la lista para almacenar los tokens 
		tablaErrores = new ArrayList<SimboloLexico>();       // se crea la lista para almacenar los errores  


	}

	/**
	 * Metodo que recive el codigo fuente, y tiene como funcion hacer el llamado 
	 * de los metodos predicados que determinan los tokens encontrados en el codigo fuente
	 *  
	 * @param codigoFuente
	 */
	public void analizar(String codigoFuente)
	{
		/* 
		 * llamado al metodo cargarReservadas que permite cargar las palabras reservadas 
		 * por defecto 
		 */
		cargarReservadas();

		/*
		 *  Se Inicializa la posición Fila y Columna en 1. Y la posición Actual que recorre 
		 *  el código en 0.
		 */
		filaActual=columnaActual = 1;
		posicionActual = 0;

		/*
		 * Se le agraga el caracter de fin de archivo al codigo fuente
		 */
		this.codigoFuente = codigoFuente+EOC;

		/*
		 * inicializa el lexema de error
		 */
		String lexema = "";


		/*
		 * Crea un arraylist de símbolos Léxicos
		 * para almacenar los simbolos léxicos que son validos para el lenguaje definido
		 */
		tablaSimbolos = new ArrayList<SimboloLexico>();

		/*
		 * Crea un arraylist de símbolos Léxicos
		 * para almacenar los simbolos léxicos que no son validos para el lenguaje definido
		 */
		tablaErrores = new ArrayList<SimboloLexico>();


		//si no se ha terminado el archivo
		if (codigoFuente.length()!=EOC) 
		{
			//extraigo el primer caracter del Código Fuente
			caracterActual=codigoFuente.charAt(posicionActual);

		}
		else
		{
			//a caracterActual le asigno EOC que indica la finalización del codigoFuente
			caracterActual=EOC;
		}	

		/*
		 * Mientras existan caracteres por analizar se van llamando diferentes métodos
		 * predicados que definirán el símbolo Léxico
		 */
		while (caracterActual!=EOC)
		{
			/////////////////////////////////////////////////////////////
			/////////////////////////// Palabras reservadas//////////////
			/////////////////////////////////////////////////////////////

			if(esReservada())
				continue;

			/////////////////////////////////////////////////////////////
			/////////////////////////// Cadena///////////////////////////
			/////////////////////////////////////////////////////////////

			if(esCadena())
				continue;

			/////////////////////////////////////////////////////////////
			/////////////////////////// Numeros///////////////////////////
			/////////////////////////////////////////////////////////////

			if(esEntero())
				continue;
			if(esReal())
				continue;

			/////////////////////////////////////////////////////////////
			//////////////////// Identificadores/////////////////////////
			/////////////////////////////////////////////////////////////

			if(esClase())
				continue;
			if(esMetodo())
				continue;
			if(esVariable())
				continue;

			/////////////////////////////////////////////////////////////
			////////////// Aditivos Y Multiplicativos////////////////////
			/////////////////////////////////////////////////////////////

			if(esOperadorMultiplicacion())
				continue;
			if(esOperadorSuma())
				continue;
			if(esOperadorResta())
				continue;
			if(esOperadorDivision())
				continue;

			/////////////////////////////////////////////////////////////
			////////////////////////Relacionales/////////////////////////
			/////////////////////////////////////////////////////////////

			if(esMayoreIgual())
				continue;
			if(esMenoreIgual())
				continue;
			if(esIgualeIgual())
				continue;
			if(esOperadorMayor())
				continue;
			if(esOperadorMenor())
				continue;

			/////////////////////////////////////////////////////////////
			/////////////////////////// Logicos//////////////////////////
			/////////////////////////////////////////////////////////////

			if(esConjuncion())
				continue;
			if(esDisyuncion())
				continue;

			if(esNegacion())
				continue;
			//////////////////////////////////////////////////////////////
			/////////////////////////// Asignacion////////////////////////
			//////////////////////////////////////////////////////////////

			if(esOperadorAsignacion())
				continue;


			//////////////////////////////////////////////////////////////
			/////////////////////////// Parentesis////////////////////////
			//////////////////////////////////////////////////////////////

			if(esAbreParentesis())
				continue;
			if(esCierraParentesis())
				continue;

			/////////////////////////////////////////////////////////////
			/////////////////////////// Llaves///////////////////////////
			/////////////////////////////////////////////////////////////

			if(esAbreLlave())
				continue;
			if(esCierraLlave())
				continue;

			/////////////////////////////////////////////////////////////
			/////////////////////////// Terminal/////////////////////////
			/////////////////////////////////////////////////////////////

			if(esOperadorTerminal())
				continue;


			if(esSeparador())
				continue;

			/////////////////////////////////////////////////////////////
			/////////////////////////// Comentarios//////////////////////
			/////////////////////////////////////////////////////////////

			if(esComentario())
				continue;


			if(esEspacio())
				continue;

			if(esTab())
				continue;

			if(esSaltoLinea())
				continue;

			/////////////////////////////////////////////////////////////
			//////////// no reconocidos por el lenguaje//////////////////
			/////////////////////////////////////////////////////////////

			/*
			 * variables utilizadas para guardar la fila inicial y columna inicial
			 */
			int filaInicial = filaActual;
			int columnaInicial= columnaActual;

			/*
			 * almacena en lexema los caracteres hasta encontrar un espacio, una tabulacion, un salto de linea, una coma,
			 * un punto y coma o el fin de archivo
			 */
			do
			{
				lexema +=caracterActual;
				sigteCaracter();
			}
			while(!(esSaltoLinea() || esEspacio() || esTab() || caracterActual==EOC || caracterActual==',' || caracterActual==';'));

			//si no pertenece a nuestro lenguaje lo almacena como un símbolo no identificado
			almacenarError(""+lexema, Configuracion.error, filaInicial, columnaInicial);
			lexema="";


		}
	}

	/**
	 * Metodo que indica cuales son las palabras reservadas en el codigo fuente
	 * 
	 * @return  retorna true si es reservada
	 */
	public boolean esReservada(){

		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual;
		int columnaInicialToken = columnaActual;

		// variable que almacena el lexema 
		String lexema = "";

		char caracterPalabra = ' ';

		/*
		 * este for recorre el arrylist que contiene las palabras reservadas
		 */
		for (String palabra : reservadas) {

			for (int i = 0; i < palabra.length(); i++) {   // en este for se compara caracter a caracter las palabras reservadas con el codigo fuente

				caracterPalabra = palabra.charAt(i);

				if (caracterPalabra != caracterActual) {

					backtraking(posicionParaBactraking, filaIniToken,
							columnaInicialToken);
					lexema="";
					break;

				}
				lexema += caracterActual;

				// si el lexema es igual a alguna de las palabra reservadas se almacena 
				if (lexema.equals(palabra)) {

					if(verificarEspacio()){

						almacenarToken(lexema, Configuracion.palabraReservada, filaIniToken,
								columnaInicialToken);

						return true;
					}

					backtraking(posicionParaBactraking, filaIniToken,
							columnaInicialToken);
					lexema="";
				}

				sigteCaracter();
			}

			backtraking(posicionParaBactraking, filaIniToken,
					columnaInicialToken);
			lexema="";

		}
		backtraking(posicionParaBactraking, filaIniToken,
				columnaInicialToken);
		return false;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////METODOS PREDICADO/////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 *  Metodo que verifica si el caracter actual es un espacio
	 * @return retorna true si es un espacio
	 */
	public boolean esEspacio()
	{


		if(caracterActual!=' ')
		{
			return false;
		}
		sigteCaracter();
		return true;
	}

	/**
	 * metodo que verifica si el caracter actual es un tabulador
	 * 
	 * @return retorna true si en un tabulador
	 */
	public boolean esTab(){
		if(caracterActual!='\t')
		{
			return false;
		}
		sigteCaracter();
		return true;
	}

	/**
	 * metodo que verifica si el caracter actual es una ,
	 * @return si el caracter actual es una , retorna true
	 */
	public boolean esSeparador()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual==',')
		{
			lexema+=caracterActual;
			sigteCaracter();
			almacenarToken(lexema,Configuracion.separador, filaIniToken, columnaInicialToken);
			return true;


		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  metodo que verifica si el lexema es un entero valido para el lenguaje definido
	 * @return retorna true si es un entero valido para el lenguaje definido
	 */
	public boolean esEntero()
	{

		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";



        // El lexema debe empezar por una E y terminar con un E para ser un entero
		if(caracterActual !='E')
		{
			return false;
		}

		lexema+=caracterActual;
		sigteCaracter();


		//si el siguiente caracter es digito lo almacena en lexema y pasa al siguiente caracter
		if(Character.isDigit(caracterActual)){
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		
        // Mientras el caracter actual sea un digito lo almacena en lexema y pasa a siguiente caracter
		while(Character.isDigit(caracterActual))
		{
			lexema+=caracterActual;
			sigteCaracter();


		}

		if(caracterActual=='E')
		{	
			lexema+=caracterActual;

			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.Entero, filaIniToken, columnaInicialToken);

				return true;
			}

			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}


		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  metodo que verifica si el lexema es un real valido para el lenguaje definido
	 * @return retorna true si es un real valido para el lenguaje definido
	 */
	public boolean esReal()
	{

		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		// El lexema debe empezar por una R y terminar con un R para ser un real
		if(caracterActual !='R')
		{
			return false;
		}

		lexema+=caracterActual;
		sigteCaracter();



		if(Character.isDigit(caracterActual)){
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		// Mientras el caracter actual sea un digito lo almacena en lexema y pasa a siguiente caracter
		while(Character.isDigit(caracterActual))
		{
			lexema+=caracterActual;
			sigteCaracter();

		}
		if(caracterActual =='.')
		{
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		if(Character.isDigit(caracterActual)){
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		
		// Mientras el caracter actual sea un digito lo almacena en lexema y pasa a siguiente caracter
		while(Character.isDigit(caracterActual))
		{

			lexema+=caracterActual;
			sigteCaracter();

		}

		if(caracterActual=='R')
		{	
			lexema+=caracterActual;

			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.Real, filaIniToken, columnaInicialToken);
				return true;
			}

			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  metodo que verifica si el lexema es una clase valida para el lenguaje definido
	 * @return retorna true si es una clase valida para el lenguaje definido
	 */
	public boolean esClase()
	{

		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		//se almacena el caracterActual en la cadena lexema
		String lexema =  "";


		// El lexema debe empezar por una { y terminar con un } para ser una clase
		if(caracterActual !='{')
		{
			return false;  
		}

		lexema+=caracterActual;
		sigteCaracter();


		//si el caracter actual es una letra, entonces llama al siguiente caracter
		if(Character.isLetter((caracterActual)))
		{
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}



		//Mientras el caracter sea una letra, adiciona al lexema ese caracter y sigue revisando
		//el siguiente caracter.
		while (Character.isLetter(caracterActual))
		{   lexema += caracterActual;

		//Avanza al siguiente caracter sobre el codigo fuente 
		sigteCaracter();
		}



		if(caracterActual =='}')
		{	
			lexema+=caracterActual;

			if(verificarEspacio()){
				if(verificarTamanioId(lexema, 30)){

					almacenarToken(lexema,Configuracion.IdClase,filaIniToken,columnaInicialToken);
					
					return true;
				}
				almacenarError(lexema, Configuracion.desvorde, filaIniToken,columnaInicialToken);
				return true;
			}

			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;

		}




		else
		{	
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}

	}

	/**
	 *  metodo que verifica si el lexema es un metodo valido para el lenguaje definido
	 * @return retorna true si es un metodo valido para el lenguaje definido
	 */
	public boolean esMetodo()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		//se almacena el caracterActual en la cadena lexema
		String lexema =  "";


		// El lexema debe empezar por un [ y terminar con un ] para ser un metodo
		if(caracterActual !='[')
		{
			return false;  
		}

		lexema+=caracterActual;
		sigteCaracter();


		//si el caracter actual es una letra, entonces llama al siguiente caracter
		if(Character.isLetter((caracterActual)))
		{
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}




		//Mientras el caracter sea una letra, adiciona al lexema ese caracter y sigue revisando
		//el siguiente caracter.
		while (Character.isLetterOrDigit(caracterActual))
		{   lexema += caracterActual;
		//Avanza al siguiente caracter sobre el codigo fuente 
		sigteCaracter();
		}



		if(caracterActual ==']')
		{	
			lexema+=caracterActual;

			if(verificarEspacio()){
				if(verificarTamanioId(lexema, 30)){
					almacenarToken(lexema,Configuracion.IdMetodo,filaIniToken,columnaInicialToken);
					return true;
				}
				almacenarError(lexema, Configuracion.desvorde, filaIniToken,columnaInicialToken);
				return true;
			}

			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

		else
		{	
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}

	}
	/**
	 *  metodo que verifica si el lexema es una variable valida para el lenguaje definido
	 * @return retorna true si es una variable valida para el lenguaje definido
	 */
	public boolean esVariable()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		//se almacena el caracterActual en la cadena lexema
		String lexema =  "";

		// El lexema debe empezar por un ¿ y terminar con un ? para ser una variable
		if(caracterActual !='¿')
		{
			return false;  
		}

		lexema+=caracterActual;
		sigteCaracter();

		//si el caracter actual es una letra, entonces llama al siguiente caracter
		if(Character.isLetter((caracterActual)))
		{
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}




		//Mientras el caracter sea un dígito o una letra, adiciona al lexema ese caracter y sigue revisando
		//el siguiente caracter.
		while (Character.isLetterOrDigit(caracterActual))
		{   lexema += caracterActual;
		//Avanza al siguiente caracter sobre el codigo fuente 
		sigteCaracter();
		}

		if(caracterActual =='?')
		{	
			lexema+=caracterActual;

			if(verificarEspacio()){
				if(verificarTamanioId(lexema, 15)){
					almacenarToken(lexema,Configuracion.IdVariable,filaIniToken,columnaInicialToken);
					return true;
				}
				almacenarError(lexema, Configuracion.desvorde, filaIniToken,columnaInicialToken);
				return true;
			}

			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;

		}

		else
		{	
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}

	}

	/**
	 *  metodo que verifica si el lexema es un operador relacional valido para el lenguaje definido
	 * @return retorna true si es el operador relacional (>=) 
	 */
	public boolean esMayoreIgual()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";


		if(caracterActual !='>')
		{
			return false;
		}

		lexema+=caracterActual;
		sigteCaracter();


		if(caracterActual=='=')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorRelacional, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}

	/**
	 *  metodo que verifica si el lexema es un operador relacional valido para el lenguaje definido
	 * @return retorna true si es el operador relacional (<=) 
	 */
	public boolean esMenoreIgual()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";


		if(caracterActual !='<')
		{
			return false;
		}

		lexema+=caracterActual;
		sigteCaracter();


		if(caracterActual=='=')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorRelacional, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}

	/**
	 *  metodo que verifica si el lexema es un operador relacional valido para el lenguaje definido
	 * @return retorna true si es el operador relacional (==) 
	 */
	public boolean esIgualeIgual()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";


		if(caracterActual !='=')
		{
			return false;
		}

		lexema+=caracterActual;
		sigteCaracter();


		if(caracterActual=='=')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorRelacional, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

	}

	/**
	 *  metodo que verifica si el lexema es un operador terminal valido para el lenguaje definido
	 * @return retorna true si es el operador es un ; 
	 */
	public boolean esOperadorTerminal()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual==';')
		{
			lexema+=caracterActual;

			sigteCaracter();
			almacenarToken(lexema, Configuracion.FinSentencia, filaIniToken, columnaInicialToken);
			return true;

		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  metodo que verifica si el lexema es un operador de asignación valido para el lenguaje definido
	 * @return retorna true si es el operador es un = 
	 */
	public boolean esOperadorAsignacion()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='=')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorAsignacion, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  metodo que verifica si el lexema es un operador relacional valido para el lenguaje definido
	 * @return retorna true si es el operador relacional (<) 
	 */
	public boolean esOperadorMenor()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='<')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorRelacional, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es un operador relacional valido para el lenguaje definido
	 * @return retorna true si es el operador relacional (>) 
	 */
	public boolean esOperadorMayor()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='>')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorRelacional, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es el operador de división valido para el lenguaje definido
	 * @return retorna true si es el operador es un / 
	 */
	public boolean esOperadorDivision()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='/')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorMatematico, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es el operador de resta valido para el lenguaje definido
	 * @return retorna true si es el operador es un - 
	 */
	public boolean esOperadorResta()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='-')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorMatematico, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es el operador de suma valido para el lenguaje definido
	 * @return retorna true si es el operador es un +
	 */
	public boolean esOperadorSuma()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='+')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema,Configuracion.OperadorMatematico, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es el operador de multiplicación valido para el lenguaje definido
	 * @return retorna true si es el operador es un *
	 */
	public boolean esOperadorMultiplicacion()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='*')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema,Configuracion.OperadorMatematico, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es una apertura de parentisis 
	 * @return retorna true si el caracter actual es un (
	 */
	public boolean esAbreParentesis()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='(')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema,Configuracion.AperturaParentesis, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es un cierre de parentisis 
	 * @return retorna true si el caracter actual es un )
	 */
	public boolean esCierraParentesis()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual==')')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema,Configuracion.CierreParentesis, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es una apertura de llaves 
	 * @return retorna true si el caracter actual es un {
	 */
	public boolean esAbreLlave()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='{')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema,Configuracion.AbrirLlaves, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 *  Metodo que verifica si el lexema es un cierre de llaves 
	 * @return retorna true si el caracter actual es un }
	 */
	public boolean esCierraLlave()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='}')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.CerrarLLaves, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 * Metodo que verifica si el lexema es un operador logico definido en el lenguaje
	 * @return retorna true si el lexema es &
	 */
	public boolean esConjuncion()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='&')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorLogicoY, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 * Metodo que verifica si el lexema es un operador logico definido en el lenguaje
	 * @return retorna true si el lexema es |
	 */
	public boolean esDisyuncion()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='|')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.OperadorLogicoO, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 * Metodo que verifica si el lexema es un operador logico definido en el lenguaje
	 * @return retorna true si el lexema es ¬
	 */
	public boolean esNegacion()
	{
		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;
		String lexema="";

		if(caracterActual=='¬')
		{
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema, Configuracion.operadorNegacion, filaIniToken, columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}
	}

	/**
	 * Metodo que verifica que el lexema es un comentario valido para el lenguaje definido
	 * @return retorna true si el lexema es un comentario valido para el lenguaje
	 */
	public boolean esComentario()	{


		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		//se almacena el caracterActual en la cadena lexema
		String lexema =  "";

		// El lexema debe empezar por un @ y terminar con un @ para ser un comentario
		if(caracterActual !='@')
		{
			return false;  
		}

		lexema+=caracterActual;
		sigteCaracter();


		//si el caracter actual es un Digito, letra, espacio o salto de linea lo almacena en lexema y llama al siguiente caracter
		if(Character.isLetterOrDigit((caracterActual)) || (caracterActual==' ')||caracterActual=='\n')
		{
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}

		//Mientras el caracter sea un digito, una letra, un espacio, o un salto de linea, adiciona al lexema ese caracter y sigue revisando
		//el siguiente caracter.
		while (Character.isLetterOrDigit(caracterActual)|| caracterActual==' '|| caracterActual=='\n')
		{   lexema += caracterActual;
		//Avanza al siguiente caracter sobre el codigo fuente 
		sigteCaracter();
		}

		if(caracterActual =='@')
		{	
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema,Configuracion.Comentario,filaIniToken,columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;

		}

		else
		{	
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}

	}

	/**
	 * Metodo que verifica que el lexema es una cadena valida para el lenguaje definido
	 * @return retorna true si el lexema es una cadena valida para el lenguaje
	 */
	public boolean esCadena()
	{

		/*
		 * variables para guardar las pocisiones iniciales y poder realizar el backtraking
		 */
		int posicionParaBactraking = posicionActual;
		int filaIniToken = filaActual; 
		int columnaInicialToken = columnaActual;

		//se almacena el caracterActual en la cadena lexema
		String lexema =  "";

		// El lexema debe empezar por un ! y terminar con un ! para ser una cadena 
		if(caracterActual !='!')
		{
			return false;  
		}

		lexema+=caracterActual;
		sigteCaracter();


		//se garantiza que halla al menos una letra o simbolo dentro de los signos de admiracion
		if((caracterActual>='"' && caracterActual<='¡') || caracterActual==' ')
		{
			lexema+=caracterActual;
			sigteCaracter();
		}
		else
		{
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;

		}



		//Mientras el caracter se encuentre en el intervalo, adiciona al lexema ese caracter y sigue revisando
		//el siguiente caracter.
		while ((caracterActual>='"' && caracterActual<='¡')& caracterActual!=' ')
		{   
			lexema += caracterActual;

			//Avanza al siguiente caracter sobre el codigo fuente 
			sigteCaracter();
		}

		if(caracterActual =='!')
		{	
			lexema+=caracterActual;
			if(verificarEspacio()){
				almacenarToken(lexema,Configuracion.Cadena,filaIniToken,columnaInicialToken);
				return true;
			}
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);
			return false;
		}

		else
		{	
			backtraking(posicionParaBactraking, filaIniToken, columnaInicialToken);

			return false;
		}

	}

	/**
	 * Metodo que verifica si el caracter actual es un salto de linea
	 * @return retorna true en caso de que el caracter actual se un salto de linea
	 */
	public boolean esSaltoLinea()
	{
		if(caracterActual=='\n')
		{	
			sigteCaracter();
			return true;
		}
		return false;
	}

	/**
	 * El método bactracking se encarga de reiniciar la posicionActual, caracterActual,
	 * columnaActual,filaActual para comenzar de nuevo la búsqueda en el código Fuente de un
	 * nuevo lexema
	 * @param posicionParaBacktraking. variable con la posición a la que debe devolverse en el codigo fuente
	 * @param filaInicialToken. variable con la fila a la que debe volver 
	 * @param columnaInicialToken. variable con la columna a la que debe volver
	 */
	public void backtraking(int posicionParaBacktraking, int filaInicialToken, int columnaInicialToken) 
	{
		posicionActual=posicionParaBacktraking;
		caracterActual=codigoFuente.charAt(posicionActual);

		columnaActual=columnaInicialToken;
		filaActual=filaInicialToken;

	}

	/**
	 * Metodo que se encarga de adelantar una posición en el código Fuente, obteniendo asi el siguiente caracter
	 */
	public void sigteCaracter()
	{    //Si el caracter leído el igual a la EOC terminación del archivo, entonces a
		//caracterActual le asigna EOC
		if(codigoFuente.charAt(posicionActual+1)==EOC)
		{
			caracterActual=EOC;

		}
		else
		{   //Si el caracter leído del códigoFuente es un Salto de Línea '\n' entonces incrementa
			//la fila e inicializa la columnaActual en 0
			if(codigoFuente.charAt(posicionActual+1)=='\n')
			{
				filaActual++;
				columnaActual=0;
			}
			else 
				//Si el caracter leído del códigoFuente es un tabulador '\t' entonces incrementa
				//la fila e inicializa la columnaActual en 4
				if(codigoFuente.charAt(posicionActual+1)=='\t')
					columnaActual+=4;
				else
					columnaActual++;

			posicionActual++;
			caracterActual=codigoFuente.charAt(posicionActual);
		}
	}

	/**
	 * Metodo que almacena en la tabla de símbolos léxicos el nuevo símboloLexico
	 * @param lexema. palabra reconocida por el lenguaje
	 * @param tipo. tipo de lexema 
	 * @param filaInicial. fila en la que inicia el lexema
	 * @param columnaInicial. columna en la que inicia el lexema
	 */
public	void almacenarToken(String lexema, String tipo, int filaInicial, int columnaInicial) 
	{
		SimboloLexico auxiliar = new SimboloLexico(lexema, tipo, filaInicial, columnaInicial);
		tablaSimbolos.add(auxiliar);

	}

	/**
	 * Método que almacena en la tabla de símbolos de errores los lexemas no validos para el lenguaje definido
	 * @param lexema. lexema no valido para el lenguaje
	 * @param error. tipo de error
	 * @param filaInicial. fila en la que comienza el lexema
	 * @param columnaInicial. columna en al que comienza el lexema
	 */
public	void almacenarError(String lexema, String error, int filaInicial, int columnaInicial)
	{
		SimboloLexico auxiliar = new SimboloLexico(lexema, error, filaInicial, columnaInicial);
		tablaErrores.add(auxiliar);

	}


	/**
	 * Metodo que pasa los tokens que se encuentran agregados en la tablaSimbolos a una
	 * matriz para luego ser mostrados en la Interfaz grafica de usuario
	 * 
	 * @return retorna una matriz con los tokens identificados del codigo fuente
	 */
	public String [][]  mostrarTokens()
	{

		ArrayList<SimboloLexico> miTablaDeSimbolos;
		miTablaDeSimbolos = getTablaSimbolos();



		String [][]matriz = new String[miTablaDeSimbolos.size()][4];
		int i=0;


		while(i<miTablaDeSimbolos.size())
		{
			matriz[i][0]=miTablaDeSimbolos.get(i).getLexema();
			matriz[i][1]=miTablaDeSimbolos.get(i).getTipo();
			matriz[i][2]=""+miTablaDeSimbolos.get(i).getFila();
			matriz[i][3]=""+miTablaDeSimbolos.get(i).getColumna();
			i++;
		}


		return matriz;

	}

	/**
	 * Metodo que pasa los errores que se encuentran agregados en la tablaErrores a una
	 * matriz para luego ser mostrados en la Interfaz grafica de usuario
	 * 
	 * @return retorna una matriz con los tokens no identificados del codigo fuente
	 */
	public String [][]  mostrarTokensError()
	{

		ArrayList<SimboloLexico> miTablaDeSimbolosE;
		miTablaDeSimbolosE = getTablaErrores();



		String [][]matriz = new String[miTablaDeSimbolosE.size()][4];
		int i=0;


		while(i<miTablaDeSimbolosE.size())
		{
			matriz[i][0]=miTablaDeSimbolosE.get(i).getLexema();
			matriz[i][1]=miTablaDeSimbolosE.get(i).getTipo();
			matriz[i][2]=""+miTablaDeSimbolosE.get(i).getFila();
			matriz[i][3]=""+miTablaDeSimbolosE.get(i).getColumna();
			i++;
		}


		return matriz;

	}

	/**
	 * Metodo que verifica si el caracter actual es un espacio
	 * @return retorna true en caso de que el caracter actual sea un espacio
	 */
	public boolean verificarEspacio(){
		sigteCaracter();
		if(esEspacio() || esSaltoLinea() || esTab() || caracterActual==EOC || caracterActual==',' || caracterActual==';'){
			return true;
		}
		return false;
	}

	public boolean verificarTamanioId(String lexema,int limite){
		if(lexema.length()<=limite){
			return true;
		}
		return false;
	}

	/**
	 * Metodo que permite cargar las palabras reservadas desde un archivo txt dado por defecto
	 */
	public void cargarReservadas(){

		if(reservadas.size()==0){
			try{

				File file;
				FileReader reader;
				BufferedReader bufferedReader;
				String linea = "";

				file = new File(Configuracion.rutaReservadas);
				reader = new FileReader(file);
				bufferedReader = new BufferedReader(reader);

				while((linea=bufferedReader.readLine()) != null){
					reservadas.add(linea);
				}				
				reader.close();
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo que permite cargar palabras reservadas desde un archivo txt con una ruta dada.
	 * 
	 * @param ruta ruta que indicxa la ubicacion del archivo que contiene las palabras reservadas.
	 */
	public void cargarReservadas(String ruta){

		reservadas.clear();

		try{

			File file;
			FileReader reader;
			BufferedReader bufferedReader;
			String linea = "";

			file = new File(ruta);
			reader = new FileReader(file);
			bufferedReader = new BufferedReader(reader);

			while((linea=bufferedReader.readLine()) != null){
				reservadas.add(linea);
			}

			reader.close();

		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que permite cargar el codigo fuente desde un archivo txt con una ruta dada.
	 * @param ruta ubicacion del archivo txt que contiene el codigo fuente
	 * @return ratorna un String con las palabras encontradas en el txt
	 * @throws IOException  
	 */
	public String cargarCodigo(String ruta) throws IOException {



		File file = new File(ruta);
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);

		String linea = " ";
		String codigo = "";

		while ((linea = bufferedReader.readLine()) != null) {

			codigo += linea + "\n";
		}
		reader.close();
		return codigo;
	}

	/**
	 * Metodo que retorna el arreglo de símbolos léxicos encontrados en el código Fuente
	 * 
	 * @return retorna la tabla de simbolos que son validos para el lenguaje
	 */
	public ArrayList<SimboloLexico> getTablaSimbolos() {
		return tablaSimbolos;
	}

	/**
	 *  Metodo que retorna la lista de lexemas que no son validos para el lenguaje
	 * 
	 * @return retorna la tabla de de errores 
	 */
	public ArrayList<SimboloLexico> getTablaErrores() {
		return tablaErrores;
	}

	/**
	 *  Metodo para obtener el atributo filaActual
	 * @return retorna la fila en la que se encuentra el lexema
	 */
	public int getFilaActual() {
		return filaActual;
	}

	/**
	 * Metodo para modificar el valor del atributo filaActual
	 * @param filaActual. parametro con el nuevo valor de filaActual
	 */
	public void setFilaActual(int filaActual) {
		this.filaActual = filaActual;
	}

	/**
	 *  Metodo para obtener el atributo columnaActual
	 * @return retorna la columna en la que se encuentra el lexema
	 */
	public int getColumnaActual() {
		return columnaActual;
	}

	/**
	 * Metodo para modificar el valor del atributo ColumnaActual
	 * 
	 * @param columnaActual. parametro con el nuevo valor de columnaActual
	 */
	public void setColumnaActual(int columnaActual) {
		this.columnaActual = columnaActual;
	}

	/**
	 *  Metodo para obtener el atributo posicionActual
	 *  
	 * @return retorna la posicion actual del caracter
	 */
	public int getPosicionActual() {
		return posicionActual;
	}

	/**
	 * Metodo para modificar el valor del atributo posicionActual
	 * 
	 * @param posicionActual. parametro con el nuevo valor de posicionActual
	 */
	public void setPosicionActual(int posicionActual) {
		this.posicionActual = posicionActual;
	}

	/**
	 *  Metodo para obtener el atributo caracterActual
	 * @return retorna el caracter actual
	 */
	public char getCaracterActual() {
		return caracterActual;
	}

	/**
	 * Metodo para modificar el valor del atributo caracterActual
	 * 
	 * @param caracterActual. parametro con el nuevo valor de caracterActual
	 */
	public void setCaracterActual(char caracterActual) {
		this.caracterActual = caracterActual;
	}

	/**
	 *  Metodo para obtener la variable codigoFuente
	 *  
	 * @return retorna el codigo fuente
	 */
	public String getCodigoFuente() {
		return codigoFuente;
	}

	/**
	 * Metodo para modificar el valor del variable codigoFuente
	 * 
	 * @param codigoFuente. parametro con el nuevo valor de codigoFuente
	 */
	public void setCodigoFuente(String codigoFuente) {
		this.codigoFuente = codigoFuente;
	}

	/**
	 *  Metodo para obtener el arraylist reservadas
	 * @return retorna una lista con las palabras reservadas
	 */
	public ArrayList<String> getReservadas() {
		return reservadas;
	}





}
