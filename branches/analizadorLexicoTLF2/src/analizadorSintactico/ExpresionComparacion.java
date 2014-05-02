package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;
import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
* Esta clase permite crear la categoria sintactica ExpresionComparacion
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <ExpresionComparacion> ::= <IdVariable> <OperadorComparacion> <IdVariable> | <IdVariable> <OperadorComparacion> <Valor> | <Valor> <OperadorComparacion> <Valor> | <Valor> <OperadorComparacion> <IdVariable>

*/
public class ExpresionComparacion {
	// Variable que almacema el id de variable
	SimboloLexico idVariable = null;
	// Variable que almacema el operador de comparacion
	SimboloLexico operadorComparacion = null;
	// Variable que almacema el identificador de la segunda variable
	SimboloLexico idVariable2 = null;

	/**
	 * Constructor, permite crear objetos de tipo ExpresionComparacion
	 * @param idVariable
	 * @param operadorComparacion
	 * @param idVariable2
	 */
	public ExpresionComparacion(SimboloLexico idVariable, SimboloLexico operadorComparacion, SimboloLexico idVariable2){
		this.idVariable = idVariable;
		this.operadorComparacion = operadorComparacion;
		this.idVariable2 = idVariable2;
	}

	/**
	 * Metodo que permite obtener el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual(){

		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.expresionComparacion);

		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema() + Configuracion.dosPuntos + idVariable.getTipo()));
		}

		if(operadorComparacion != null){

			miRaiz.add(new DefaultMutableTreeNode(operadorComparacion.getLexema()));
		}

		if(idVariable2 !=null){

			miRaiz.add(new DefaultMutableTreeNode(idVariable2.getLexema() + Configuracion.dosPuntos + idVariable2.getTipo()));


		}

		return miRaiz;
	}
}