package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <Operacion> ::= <OperadorMatematico> <IdVariable> | <OperadorMatematico> <valor> | <OperadorMatematico> <IdVariable> <Operacion> | <OperadorMatematico> <valor> <Operacion>

*/
public class Operacion {
	// Variable que almacema un operador matematico
	SimboloLexico operadorMatematico = null;
	// Variable que almacema el id de variable
	SimboloLexico idVariable = null;

	/**
	 * Constructor, permite crear objetos de tipp Operacion
	 * @param operadorMatematico
	 * @param idVariable
	 */
	public Operacion(SimboloLexico operadorMatematico, SimboloLexico idVariable){

		this.operadorMatematico = operadorMatematico;
		this.idVariable = idVariable;
	}


	/**
	 * Metodo que permite obtener el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual(){

		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.operacion);

		if(operadorMatematico!=null){
			miRaiz.add(new DefaultMutableTreeNode(operadorMatematico.getLexema()));
		}
		if(idVariable!=null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema() + Configuracion.dosPuntos + idVariable.getTipo()) );
		}

		return miRaiz;
	}
}
