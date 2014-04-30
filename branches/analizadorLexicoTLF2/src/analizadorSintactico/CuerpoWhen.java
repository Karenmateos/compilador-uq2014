package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class CuerpoWhen {
	SimboloLexico aperturaLlaves;
	ArrayList<Sentencia> sentencias;
	SimboloLexico salida;
	SimboloLexico cierreLlaves;
	
	public CuerpoWhen(SimboloLexico aperturaLlaves, ArrayList<Sentencia> sentencias, SimboloLexico salida, SimboloLexico cierreLlaves){
		this.aperturaLlaves = aperturaLlaves;
		this.sentencias = sentencias;
		this.salida = salida;
		this.cierreLlaves = cierreLlaves;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoCiclo);

		if(aperturaLlaves != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(aperturaLlaves.getLexema()));
		}
		
		if(sentencias.size() > 0){
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaSentencias);
			for(Sentencia sentencia : sentencias){
				nodo.add(sentencia.getArbolVisual());
			}
			miRaiz.add(nodo);
		}
		
		if(salida != null){
			miRaiz.add(new DefaultMutableTreeNode(salida.getLexema()));
		}
		
		if(cierreLlaves != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreLlaves.getLexema()));
		}

		return miRaiz;
	}
}
