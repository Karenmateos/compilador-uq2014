package analizadorSintactico;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import analizadorLexico.SimboloLexico;

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

		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Expresion de comparacion");

if(idVariable != null){
	miRaiz.add(new DefaultMutableTreeNode(idVariable.getTipo()+": "+idVariable.getLexema()) );
}
	
if(operadorComparacion != null){
	
	miRaiz.add(new DefaultMutableTreeNode(operadorComparacion.getTipo()+": "+operadorComparacion.getLexema()));
}

if(idVariable2 !=null){
	
	miRaiz.add(new DefaultMutableTreeNode(idVariable2.getTipo()+": "+idVariable2.getLexema()));
		
		
	}

return miRaiz;
}
}