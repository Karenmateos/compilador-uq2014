package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class CuerpoCiclo {
	SimboloLexico aperturaParentesis;
	ArrayList<Sentencia> sentencias;
	SimboloLexico cierreParentesis;

	public CuerpoCiclo(SimboloLexico aperturaParentesis, ArrayList<Sentencia> sentencias, SimboloLexico cierreParentesis){
		this.aperturaParentesis = aperturaParentesis;
		this.sentencias = sentencias;
		this.cierreParentesis = cierreParentesis;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Cuerpo Ciclo");

		if(aperturaParentesis != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}
		
		if(sentencias.size() > 0){
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Lista de Sentencias");
			for(Sentencia sentencia : sentencias){
				nodo.add(sentencia.getArbolVisual());
			}
			miRaiz.add(nodo);
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}

		return miRaiz;
	}
}
