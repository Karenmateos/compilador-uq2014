package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class Argumento {
	SimboloLexico tipoDato;
	SimboloLexico idVariable;
	
	public Argumento(SimboloLexico tipoDato, SimboloLexico idVariable){
		this.tipoDato = tipoDato;
		this.idVariable = idVariable;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.argumento);

		if(tipoDato != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		}
		
		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema()));
		}
		
		return miRaiz;
	}
}
