package analizadorSintactico;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
 *
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz
 * 
 *  Esta clase permite analizar la sintaxis de una lista de tokens 
 *  pasados por el analizador lexico
 */
public class AnalizadorSintactico {
	/**
	 * Variables globales de la clase AnalizadorSintactico
	 */
	// arrayList que contiene los simbolos lexicos reconocidos por el analizador lexico
	private ArrayList<SimboloLexico> listaSimbolosLexicos; 
	//Arraylist que almacenara los errores sintacticos
	private ArrayList<ErrorSintactico> listaErroresSintacticos;
	//variable que almacena el simbolo lexico actual
	private SimboloLexico tokenActual;
	//variable que contiene la pocision actual en la lista de simbolos lexicos
	private int indice;
	//almacena la unidad de compilacion
	private UnidadCompilacion miUnidadDeCompilacion;

	/**
	 * Constructor de la clase AnalizadorSintactico
	 * 
	 * @param listaSimbolos
	 */
	public AnalizadorSintactico(ArrayList<SimboloLexico> listaSimbolos) {
		this.listaSimbolosLexicos = listaSimbolos;
		listaErroresSintacticos = new ArrayList<ErrorSintactico>();
		indice = 0;
		tokenActual = listaSimbolosLexicos.get(indice);
		miUnidadDeCompilacion = esUnidadDeCompilacion();
	}

	/**
	 * Obtiene el siguiente token de la lista de simbolos lexicos
	 */
	public void darSiguienteToken() {
		if (indice == listaSimbolosLexicos.size() - 1) {
			return;

		} else {
			indice++;
			tokenActual = listaSimbolosLexicos.get(indice);
		}
	}

	/**
	 * Realiza Backtracking - devuelve la posicion y el token anterior
	 * 
	 * @param posBT
	 */
	public void realizarBactracking(int posBT) {
		indice = posBT;
		tokenActual = listaSimbolosLexicos.get(indice);
	}

	/**
	 * Almacena un error sintactico
	 * 
	 * @param msn
	 * @param fila
	 * @param columna
	 */
	public void reportarError(String msn, int fila, int columna) {
		listaErroresSintacticos.add(new ErrorSintactico(msn, fila, columna));
	}

	/**
	 * Indica si cierto conjunto de tokens pertenecen a la categoria sintactica
	 * Argumento GIC:<Argumento>::=<TipoDato> identificadorVariable
	 * 
	 * @return parametro
	 */
	public Argumento esArgumento() {
		//almacena la pocision a la cual se va a devolver
		int posBacktraking = indice;
		//variables necesarias para conformar un argumento
		SimboloLexico tipoDato = null;
		SimboloLexico identificadorVariable = null;

		tipoDato = esTipoDato();


		if(tipoDato!=null){

			if (tokenActual.getTipo().equals(Configuracion.IdVariable)) {
				identificadorVariable = tokenActual;
				darSiguienteToken();
				return new Argumento(tipoDato, identificadorVariable);
			} else {
				if (tokenActual.getTipo().equals(Configuracion.IdMetodo)) {

					reportarError(
							Configuracion.errorIdentificador1,
							tokenActual.getFila(), tokenActual.getColumna());
					return new Argumento(tipoDato, identificadorVariable);

				} else if (tokenActual.getTipo().equals(Configuracion.IdClase)) {
					reportarError(
							Configuracion.errorIdentificador2,
							tokenActual.getFila(), tokenActual.getColumna());
					return new Argumento(tipoDato, identificadorVariable);

				} else {
					reportarError(Configuracion.errorNombreParametro,
							tokenActual.getFila(), tokenActual.getColumna());
					return new Argumento(tipoDato, identificadorVariable);
				}

			}
		}
		else
			if (tokenActual.getTipo().equals(Configuracion.IdVariable)) {
				reportarError(Configuracion.errorFaltaTipoDato, tokenActual.getFila(), tokenActual.getColumna());
				identificadorVariable = tokenActual;
				darSiguienteToken();
				return new Argumento(tipoDato, identificadorVariable);
			}
		realizarBactracking(posBacktraking);
		return null;

	}

	/**
	 * Indica si cierto conjunto de tokens pertenecen a la categoria sintactica
	 * Argumentos GIC: <Argumentos> ::= <Argumento> [ "," <Argumentos> ]
	 * 
	 * @return listaArgumentos
	 */
	public ArrayList<Argumento> esListaArgumentos() {
		ArrayList<Argumento> listaArgumentos = new ArrayList<Argumento>();

		Argumento argumento = esArgumento();

		while (argumento != null) {
			listaArgumentos.add(argumento);

			if (tokenActual.getTipo().equals(Configuracion.separador)) {
				darSiguienteToken();

				argumento = esArgumento();
			}
			else{
				if(tokenActual.getTipo().equals(Configuracion.IdVariable)){

					reportarError(Configuracion.errorFaltaSeparador,tokenActual.getFila() , tokenActual.getColumna());
					break;
				}
			}
		}

		return listaArgumentos;
	}

	/**
	 * Indica si cierto conjunto de tokens conforman La Unidad de Compilaci�n
	 * GIC: <UnidadDeCompilacion> ::=<Clase>
	 * 
	 * @return unidadCompilacion
	 */
	public UnidadCompilacion esUnidadDeCompilacion() {

		Clase clase = esClase();

		return new UnidadCompilacion(clase);
	}

	/**
	 * indica si cierto conjunto de tokens conforman la clase
	 * GIC:<Clase> ::= <ModificadorAcceso> <IdClase> <CuerpoClase>
	 * 
	 * @return
	 */

	public Clase esClase(){

		SimboloLexico modificadorAcceso = null;
		SimboloLexico idClase = null;
		CuerpoClase cuerpoClase = null;


		modificadorAcceso = esModificadorAcceso();

		if(modificadorAcceso == null){

			reportarError(Configuracion.errorFaltaModificadorAcceso,tokenActual.getFila(), tokenActual.getColumna());

		}


		if(tokenActual.getTipo().equals(Configuracion.IdClase)){
			idClase = tokenActual;
			darSiguienteToken();
		}

		if(modificadorAcceso==null & idClase==null){
			darSiguienteToken();

			if(tokenActual.getTipo().equals(Configuracion.IdClase)){

				idClase = tokenActual;
				darSiguienteToken();	
			}
			else{
				reportarError(Configuracion.errorFaltaIdClase,tokenActual.getFila(), tokenActual.getColumna());

			}
		}
		else{
			if(idClase==null){
				reportarError(Configuracion.errorFaltaIdClase,tokenActual.getFila(), tokenActual.getColumna());
			}
		}

		cuerpoClase = esCuerpoClase(); 
		if(cuerpoClase != null){

			return new Clase(modificadorAcceso, idClase, cuerpoClase);
		}
		else{
			reportarError(Configuracion.errorFaltaCuerpoClase,tokenActual.getFila(), tokenActual.getColumna());

		}

		return new Clase(modificadorAcceso, idClase, cuerpoClase);
	}

	/**
	 * indica si cierto conjunto de tokens conforman el cuerpo de la clase
	 * GIC: <CuerpoClase> ::= �{� [<ListaDeclaraciones>] [ListaAsignaciones] [<ListaMetodos>] �}�

	 * 
	 * @return
	 */
	public CuerpoClase esCuerpoClase(){

		SimboloLexico llaveAbre = null;
		SimboloLexico llaveCierra = null;
		ArrayList<DeclaracionVariable> listaDeclaraciones = null;
		ArrayList<Asignacion> listaAsignaciones = null;
		ArrayList<DeclaracionMetodo>  listaMetodos = null;

		if(tokenActual.getTipo().equals(Configuracion.AbrirLlaves)){
			llaveAbre = tokenActual;
			darSiguienteToken();


			listaDeclaraciones = esListaDeclaraciones();
			listaAsignaciones = esListaAsignaciones();
			listaMetodos = esListaMetodos();

			if(tokenActual.getTipo().equals(Configuracion.CerrarLLaves)){
				llaveCierra = tokenActual;
				return new CuerpoClase(llaveAbre,listaDeclaraciones, listaAsignaciones, listaMetodos,llaveCierra);
			}
			else{
				reportarError(Configuracion.errorFaltaCuerpoClase, tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(Configuracion.puntoyComa);
				return new CuerpoClase(llaveAbre, listaDeclaraciones, listaAsignaciones, listaMetodos, llaveCierra);
			}
		}
		else{
			return null;
		}

	}

	/**
	 * indica si cierto conjunto de tokens conforman una lista de declaraciones
	 * GIC: <ListaDeclaraciones> ::= <DeclaracionVariable> [<ListaDeclaraciones>] 
	 * 
	 * @return
	 */
	public ArrayList<DeclaracionVariable> esListaDeclaraciones(){

		ArrayList<DeclaracionVariable> listaDeclaraciones = new ArrayList<DeclaracionVariable>();
		DeclaracionVariable declaracionVariable = esDeclaracionVariable();

		while(declaracionVariable != null){
			listaDeclaraciones.add(declaracionVariable);
			declaracionVariable = esDeclaracionVariable();
		}

		return listaDeclaraciones; 
	}

	/**
	 * indica si cierto conjunto de tokens conforman una lista de Asignaciones
	 * GIC: <ListaAsignaciones> ::= <Asignacion> [<ListaAsignaciones>]
	 *
	 * @return
	 */
	public ArrayList<Asignacion> esListaAsignaciones(){

		ArrayList<Asignacion> listaAsignacion = new ArrayList<Asignacion>();
		Asignacion asignacion = esAsignacion();

		while(asignacion != null){

			listaAsignacion.add(asignacion);

			if(tokenActual.getTipo().equals(Configuracion.FinSentencia)){

				darSiguienteToken();
				asignacion = esAsignacion(); 
			}
			else{
				reportarError(Configuracion.errorFaltaPuntoyComa, tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(Configuracion.puntoyComa);
				return listaAsignacion;
			}

		}

		return listaAsignacion;

	}

	/**
	 * indica si cierto conjunto de tokens conforman una lista de metodos
	 * GIC:<Metodos> ::= <DeclaracionMetodo> [<Metodos>]
	 * 
	 * @return
	 */
	public ArrayList<DeclaracionMetodo> esListaMetodos(){

		ArrayList<DeclaracionMetodo> listaMetodos = new ArrayList<DeclaracionMetodo>();
		DeclaracionMetodo declaracionMetodo = esDeclaracionMetodo();
		while (declaracionMetodo != null){
			listaMetodos.add(declaracionMetodo);
			declaracionMetodo = esDeclaracionMetodo();
		}

		return listaMetodos;
	}

	/**
	 * indica si cierto conjunto de tokens conforman la declaracion de un metodo
	 * GIC:<DeclaracionMetodo> ::= <ModificadorAcceso> <TipoDato> <IdMetodo> �(� [<Argumentos>] �)�  <CuerpoMetodo> 
	 * 
	 * @return
	 */
	public DeclaracionMetodo esDeclaracionMetodo(){
		int posBacktraking = indice;
		SimboloLexico modificadorAcceso = null;
		SimboloLexico tipoDato = null;
		SimboloLexico idMetodo = null;
		ArrayList<Argumento> argumentos = null;
		SimboloLexico aperturaParentesis = null;
		SimboloLexico cierreParentesis = null;
		CuerpoMetodo cuerpoMetodo = null;

		modificadorAcceso = esModificadorAcceso();

		if(modificadorAcceso == null){
			tipoDato = esTipoDato();
			if(tipoDato==null){
				if(tokenActual.getTipo().equals(Configuracion.IdMetodo)){
					idMetodo = tokenActual;
					reportarError(Configuracion.errorFaltaModificadorAcceso, tokenActual.getFila(), tokenActual.getColumna());
					reportarError(Configuracion.errorFaltaTipoDato, tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);

				}
				else{
					return null;
				}
			}
			else{
				if(tokenActual.getTipo().equals(Configuracion.IdMetodo)){
					idMetodo = tokenActual;
					reportarError(Configuracion.errorFaltaModificadorAcceso, tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);
				}
				else{
					realizarBactracking(posBacktraking);
					return null;
				}
			}
		}
		else{
			tipoDato = esTipoDato();
			if(tipoDato==null){
				if(tokenActual.getTipo().equals(Configuracion.IdMetodo)){
					reportarError(Configuracion.errorFaltaTipoRetorno, tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);
				}
				else{

					reportarError(Configuracion.errorFaltaTipoRetorno, tokenActual.getFila(), tokenActual.getColumna());
				    modoPanico(Configuracion.puntoyComa);
				    return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);

					reportarError("falta el tipo de dato de retorno del metodo",tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(";");
					return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);

				}

			}
			if(tokenActual.getTipo().equals(Configuracion.IdMetodo)){
				idMetodo = tokenActual;
				darSiguienteToken();

				if(tokenActual.getTipo().equals(Configuracion.AperturaParentesis)){
					aperturaParentesis = tokenActual;
					darSiguienteToken();

					argumentos = esListaArgumentos();
					if(tokenActual.getTipo().equals(Configuracion.CierreParentesis)){
						cierreParentesis = tokenActual;
						darSiguienteToken();

						cuerpoMetodo = esCuerpoMetodo();

						if(cuerpoMetodo != null ){
							darSiguienteToken();
							return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);
						}
						else{
							reportarError(Configuracion.errorFaltaCuerpoMetodo, tokenActual.getFila(), tokenActual.getColumna());
							modoPanico(Configuracion.puntoyComa);
							return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);
						}

					}
					else{
						reportarError(Configuracion.errorFaltaCierreParentesis, tokenActual.getFila(),tokenActual.getColumna());
						modoPanico(Configuracion.puntoyComa);
						return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);
					} 
				}
				else{
					reportarError(Configuracion.errorFaltaAbreParentesis, tokenActual.getFila(),tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);
				}
			}
			else{
				reportarError(Configuracion.errorFaltaIdMetodo, tokenActual.getFila(),tokenActual.getColumna());
				modoPanico(Configuracion.puntoyComa);
				return new DeclaracionMetodo(modificadorAcceso, tipoDato, idMetodo, aperturaParentesis, argumentos, cierreParentesis, cuerpoMetodo);
			}
		}

	}

	public CuerpoMetodo esCuerpoMetodo(){

		int posBacktraking = indice;
		SimboloLexico llaveAbre = null;
		SimboloLexico llaveCierre = null;
		ArrayList<Sentencia> sentencias = null;
		Retorno retorno = null;

		if(tokenActual.getTipo().equals(Configuracion.AbrirLlaves)){
			llaveAbre = tokenActual;
			darSiguienteToken();

			sentencias = esListaSentencias();

			retorno = esRetorno();



			if(retorno!=null){
				if(tokenActual.getTipo().equals(Configuracion.CerrarLLaves)){
					llaveCierre = tokenActual;
					return new CuerpoMetodo(llaveAbre, sentencias, retorno, llaveCierre);

				}
				else{
					reportarError("Falta cerrar el cuerpo del metodo", tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new CuerpoMetodo(llaveAbre, sentencias, retorno, llaveCierre);
				}
			}
			else{
				if(tokenActual.getTipo().equals(Configuracion.CerrarLLaves)){
					llaveCierre = tokenActual;
					reportarError("falta el retorno del metodo", tokenActual.getFila(), tokenActual.getColumna());
					darSiguienteToken();
					return new CuerpoMetodo(llaveAbre, sentencias, retorno, llaveCierre);
				}
				else{
					reportarError("falta el retorno del metodo", tokenActual.getFila(), tokenActual.getColumna());
					reportarError("falta cerrar el cuerpo del metodo", tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new CuerpoMetodo(llaveAbre, sentencias, retorno, llaveCierre);
				}
			}

		}
		else{
			return null;
		}

	}

	public ArrayList<Sentencia> esListaSentencias(){

		ArrayList<Sentencia> listaSentencias = new ArrayList<Sentencia>();
		Sentencia sentencia = esSentencia();

		while(sentencia!=null)
		{
			listaSentencias.add(sentencia);
			sentencia = esSentencia();
		}

		return listaSentencias;

	}

	public Sentencia esSentencia(){

		Sentencia sentencia = null;

		sentencia = esDeclaracionVariable();
		if(sentencia != null){

			return sentencia;  
		}

		sentencia = esAsignacion();
		if(sentencia != null){

			return sentencia;  
		}

		return sentencia;

	}
	/**
	 * GIC: �<SEND>� <idVeriable> �;�
	 * @return
	 */

	public Retorno esRetorno(){

		SimboloLexico retornar = null;
		SimboloLexico idVariable = null;
		SimboloLexico terminal = null;

		if(tokenActual.getLexema().equals("<SEND>")){
			retornar = tokenActual;
			darSiguienteToken();

			if(tokenActual.getTipo().equals(Configuracion.IdVariable)){
				idVariable = tokenActual;
				darSiguienteToken();

				if(tokenActual.getTipo().equals(Configuracion.FinSentencia)){
					terminal = tokenActual;
					darSiguienteToken();
					return new Retorno(retornar, idVariable, terminal);
				}
				else{
					reportarError("falta el ;",tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new Retorno(retornar, idVariable, terminal);
				}
			}
			else
			{
				if(tokenActual.getTipo().equals(Configuracion.FinSentencia)){
					terminal = tokenActual;
					reportarError("falta el identificador de variable", tokenActual.getFila(), tokenActual.getColumna());
					darSiguienteToken();
					return new Retorno(retornar, idVariable, terminal);

				}
				else{
					reportarError("falta el identificador de variable", tokenActual.getFila(), tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					return new Retorno(retornar, idVariable, terminal);
				}
			}
		}
		else{
			return null;
		}


	}

	/**
	 * indica si cierto conjunto de tokens conforman la declaracion de una variable
	 * GIC:<DeclaracionVariable> ::= <TipoDato> <Variables> �;�
	 * 
	 * @return
	 */
	public DeclaracionVariable esDeclaracionVariable(){
		int posBacktraking = indice;
		SimboloLexico tipoDato = null;
		ArrayList<SimboloLexico> idVariables = null;
		SimboloLexico terminal = null;

		tipoDato = esTipoDato();
		if(tipoDato== null){
			return null;
		}
		else{
			idVariables = esVariables();
			if(idVariables.size()==0){
				if(tokenActual.getTipo().equals(Configuracion.FinSentencia)){
					terminal = tokenActual;
					reportarError(Configuracion.errorFaltaVariables,tokenActual.getFila(), tokenActual.getColumna());
					darSiguienteToken();
					return new DeclaracionVariable(tipoDato,idVariables,terminal);
				}
				else{
					realizarBactracking(posBacktraking);
					return null;
				}
			}
			if(tokenActual.getTipo().equals(Configuracion.FinSentencia)){
				terminal = tokenActual;
				darSiguienteToken();
				return  new DeclaracionVariable(tipoDato, idVariables, terminal);
			}
			else{
				modoPanico(Configuracion.puntoyComa);
				return new DeclaracionVariable(tipoDato, idVariables, terminal);

			}
		}

	}

	/**
	 *Indica si cierto conjunto de tokens pertenecen a la categoria sintactica Lista de variables 
	 *  GIC: <Variables> ::= <IdVariable> [�,� <Variables>]
	 *  
	 * @return
	 */
	public ArrayList<SimboloLexico> esVariables(){

		ArrayList<SimboloLexico> idVariables = new ArrayList<SimboloLexico>();
		SimboloLexico idVariable = esIdVariable();

		while(idVariable != null){

			idVariables.add(idVariable);

			if(tokenActual.getTipo().equals(Configuracion.separador)){
				darSiguienteToken();
				idVariable = esIdVariable();
			}
			else{
				if(tokenActual.getTipo().equals(Configuracion.IdVariable)){

					reportarError(Configuracion.errorFaltaSeparador,tokenActual.getFila() , tokenActual.getColumna());
					modoPanico(Configuracion.puntoyComa);
					break;
				}
				else{
					break;
				}

			}
		}

		return idVariables;

	}

	/**
	 * indica si el token es un identificador de variable
	 * 
	 * 
	 * @return
	 */
	public SimboloLexico esIdVariable(){

		SimboloLexico idVariable = null;

		if(tokenActual.getTipo().equals(Configuracion.IdVariable)){
			idVariable = tokenActual;
			darSiguienteToken();

		}

		return idVariable;

	}

	/**
	 *Indica si cierto conjunto de tokens pertenecen a la categoria sintactica de asignaciones 
	 * GIC: <Asignacion> ::= <IdVariable> �=� <ExpresioneComparacion> |<IdVariable> �=� <ExpresioneMatematica>| <idVariable> �=� <Valor> | <idVariable> �=� <idVariable>
	 * 
	 * @return
	 */
	public Asignacion esAsignacion(){


		SimboloLexico idVariable = null;
		SimboloLexico idVariable2 = null;
		SimboloLexico operadorAsignacion = null;
		ExpresionComparacion expresionComparacion = null;
		ExpresionMatematica expresionMatematica = null;

		if(tokenActual.getTipo().equals(Configuracion.IdVariable)){
			idVariable = tokenActual;
			darSiguienteToken(); 
		}
		else
		{
			return null;
		}

		if(tokenActual.getTipo().equals(Configuracion.OperadorAsignacion)){
			operadorAsignacion = tokenActual;
			darSiguienteToken();
		}
		else
		{
			reportarError(Configuracion.errorOperadorAsignacion, tokenActual.getFila(), tokenActual.getColumna());
		}


		expresionComparacion = esExpresionComparacion();
		if(expresionComparacion != null){

			return new Asignacion(idVariable, operadorAsignacion, expresionComparacion);
		}
		expresionMatematica = esExpresionMatematica();
		if(expresionMatematica != null){

			return new Asignacion(idVariable, operadorAsignacion, expresionMatematica);
		}

		if(tokenActual.getTipo().equals(Configuracion.IdVariable)){
			idVariable2 = tokenActual;
			darSiguienteToken();
			return new Asignacion(idVariable, operadorAsignacion, idVariable2);

		}

		if(tokenActual.getTipo().equals(Configuracion.Entero)){
			idVariable2 = tokenActual;
			darSiguienteToken();
			return new Asignacion(idVariable, operadorAsignacion, idVariable2);
		}

		if(tokenActual.getTipo().equals(Configuracion.Real)){
			idVariable2 = tokenActual;
			darSiguienteToken();
			return new Asignacion(idVariable, operadorAsignacion, idVariable2);
		}


		reportarError(Configuracion.errorFaltaValor, tokenActual.getFila(), tokenActual.getColumna());
		modoPanico(Configuracion.puntoyComa);
		return new Asignacion(idVariable, operadorAsignacion, idVariable2 );
	}

	/**
	 * Indica si cierto conjunto de tokens pertenecen a la categoria sintactica ExprecionComparacion
	 * GIC: <ExpresionComparacion> ::= <IdVariable> <OperadorComparacion> <IdVariable> | <IdVariable> <OperadorComparacion> <Valor> | <Valor> <OperadorComparacion> <Valor> | <Valor> <OperadorComparacion> <IdVariable>
	 * 
	 * @return
	 */
	public ExpresionComparacion esExpresionComparacion(){
		int posBacktraking = indice;
		SimboloLexico idVariable = null;
		SimboloLexico operadorComparacion = null;
		SimboloLexico idVariable2 = null;


		if(tokenActual.getTipo().equals(Configuracion.IdVariable) ||tokenActual.getTipo().equals(Configuracion.Entero) || tokenActual.getTipo().equals(Configuracion.Real) ){
			idVariable = tokenActual;
			darSiguienteToken();
		}
		else{

			if(tokenActual.getTipo().equals(Configuracion.OperadorRelacional)){
				reportarError(Configuracion.errorFaltaValorComparar, tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(Configuracion.puntoyComa);
				return new ExpresionComparacion(idVariable, operadorComparacion, idVariable);

			}
			else{

				return null;
			}

		}

		if(tokenActual.getTipo().equals(Configuracion.OperadorRelacional)){

			operadorComparacion = tokenActual;
			darSiguienteToken();

		}
		else{
			if(tokenActual.getTipo().equals(Configuracion.IdVariable) || tokenActual.getTipo().equals(Configuracion.Entero) || tokenActual.getTipo().equals(Configuracion.Real)){
				reportarError(Configuracion.errorFaltaOperadorRelacional, tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(Configuracion.puntoyComa);
				return new ExpresionComparacion(idVariable, operadorComparacion, idVariable2);
			}else{
				realizarBactracking(posBacktraking);
				return null;
			}
		}

		if(tokenActual.getTipo().equals(Configuracion.IdVariable) || tokenActual.getTipo().equals(Configuracion.Entero) || tokenActual.getTipo().equals(Configuracion.Real)){
			idVariable2 = tokenActual;
			return new ExpresionComparacion(idVariable, operadorComparacion, idVariable2);
		}

		reportarError(Configuracion.errorFaltaValorComparar, tokenActual.getFila(), tokenActual.getColumna());
		modoPanico(Configuracion.puntoyComa);
		return new ExpresionComparacion(idVariable, operadorComparacion, idVariable2);

	}

	/**
	 *Indica si cierto conjunto de tokens pertenecen a la categoria sintactica ExprecionMatematica 
	 *GIC:<ExprecionMatematica> ::= <IdVariable> <Operacion> | <valor> <Operacion> 
	 * 
	 * @return
	 */
	public ExpresionMatematica esExpresionMatematica(){
		int posBacktraking = indice;
		SimboloLexico idVariable = null;
		ArrayList<Operacion> operaciones = null;

		if(tokenActual.getTipo().equals(Configuracion.IdVariable) || tokenActual.getTipo().equals(Configuracion.Real)|| tokenActual.getTipo().equals(Configuracion.Entero)){
			idVariable = tokenActual;
			darSiguienteToken();
		}
		else{
			operaciones = esOperaciones();
			if(operaciones.size()>0){
				reportarError(Configuracion.errorFaltaValorOperacion, tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(Configuracion.puntoyComa);
				return new ExpresionMatematica(idVariable, operaciones);
			}
			else{
				return null;
			}
		}

		operaciones = esOperaciones();

		if(operaciones.size()>0){
			//
			return new ExpresionMatematica(idVariable, operaciones);
		}else{

			realizarBactracking(posBacktraking);
			return null;
		}

	}

	/**
	 * Indica si cierto conjunto de tokens pertenecen a la categoria sintactica de operaciones
	 * GIC: <Operacion> ::= <OperadorMatematico> <IdVariable> | <OperadorMatematico> <valor> | <OperadorMatematico> <IdVariable> <Operacion> | <OperadorMatematico> <valor> <Operacion>
	 * 
	 * @return
	 */
	public ArrayList<Operacion> esOperaciones(){

		ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
		Operacion operacion = esOperacion();

		while(operacion != null){

			operaciones.add(operacion);
			operacion = esOperacion();
		}
		return operaciones;
	}

	/**
	 * indica si el token actual es una operacion
	 * @return
	 */
	public Operacion esOperacion(){

		SimboloLexico operadorMatematico = null;
		SimboloLexico idVariable = null;


		if(tokenActual.getTipo().equals(Configuracion.OperadorMatematico)){
			operadorMatematico = tokenActual;
			darSiguienteToken();
		}
		else{
			return null;
		}

		if(tokenActual.getTipo().equals(Configuracion.IdVariable) || tokenActual.getTipo().equals(Configuracion.Real) || tokenActual.getTipo().equals(Configuracion.Entero) ) {
			idVariable = tokenActual;
			darSiguienteToken();
			return new Operacion(operadorMatematico,idVariable);
		}
		else{
			reportarError(Configuracion.errorFaltaIdVariable, tokenActual.getFila(), tokenActual.getColumna());
			modoPanico(Configuracion.puntoyComa);
			return new Operacion(operadorMatematico, idVariable);
		}


	}

	/**
	 * metodo que indica si el token actual es un modoficador de acceso
	 * @return
	 */

	private SimboloLexico esModificadorAcceso(){

		SimboloLexico modificadorAcceso = null;

		if(tokenActual.getLexema().equals(Configuracion.publico) || tokenActual.getLexema().equals(Configuracion.privado) ){

			modificadorAcceso = tokenActual;
			darSiguienteToken();
			return modificadorAcceso;

		}
		else{


			return modificadorAcceso;
		}
	}

	/**
	 * metodo que indica si el token actual corresponde a uno de los tipos de dato
	 * @return
	 */
	private SimboloLexico esTipoDato(){
		SimboloLexico tipoDato = null;

		if (tokenActual.getLexema().equals(Configuracion.entero)
				|| tokenActual.getLexema().equals(Configuracion.real)
				|| tokenActual.getLexema().equals(Configuracion.texto)) {
			tipoDato = tokenActual;
			darSiguienteToken();
			return tipoDato;
		} else {


			return tipoDato;
		}
	}

	public String [][]  mostrarTokensError()
	{

		ArrayList<ErrorSintactico> miTablaDeErrores;
		miTablaDeErrores = getListaErroresSintacticos();



		String [][]matriz = new String[miTablaDeErrores.size()][3];
		int i=0;


		while(i<miTablaDeErrores.size())
		{
			matriz[i][0]=miTablaDeErrores.get(i).getMsn();
			matriz[i][1]=""+miTablaDeErrores.get(i).getFila();
			matriz[i][2]=""+miTablaDeErrores.get(i).getColumna();

			i++;
		}


		return matriz;

	}

	/**
	 * Este metodo avanza hasta encontrar el token indicado
	 * @param tokenParada
	 */
	public void modoPanico(String tokenParada) {

		while (!tokenActual.getLexema().equals(tokenParada)) {
			darSiguienteToken();
			if(indice >= listaSimbolosLexicos.size()-1){
				break;
			}
		}
		if(!(indice >= listaSimbolosLexicos.size()-1)){
			darSiguienteToken();
		}
	}

	public UnidadCompilacion getMiUnidadDeCompilacion() {
		return miUnidadDeCompilacion;
	}

	public void setMiUnidadDeCompilacion(UnidadCompilacion miUnidadDeCompilacion) {
		this.miUnidadDeCompilacion = miUnidadDeCompilacion;
	}

	public ArrayList<ErrorSintactico> getListaErroresSintacticos() {
		return listaErroresSintacticos;
	}

	public void setListaErroresSintacticos(
			ArrayList<ErrorSintactico> listaErroresSintacticos) {
		this.listaErroresSintacticos = listaErroresSintacticos;
	}



}