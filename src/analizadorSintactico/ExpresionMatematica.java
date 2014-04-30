package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class ExpresionMatematica {

	SimboloLexico idVariable = null;
	Operacion operacion = null;
	
	public ExpresionMatematica(SimboloLexico idVariable, Operacion operacion){
		
		this.idVariable = idVariable;
		this.operacion = operacion;
		
	}
	
	public DefaultMutableTreeNode getArbolVisual(){
		
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Exprecion Matematica");
		
		miRaiz.add(new DefaultMutableTreeNode(idVariable.getTipo()+": "+idVariable.getLexema()));
		
		miRaiz.add(operacion.getArbolVisual());
		
		return miRaiz;
	}
	
}
