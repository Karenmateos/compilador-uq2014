package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class InvocacionMetodo {
	SimboloLexico identificador;
	ArrayList<Argumento> argumentos;
	SimboloLexico abreParentesis;
	SimboloLexico cierreParentesis;

	public InvocacionMetodo(SimboloLexico identificador, SimboloLexico abreParentesis, ArrayList<Argumento> argumentos, SimboloLexico cierreParentesis) 
	{
		this.identificador = identificador;
		this.abreParentesis = abreParentesis;
		this.argumentos = argumentos;
		this.cierreParentesis = cierreParentesis;
	}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Invocacion Metodo");

		if(identificador != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(identificador.getTipo() +":"+ identificador.getLexema()));
		}
		
		if(abreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(abreParentesis.getLexema()));
		}
		
		if(argumentos !=null || argumentos.size() > 0)
		{		
			DefaultMutableTreeNode aNode = new DefaultMutableTreeNode("Argumentos");

			for (Argumento argumento : argumentos) 
			{
				aNode.add(argumento.getArbolVisual());
			}

			miRaiz.add(aNode);
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}

		return miRaiz;
	}
	
}
