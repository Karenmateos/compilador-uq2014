package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class Asignacion {

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
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Asignacion");
		miRaiz.add(new DefaultMutableTreeNode("Nombre: "+idVariable.getLexema()));

		miRaiz.add(new DefaultMutableTreeNode("Operador Asignacion: "+operadorAsignacion.getLexema()));


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
			miRaiz.add(new DefaultMutableTreeNode(idVariable2.getTipo()+": "+idVariable2.getLexema()));
			return miRaiz;
		}
		return miRaiz;
	}

}
