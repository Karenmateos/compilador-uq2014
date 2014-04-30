package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class InvocacionMetodo {
	SimboloLexico identificador;
	ArrayList<Argumento> argumentos;
	SimboloLexico aperturaParentesis;
	SimboloLexico cierreParentesis;

	public InvocacionMetodo(SimboloLexico identificador, SimboloLexico abreParentesis, ArrayList<Argumento> argumentos, SimboloLexico cierreParentesis) 
	{
		this.identificador = identificador;
		this.aperturaParentesis = abreParentesis;
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
		
		if(aperturaParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}
		
		if(argumentos.size() > 0)
		{		
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Argumentos");

			for (Argumento argumento : argumentos) 
			{
				nodo.add(argumento.getArbolVisual());
			}

			miRaiz.add(nodo);
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}

		return miRaiz;
	}
	
}
