package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <Asignacion> ::= <IdVariable> �=� <ExpresioneComparacion> |<IdVariable> �=� <ExpresioneMatematica>| <idVariable> �=� <Valor>
*  | <idVariable> �=� <idVariable>
*/
public class Asignacion extends Sentencia{

	SimboloLexico idVariable = null;
	ExpresionMatematica expresionMatematica = null;
	ExpresionComparacion expresionComparacion = null;
	SimboloLexico idVariable2 = null;
	SimboloLexico operadorAsignacion = null;

	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, ExpresionMatematica exprecionMatematica){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.expresionMatematica = expresionMatematica;
	}

	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, ExpresionComparacion expresionComparacion){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.expresionComparacion = expresionComparacion;
	}

	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, SimboloLexico idVariable2){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.idVariable2 = idVariable2;
	}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.asignacion);
		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema()));
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
			miRaiz.add(new DefaultMutableTreeNode(idVariable2.getTipo()+Configuracion.dosPuntos+idVariable2.getLexema()));
			return miRaiz;
		}
		return miRaiz;
	}

}
