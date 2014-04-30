package analizadorSintactico;

import java.util.ArrayList;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class AnalizadorSintactico {

	private ArrayList<SimboloLexico> listaSimbolosLexicos;
	private ArrayList<ErrorSintactico> listaErroresSintacticos;
	private SimboloLexico tokenActual;
	private int indice;
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
		int posBacktraking = indice;
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
							"El identificador corresponde a un identificador de metodo",
							tokenActual.getFila(), tokenActual.getColumna());
					return new Argumento(tipoDato, identificadorVariable);

				} else if (tokenActual.getTipo().equals(Configuracion.IdClase)) {
					reportarError(
							"El identificador corresponde a un identificador de clase",
							tokenActual.getFila(), tokenActual.getColumna());
					return new Argumento(tipoDato, identificadorVariable);

				} else {
					reportarError("Falta el nombre del parámetro",
							tokenActual.getFila(), tokenActual.getColumna());
					return new Argumento(tipoDato, identificadorVariable);
				}

			}
		}
		else
			if (tokenActual.getTipo().equals(Configuracion.IdVariable)) {
				reportarError("falta el tipo de dato", tokenActual.getFila(), tokenActual.getColumna());
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

					reportarError("falta el separador",tokenActual.getFila() , tokenActual.getColumna());
					break;
				}
			}
		}

		return listaArgumentos;
	}

	/**
	 * Indica si cierto conjunto de tokens conforman La Unidad de Compilación
	 * GIC: <UnidadDeCompilacion> ::=<Clase>
	 * 
	 * @return unidadCompilacion
	 */
	public UnidadCompilacion esUnidadDeCompilacion() {
		Clase clase = esClase();

		return new UnidadCompilacion(clase);
	}

	public Clase esClase(){

		SimboloLexico modificadorAcceso = null;
		SimboloLexico idClase = null;
		CuerpoClase cuerpoClase = null;


		modificadorAcceso = esModificadorAcceso();

		if(modificadorAcceso == null){

			reportarError("Falta modificador de acceso",tokenActual.getFila(), tokenActual.getColumna());

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
				reportarError("falta el identificador de la clase",tokenActual.getFila(), tokenActual.getColumna());

			}
		}
		else{
			if(idClase==null){
				reportarError("falta el identificador de la clase",tokenActual.getFila(), tokenActual.getColumna());
			}
		}

		cuerpoClase = esCuerpoClase(); 
		if(cuerpoClase != null){

			return new Clase(modificadorAcceso, idClase, cuerpoClase);
		}
		else{
			reportarError("Falta el cuerpo de la clase",tokenActual.getFila(), tokenActual.getColumna());
		}
		return new Clase(modificadorAcceso, idClase, cuerpoClase);
	}

	public CuerpoClase esCuerpoClase(){

		ArrayList<DeclaracionVariable> listaDeclaraciones = esListaDeclaraciones();
		ArrayList<Asignacion> listaAsignaciones = esListaAsignaciones();
		ArrayList<DeclaracionMetodo>  listaMetodos = esListaMetodos();


		return new CuerpoClase(listaDeclaraciones,listaAsignaciones,listaMetodos);

	}

	public ArrayList<DeclaracionVariable> esListaDeclaraciones(){

		ArrayList<DeclaracionVariable> listaDeclaraciones = new ArrayList<DeclaracionVariable>();
		DeclaracionVariable declaracionVariable = esDeclaracionVariable();

		while(declaracionVariable != null){
			listaDeclaraciones.add(declaracionVariable);
			declaracionVariable = esDeclaracionVariable();
		}

		return listaDeclaraciones; 
	}

	public ArrayList<Asignacion> esListaAsignaciones(){

		ArrayList<Asignacion> listaAsignacion = new ArrayList<Asignacion>();
		Asignacion asignacion = esAsignacion();

		while(asignacion != null){

			listaAsignacion.add(asignacion);
			asignacion = esAsignacion(); 
		}

		return listaAsignacion;

	}

	public ArrayList<DeclaracionMetodo> esListaMetodos(){

		ArrayList<DeclaracionMetodo> listaMetodos = new ArrayList<DeclaracionMetodo>();
		DeclaracionMetodo declaracionMetodo = esDeclaracionMetodo();
		while (declaracionMetodo != null){
			listaMetodos.add(declaracionMetodo);
			declaracionMetodo = esDeclaracionMetodo();
		}

		return listaMetodos;
	}

	public DeclaracionMetodo esDeclaracionMetodo(){

		SimboloLexico modificadorAcceso = null;
		SimboloLexico tipoDato = null;
		SimboloLexico idMetodo = null;
		ArrayList<Argumento> argumentos = null;
		SimboloLexico aperturaParentesis = null;
		SimboloLexico cierreParentesis = null;

		modificadorAcceso = esModificadorAcceso();

		if(modificadorAcceso!=null){
			darSiguienteToken();
		}
		else{

		}

		tipoDato = esTipoDato();










	}

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
					reportarError("faltan las variables",tokenActual.getFila(), tokenActual.getColumna());
					return new DeclaracionVariable(tipoDato,idVariables,terminal);
				}
				else{
					realizarBactracking(posBacktraking);
					return null;
				}
			}
			if(tokenActual.getTipo().equals(Configuracion.FinSentencia)){
				terminal = tokenActual;
				return  new DeclaracionVariable(tipoDato, idVariables, terminal);
			}
			else{
				modoPanico(";");
				return new DeclaracionVariable(tipoDato, idVariables, terminal);

			}
		}





	}

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

					reportarError("falta el separador",tokenActual.getFila() , tokenActual.getColumna());
					break;
				}
				else{
					break;
				}
					
			}
		}

		return idVariables;

	}

	public SimboloLexico esIdVariable(){

		SimboloLexico idVariable = null;

		if(tokenActual.getTipo().equals(Configuracion.IdVariable)){
			idVariable = tokenActual;
			darSiguienteToken();

		}

		return idVariable;

	}

	public Asignacion esAsignacion(){


		SimboloLexico idVariable = null;
		SimboloLexico idVariable2 = null;
		SimboloLexico operadorAsignacion = null;
		SimboloLexico Valor = null;
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
			reportarError("Falta operador de asignacion", tokenActual.getFila(), tokenActual.getColumna());
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

		expresionComparacion = esExpresionComparacion();
		if(expresionComparacion != null){

			darSiguienteToken();
			return new Asignacion(idVariable, operadorAsignacion, expresionComparacion);
		}
		expresionMatematica = esExpresionMatematica();
		if(expresionMatematica != null){

			darSiguienteToken();
			return new Asignacion(idVariable, operadorAsignacion, expresionMatematica);
		}

		reportarError("falta asignar algun valor", tokenActual.getFila(), tokenActual.getColumna());
		return new Asignacion(idVariable, operadorAsignacion, expresionComparacion);
	}

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
				reportarError("falta el valor a comparar", tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(";");
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
				reportarError("falta el operador relacional", tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(";");
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

		reportarError("falta el valor a comparar", tokenActual.getFila(), tokenActual.getColumna());
		modoPanico(";");
		return new ExpresionComparacion(idVariable, operadorComparacion, idVariable2);

	}

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
				reportarError("falta el valor para realizar la operación", tokenActual.getFila(), tokenActual.getColumna());
				modoPanico(";");
				return new ExpresionMatematica(idVariable, operaciones);
			}
			else{
				return null;
			}
		}

		operaciones = esOperaciones();

		if(operaciones.size()>0){
			return new ExpresionMatematica(idVariable, operaciones);
		}else{

			realizarBactracking(posBacktraking);
			return null;
		}

	}

	public ArrayList<Operacion> esOperaciones(){

		ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
		Operacion operacion = esOperacion();

		while(operacion != null){

			operaciones.add(operacion);
			operacion = esOperacion();
		}
		return operaciones;
	}

	public Operacion esOperacion(){
		int posBacktraking = indice;
		SimboloLexico OperadorMatematico = null;
		SimboloLexico idVariable = null;
		Operacion operacion = null;

		if(tokenActual.getTipo().equals(Configuracion.OperadorMatematico)){
			OperadorMatematico = tokenActual;
			darSiguienteToken();
		}
		else{
			return null;
		}

		if(tokenActual.getTipo().equals(Configuracion.IdVariable) || tokenActual.getTipo().equals(Configuracion.Real) || tokenActual.getTipo().equals(Configuracion.Entero) ) {
			idVariable = tokenActual;
			darSiguienteToken();
			return new Operacion(OperadorMatematico,idVariable);
		}
		else{
			realizarBactracking(posBacktraking);
			return null;
		}


	}

	private SimboloLexico esModificadorAcceso(){

		SimboloLexico modificadorAcceso = null;

		if(tokenActual.getLexema().equals("<+>") || tokenActual.getLexema().equals("<->") ){

			modificadorAcceso = tokenActual;
			darSiguienteToken();
			return modificadorAcceso;

		}
		else{


			return modificadorAcceso;
		}
	}

	private SimboloLexico esTipoDato(){
		SimboloLexico tipoDato = null;

		if (tokenActual.getLexema().equals(Configuracion.Real)
				|| tokenActual.getLexema().equals(Configuracion.Entero)
				|| tokenActual.getLexema().equals(Configuracion.Cadena)) {
			tipoDato = tokenActual;
			darSiguienteToken();
			return tipoDato;
		} else {


			return tipoDato;
		}
	}
	public void modoPanico(String tokenParada) {

		while (!tokenActual.getLexema().equals(tokenParada)) {
			darSiguienteToken();
		}

	}
}