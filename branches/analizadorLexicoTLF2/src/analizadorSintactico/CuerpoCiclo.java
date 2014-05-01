package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <CuerpoCiclo> ::=  “{” [<ListaSentencias>]  “}”

*/
public class CuerpoCiclo {
	SimboloLexico aperturaLlaves;
	ArrayList<Sentencia> sentencias;
	SimboloLexico cierreLlaves;

	public CuerpoCiclo(SimboloLexico aperturaParentesis, ArrayList<Sentencia> sentencias, SimboloLexico cierreParentesis){
		this.aperturaLlaves = aperturaParentesis;
		this.sentencias = sentencias;
		this.cierreLlaves = cierreParentesis;
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
		
		if(cierreLlaves != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreLlaves.getLexema()));
		}

		return miRaiz;
	}
}
