package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
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
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoCiclo);

		if(aperturaParentesis != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}
		
		if(sentencias.size() > 0){
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaSentencias);
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
