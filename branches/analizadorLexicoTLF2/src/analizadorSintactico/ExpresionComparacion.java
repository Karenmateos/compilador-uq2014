package analizadorSintactico;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <ExpresionComparacion> ::= <IdVariable> <OperadorComparacion> <IdVariable> | <IdVariable> <OperadorComparacion> <Valor> | <Valor> <OperadorComparacion> <Valor> | <Valor> <OperadorComparacion> <IdVariable>

*/
public class ExpresionComparacion {

	SimboloLexico idVariable = null;
	SimboloLexico operadorComparacion = null;
	SimboloLexico idVariable2 = null;


	public ExpresionComparacion(SimboloLexico idVariable, SimboloLexico operadorComparacion, SimboloLexico idVariable2){

		this.idVariable = idVariable;
		this.operadorComparacion = operadorComparacion;
		this.idVariable2 = idVariable2;
	}

	public DefaultMutableTreeNode getArbolVisual(){

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