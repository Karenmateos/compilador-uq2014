package analizadorLexico;

import java.util.ResourceBundle;


public  class Configuracion {
	                                 
	private static final ResourceBundle properties = ResourceBundle.getBundle("properties/configuracion");
	public static final String tituloVentana = properties.getString("tituloVentana");
	public static final String Analizar = properties.getString("Analizar");
	public static final String codigo = properties.getString("codigo");
	public static final String tablaTokens = properties.getString("tablaTokens");
	public static final String limpiar = properties.getString("limpiar");
	public static final String tablaErrores = properties.getString("tablaErrores");
	public static final String cargarImagen = properties.getString("cargarImagen");
	
	public static final String Entero = properties.getString("Entero");
	public static final String Real = properties.getString("Real");
	public static final String IdClase = properties.getString("IdClase");
	public static final String IdMetodo = properties.getString("IdMetodo");
	public static final String IdVariable = properties.getString("IdVariable");
	public static final String Break = properties.getString("Break");
	public static final String Clase = properties.getString("Clase");
	public static final String Paquete = properties.getString("Paquete");
	public static final String Private = properties.getString("Private");
	public static final String Public = properties.getString("Public");
	public static final String ReservadaEntero = properties.getString("ReservadaEntero");
	public static final String ReservadaFor = properties.getString("ReservadaFor");
	public static final String ReservadaReal = properties.getString("ReservadaReal");
	public static final String ReservadaReturn = properties.getString("ReservadaReturn");
	public static final String ReservadaWhile = properties.getString("ReservadaWhile");
	public static final String OperadorDivision = properties.getString("OperadorDivision");
	public static final String OperadorMultiplicacion = properties.getString("OperadorMultiplicacion");
	public static final String OperadorMatematico = properties.getString("OperadorMatematico");
	public static final String OperadorResta = properties.getString("OperadorResta");
	public static final String OperadorSuma = properties.getString("OperadorSuma");
	public static final String OperadorRelacionalII = properties.getString("OperadorRelacionalII");
	public static final String OperadorRelacionalMayor = properties.getString("OperadorRelacionalMayor");
	public static final String OperadorRelacional = properties.getString("OperadorRelacional");
	public static final String OperadorRelacionalMayorI = properties.getString("OperadorRelacionalMayorI");
	public static final String OperadorRelacionalMenor = properties.getString("OperadorRelacionalMenor");
	public static final String OperadorRelacionalMenorI = properties.getString("OperadorRelacionalMenorI");
	public static final String OperadorLogicoO = properties.getString("OperadorLogicoO");
	public static final String OperadorLogicoY = properties.getString("OperadorLogicoY");
	public static final String OperadorAsignacion = properties.getString("OperadorAsignacion");
	public static final String AperturaParentesis = properties.getString("AperturaParentesis");
	public static final String CierreParentesis = properties.getString("CierreParentesis");
	public static final String AbrirLlaves = properties.getString("AbrirLlaves");
	public static final String CerrarLLaves = properties.getString("CerrarLLaves");
	public static final String FinSentencia = properties.getString("FinSentencia");
	public static final String Comentario = properties.getString("Comentario");
	public static final String Cadena = properties.getString("Cadena");
	public static final String operadorNegacion = properties.getString("operadorNegacion");
	
	
	public static final String cargarCodigo = properties.getString("cargarCodigo");
	public static final String cargarReservadas = properties.getString("cargarReservadas");
	public static final String cargar = properties.getString("cargar");
	
	public static final String lexema = properties.getString("lexema");
	public static final String tipo = properties.getString("tipo");
	public static final String fila = properties.getString("fila");
	public static final String columna = properties.getString("columna");
	
	public static final String error = properties.getString("error");
	public static final String palabraReservada = properties.getString("palabraReservada");
	public static final String separador = properties.getString("separador");
	public static final String desvorde = properties.getString("desvorde");
	
	private static ResourceBundle ruta = ResourceBundle.getBundle("properties/ruta");
	public static final String rutaReservadas = ruta.getString("rutaReservadas");
	
	
	private static final ResourceBundle testAnalizadorLexico = ResourceBundle.getBundle("properties/analizadorLexicoTest");
	//Prueba unitaria del metodo Analizar
	public static final String codigoFuente = testAnalizadorLexico.getString("codigoFuente");
	public static final String valorEsperadoBuenos = testAnalizadorLexico.getString("valorEsperadoBuenos");
	public static final String valorEsperadoError = testAnalizadorLexico.getString("valorEsperadoError");
	
	public static final String lexemaReservada = testAnalizadorLexico.getString("lexemaReservada");
	public static final String valorEsperadoReservada = testAnalizadorLexico.getString("valorEsperadoReservada");
	
	public static final String lexemaSeparador = testAnalizadorLexico.getString("lexemaSeparador");
	public static final String valorEsperadoSeparador = testAnalizadorLexico.getString("valorEsperadoSeparador");
	
	public static final String lexemaEntero = testAnalizadorLexico.getString("lexemaEntero");
	public static final String valorEsperadoEntero = testAnalizadorLexico.getString("valorEsperadoEntero");
	
	public static final String lexemaReal = testAnalizadorLexico.getString("lexemaReal");
	public static final String valorEsperadoReal = testAnalizadorLexico.getString("valorEsperadoReal");
	
	public static final String lexemaClase = testAnalizadorLexico.getString("lexemaClase");
	public static final String valorEsperadoClase = testAnalizadorLexico.getString("valorEsperadoClase");
	
	public static final String lexemaMetodo = testAnalizadorLexico.getString("lexemaMetodo");
	public static final String valorEsperadoMetodo = testAnalizadorLexico.getString("valorEsperadoMetodo");
	
	public static final String lexemaVariable = testAnalizadorLexico.getString("lexemaVariable");
	public static final String valorEsperadoVariable = testAnalizadorLexico.getString("valorEsperadoVariable");
	
	public static final String lexemaMayoreIgual = testAnalizadorLexico.getString("lexemaMayoreIgual");
	public static final String valorEsperadoMayoreIgual = testAnalizadorLexico.getString("valorEsperadoMayoreIgual");
	
	public static final String lexemaMenoreIgual = testAnalizadorLexico.getString("lexemaMenoreIgual");
	public static final String valorEsperadoMenoreIgual = testAnalizadorLexico.getString("valorEsperadoMenoreIgual");
	
	public static final String lexemaIgualeIgual = testAnalizadorLexico.getString("lexemaIgualeIgual");
	public static final String valorEsperadoIgualeIgual = testAnalizadorLexico.getString("valorEsperadoIgualeIgual");
	
	public static final String lexemaTerminal = testAnalizadorLexico.getString("lexemaTerminal");
	public static final String valorEsperadoTerminal = testAnalizadorLexico.getString("valorEsperadoTerminal");
	
	public static final String lexemaAsignacion = testAnalizadorLexico.getString("lexemaAsignacion");
	public static final String valorEsperadoAsignacion = testAnalizadorLexico.getString("valorEsperadoAsignacion");
	
	public static final String lexemaMenor = testAnalizadorLexico.getString("lexemaMenor");
	public static final String valorEsperadoMenor = testAnalizadorLexico.getString("valorEsperadoMenor");
	
	public static final String lexemaMayor = testAnalizadorLexico.getString("lexemaMayor");
	public static final String valorEsperadoMayor = testAnalizadorLexico.getString("valorEsperadoMayor");
	
	public static final String lexemaDivision = testAnalizadorLexico.getString("lexemaDivision");
	public static final String valorEsperadoDivision = testAnalizadorLexico.getString("valorEsperadoDivision");
	
	public static final String lexemaResta = testAnalizadorLexico.getString("lexemaResta");
	public static final String valorEsperadoResta = testAnalizadorLexico.getString("valorEsperadoResta");
	
	public static final String lexemaSuma = testAnalizadorLexico.getString("lexemaSuma");
	public static final String valorEsperadoSuma = testAnalizadorLexico.getString("valorEsperadoSuma");
	
	public static final String lexemaMultiplicacion = testAnalizadorLexico.getString("lexemaMultiplicacion");
	public static final String valorEsperadoMultiplicacion = testAnalizadorLexico.getString("valorEsperadoMultiplicacion");
	
	public static final String lexemaAbreParentesis = testAnalizadorLexico.getString("lexemaAbreParentesis");
	public static final String valorEsperadoAbreParentesis = testAnalizadorLexico.getString("valorEsperadoAbreParentesis");
	
	public static final String lexemaCierraParentesis = testAnalizadorLexico.getString("lexemaCierraParentesis");
	public static final String valorEsperadoCierraParentesis = testAnalizadorLexico.getString("valorEsperadoCierraParentesis");
	
	public static final String lexemaAbreLlave = testAnalizadorLexico.getString("lexemaAbreLlave");
	public static final String valorEsperadoAbreLlave = testAnalizadorLexico.getString("valorEsperadoAbreLlave");
	
	public static final String lexemaCierraLlave = testAnalizadorLexico.getString("lexemaCierraLlave");
	public static final String valorEsperadoCierraLlave = testAnalizadorLexico.getString("valorEsperadoCierraLlave");
	
	public static final String lexemaConjuncion = testAnalizadorLexico.getString("lexemaConjuncion");
	public static final String valorEsperadoConjuncion = testAnalizadorLexico.getString("valorEsperadoConjuncion");
	
	public static final String lexemaDisyuncion = testAnalizadorLexico.getString("lexemaDisyuncion");
	public static final String valorEsperadoDisyuncion = testAnalizadorLexico.getString("valorEsperadoDisyuncion");
	
	public static final String lexemaNegacion = testAnalizadorLexico.getString("lexemaNegacion");
	public static final String valorEsperadoNegacion = testAnalizadorLexico.getString("valorEsperadoNegacion");
	
	public static final String lexemaComentario = testAnalizadorLexico.getString("lexemaComentario");
	public static final String valorEsperadoComentario = testAnalizadorLexico.getString("valorEsperadoComentario");
	
	public static final String lexemaCadena = testAnalizadorLexico.getString("lexemaCadena");
	public static final String valorEsperadoCadena = testAnalizadorLexico.getString("valorEsperadoCadena");
	
	public static final String lexemaBacktraking = testAnalizadorLexico.getString("lexemaBacktraking");
	public static final String filaLexema = testAnalizadorLexico.getString("filaLexema");
	public static final String columnaLexema = testAnalizadorLexico.getString("columnaLexema");
	public static final String posicionActual = testAnalizadorLexico.getString("posicionActual");
	public static final String filaLexemaEsperada = testAnalizadorLexico.getString("filaLexema");
	public static final String columnaLexemaEsperada = testAnalizadorLexico.getString("columnaLexema");
	public static final String posicionActualEsperada = testAnalizadorLexico.getString("posicionActual");
	public static final String caracterActualEsperado = testAnalizadorLexico.getString("caracterActualEsperado");

	public static final String lexemaSgteCaracter = testAnalizadorLexico.getString("lexemaSgteCaracter");
	public static final String posicionCaracterActual = testAnalizadorLexico.getString("posicionCaracterActual");
	public static final String caracterSgteEsperado = testAnalizadorLexico.getString("caracterSgteEsperado");
	
	public static final String lexemaAAlmacenar = testAnalizadorLexico.getString("lexemaAAlmacenar");
	public static final String tamanioTablaDeSimbolosEsperado = testAnalizadorLexico.getString("tamanioTablaDeSimbolosEsperado");
	public static final String tipoLexemaAAlmacenar = testAnalizadorLexico.getString("tipoLexemaAAlmacenar");
	
	public static final String errorAAlmacenar = testAnalizadorLexico.getString("errorAAlmacenar");
	public static final String tamanioTablaErrores = testAnalizadorLexico.getString("tamanioTablaErrores");
	
	public static final String codigoFuenteMostrarTokens = testAnalizadorLexico.getString("codigoFuenteMostrarTokens");
	public static final String cantidadTokensEsperados = testAnalizadorLexico.getString("cantidadTokensEsperados");
	
	public static final String codigoFuenteMostrarTokensError = testAnalizadorLexico.getString("codigoFuenteMostrarTokensError");
	public static final String cantidadTokensErrorEsperados = testAnalizadorLexico.getString("cantidadTokensErrorEsperados");
	
	public static final String lexemaVerificarTamanio = testAnalizadorLexico.getString("lexemaVerificarTamanio");
	public static final String TamanioLimite = testAnalizadorLexico.getString("TamanioLimite");
	public static final String valorEsperadoAceptacionLexema = testAnalizadorLexico.getString("valorEsperadoAceptacionLexema");
	
	public static final String cantidadEsperadaPalabrasReservadas = testAnalizadorLexico.getString("cantidadEsperadaPalabrasReservadas");
	
	public static final String rutaPReservadas = testAnalizadorLexico.getString("rutaPReservadas");
	public static final String cantReservadasEsperadas = testAnalizadorLexico.getString("cantReservadasEsperadas");
	
	public static final String rutaCodigo = testAnalizadorLexico.getString("rutaCodigo");
	public static final String cantidadLexemas = testAnalizadorLexico.getString("cantidadLexemas");
	
	
	private static final ResourceBundle testSimboloLexico = ResourceBundle.getBundle("properties/simboloLexicoTest");
	
	public static final String lexemaSL = testSimboloLexico.getString("lexemaSL");
	public static final String tipoSL = testSimboloLexico.getString("tipoSL");
	public static final String filaSL = testSimboloLexico.getString("filaSL");
	public static final String columnaSL = testSimboloLexico.getString("columnaSL");
	
	public static final String nuevoLexema = testSimboloLexico.getString("nuevoLexema");
	
	public static final String nuevoTipo = testSimboloLexico.getString("nuevoTipo");
	
	public static final String nuevaFila = testSimboloLexico.getString("nuevaFila");
	
	public static final String nuevaColumna = testSimboloLexico.getString("nuevaColumna");
	
	public static final String imgEntero = ruta.getString("imgEntero");
	public static final String imgReal = ruta.getString("imgReal");
	public static final String imgIdClase = ruta.getString("imgIdClase");
	public static final String imgIdMetodo = ruta.getString("imgIdMetodo");
	public static final String imgIdVariable = ruta.getString("imgIdVariable");
	public static final String imgBreak = ruta.getString("imgBreak");
	public static final String imgClase = ruta.getString("imgClase");
	public static final String imgImportar = ruta.getString("imgImportar");
	public static final String imgPaquete = ruta.getString("imgPaquete");
	public static final String imgPrivate = ruta.getString("imgPrivate");
	public static final String imgPublic = ruta.getString("imgPublic");
	public static final String imgResEntero = ruta.getString("imgResEntero");
	public static final String imgResFor = ruta.getString("imgResFor");
	public static final String imgResReal = ruta.getString("imgResReal");
	public static final String imgResReturn = ruta.getString("imgResReturn");
	public static final String imgResWhile = ruta.getString("imgResWhile");
	public static final String imgDivision = ruta.getString("imgDivision");
	public static final String imgMultiplicacion = ruta.getString("imgMultiplicacion");
	public static final String imgResta = ruta.getString("imgResta");
	public static final String imgSuma = ruta.getString("imgSuma");
	public static final String imgIgualIgual = ruta.getString("imgIgualIgual");
	public static final String imgMayor = ruta.getString("imgMayor");
	public static final String imgMayorIgual = ruta.getString("imgMayorIgual");
	public static final String imgMenor = ruta.getString("imgMenor");
	public static final String imgMenorIgual = ruta.getString("imgMenorIgual");
	public static final String imgO = ruta.getString("imgO");
	public static final String imgY = ruta.getString("imgY");
	public static final String imgAsignacion = ruta.getString("imgAsignacion");
	public static final String imgAbrirParentesis = ruta.getString("imgAbrirParentesis");
	public static final String imgCerrarParentesis = ruta.getString("imgCerrarParentesis");
	public static final String imgAbrirLlaves = ruta.getString("imgAbrirLlaves");
	public static final String imgCerrarLlaves = ruta.getString("imgCerrarLlaves");
	public static final String imgTerminador = ruta.getString("imgTerminador");
	public static final String imgComentario = ruta.getString("imgComentario");
	public static final String imgCadena = ruta.getString("imgCadena");
	
	
	// ANALIZADOR SINTACTICO
	public static final String unidadCompilacion  = properties.getString("unidadCompilacion");
	public static final String when = properties.getString("when");
	public static final String retorno = properties.getString("retorno");
	public static final String operacion = properties.getString("operacion");
	public static final String invocacionMetodo = properties.getString("invocacionMetodo");
	public static final String argumentos = properties.getString("argumentos");
	public static final String expresionMatematica = properties.getString("expresionMatematica");
	public static final String operaciones = properties.getString("operaciones");
	public static final String expresionComparacion = properties.getString("expresionComparacion");
	public static final String dosPuntos = properties.getString("dosPuntos");
	public static final String declaracionVariable = properties.getString("declaracionVariable");
	public static final String declaracionMetodo = properties.getString("declaracionMetodo");
	public static final String cuerpoCiclo = properties.getString("cuerpoCiclo");
	public static final String listaSentencias = properties.getString("listaSentencias");
	public static final String cuerpoMetodo = properties.getString("cuerpoMetodo");
	public static final String cuerpoClase = properties.getString("cuerpoClase");
	public static final String listaDeclaraciones = properties.getString("listaDeclaraciones");
	public static final String listaAsignaciones = properties.getString("listaAsignaciones");
	public static final String listaMetodos = properties.getString("listaMetodos");
	public static final String declaracionClase = properties.getString("declaracionClase");
	public static final String cicloWhile = properties.getString("cicloWhile");
	public static final String asignacion = properties.getString("asignacion");
	public static final String argumento = properties.getString("argumento");
	public static final String cicloFor = properties.getString("cicloFor");
	
	// Reservadas
	public static final String publico = properties.getString("publico");
	public static final String privado = properties.getString("privado");	
	public static final String entero = properties.getString("entero");
	public static final String real = properties.getString("real");
	public static final String texto = properties.getString("texto");
	public static final String retornar = properties.getString("retornar");
	
	// Errores
	public static final String errorIdentificador1 = properties.getString("errorIdentificador1");
	public static final String errorIdentificador2 = properties.getString("errorIdentificador2");
	public static final String errorNombreParametro = properties.getString("errorNombreParametro");
	public static final String errorFaltaTipoDato = properties.getString("errorFaltaTipoDato");
	public static final String errorFaltaSeparador = properties.getString("errorFaltaSeparador");
	public static final String errorFaltaModificadorAcceso = properties.getString("errorFaltaModificadorAcceso");
	public static final String errorFaltaIdClase = properties.getString("errorFaltaIdClase");
	public static final String errorFaltaCuerpoClase = properties.getString("errorFaltaCuerpoClase");
	public static final String errorFaltaVariables = properties.getString("errorFaltaVariables");
	public static final String puntoyComa = properties.getString("puntoyComa");
	public static final String errorOperadorAsignacion = properties.getString("errorOperadorAsignacion");
	public static final String errorFaltaValor = properties.getString("errorFaltaValor");
	public static final String errorFaltaValorComparar = properties.getString("errorFaltaValorComparar");
	public static final String errorFaltaOperadorRelacional = properties.getString("errorFaltaOperadorRelacional");
	public static final String errorFaltaValorOperacion = properties.getString("errorFaltaValorOperacion");
	public static final String errorFaltaPuntoyComa = properties.getString("errorFaltaPuntoyComa");
	public static final String errorFaltaTipoRetorno = properties.getString("errorFaltaTipoRetorno");
	public static final String errorFaltaCuerpoMetodo = properties.getString("errorFaltaCuerpoMetodo");
	public static final String errorFaltaAbreParentesis = properties.getString("errorFaltaAbreParentesis");
	public static final String errorFaltaCierreParentesis = properties.getString("errorFaltaCierreParentesis");
	public static final String errorFaltaIdMetodo = properties.getString("errorFaltaIdMetodo");
	public static final String errorFaltaIdVariable = properties.getString("errorFaltaIdVariable");
	public static final String errorFaltaCierreCuerpoMetodo = properties.getString("errorFaltaCierreCuerpoMetodo");
	public static final String errorFaltaRetornoMetodo = properties.getString("errorFaltaRetornoMetodo");	
	
}
