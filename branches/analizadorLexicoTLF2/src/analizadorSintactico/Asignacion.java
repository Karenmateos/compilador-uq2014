package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class Asignacion {

	SimboloLexico idVariable = null;
	ExprecionMatematica exprecionMatematica = null;
	ExpresionComparacion exprecionComparacion = null;
	SimboloLexico idVariable2 = null;
	SimboloLexico operadorAsignacion = null;

	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, ExprecionMatematica exprecionMatematica){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.exprecionMatematica = exprecionMatematica;
	}

	public Asignacion(SimboloLexico idVariable, SimboloLexico operadorAsignacion, ExpresionComparacion exprecionComparacion){

		this.idVariable = idVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.exprecionComparacion = exprecionComparacion;
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


		if(exprecionMatematica!=null)
		{
			miRaiz.add(exprecionMatematica.getArbolVisual());
			return miRaiz;
		}

		if(exprecionComparacion!=null)
		{
			miRaiz.add(exprecionComparacion.getArbolVisual());
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
