package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class Operacion {

	SimboloLexico operadorMatematico = null;
	SimboloLexico idVariable = null;
	Operacion operacion = null;

	public Operacion(SimboloLexico operadorMatematico, SimboloLexico idVariable){

		this.operadorMatematico = operadorMatematico;
		this.idVariable = idVariable;
	}

	public Operacion(SimboloLexico operadorMatematico, Operacion operacion){

		this.operadorMatematico = operadorMatematico;
		this.operacion = operacion;
	}

	public DefaultMutableTreeNode getArbolVisual(){

		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Operacion");

		if(operadorMatematico!=null){
		miRaiz.add(new DefaultMutableTreeNode(operadorMatematico.getTipo()+": "+ operadorMatematico.getLexema()));
		}
		if(idVariable!=null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getTipo()+": "+ idVariable.getLexema()) );
			return miRaiz;
		}

		if(operacion != null){

			miRaiz.add(operacion.getArbolVisual());
			return miRaiz;
		}
		return miRaiz;
	}
}
