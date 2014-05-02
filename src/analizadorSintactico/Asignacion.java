package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
* Esta clase permite crear la categoria sintactica Asignacion
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <Asignacion> ::= <IdVariable> “=” <ExpresioneComparacion> |<IdVariable> “=” <ExpresioneMatematica>| <idVariable> “=” <Valor> | <idVariable> “=” <idVariable>
*/
public class Asignacion extends Sentencia{

	// Variable que almacena el id de variable
	SimboloLexico idVariable = null;
	// Variable que almacema un objeto de tipo ExpresionMatematica
	ExpresionMatematica expresionMatematica = null;
	// Variable que almacema un objeto de tipo ExpresionComparacion
	ExpresionComparacion expresionComparacion = null;
	// Variable que almacema id de variable
	SimboloLexico idVariable2 = null;
	// Variable que almacema un operador de asignacion
	SimboloLexico operadorAsignacion = null;

	/**
	 * Constructor, permite crear objetos de tipo Asignacion de la forma: <IdVariable> “=” <ExpresioneMatematica>
	 * @param idVariable
	 * @param operadorAsignacion
	 * @param expresionMatematica
	 */
	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, ExpresionMatematica expresionMatematica){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.expresionMatematica = expresionMatematica;
	}

	/**
	 * Constructor, permite crear objetos de tipo Asignacion de la forma: <IdVariable> “=” <ExpresioneComparacion>
	 * @param idVariable
	 * @param operadorAsignacion
	 * @param expresionComparacion
	 */
	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, ExpresionComparacion expresionComparacion){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.expresionComparacion = expresionComparacion;
	}

	/**
	 * Constructor, permite crear objetos de tipo Asignacion de la forma: <idVariable> “=” <idVariable>
	 * @param idVariable
	 * @param operadorAsignacion
	 * @param idVariable2
	 */
	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, SimboloLexico idVariable2){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.idVariable2 = idVariable2;
	}

	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.asignacion);
		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema() + Configuracion.dosPuntos + idVariable.getTipo()));
		}

		if(operadorAsignacion != null){
			miRaiz.add(new DefaultMutableTreeNode(operadorAsignacion.getLexema()));
		}

		if(expresionMatematica!=null)
		{
			miRaiz.add(expresionMatematica.getArbolVisual());
			return miRaiz;
		}

		if(expresionComparacion!=null)
		{
			miRaiz.add(expresionComparacion.getArbolVisual());
			return miRaiz;
		}

		if(idVariable2!=null)
		{
			miRaiz.add(new DefaultMutableTreeNode(idVariable2.getLexema() + Configuracion.dosPuntos + idVariable2.getTipo()));
			return miRaiz;
		}
		return miRaiz;
	}

}
