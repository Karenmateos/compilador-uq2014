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
* <CuerpoMetodo> ::= “{” [<ListaSentencias>] [<Retorno>] “}”
*/
public class CuerpoMetodo {
	SimboloLexico aperturaLlaves;
	ArrayList<Sentencia> sentencias;
	Retorno retorno;
	SimboloLexico cierreLlaves;

	public CuerpoMetodo(SimboloLexico aperturaParentesis, ArrayList<Sentencia> sentencias, Retorno retorno, SimboloLexico cierreParentesis){
		this.aperturaLlaves = aperturaParentesis;
		this.sentencias = sentencias;
		this.retorno = retorno;
		this.cierreLlaves = cierreParentesis;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoMetodo);

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
		
		if(retorno != null){
			miRaiz.add(retorno.getArbolVisual());
		}
		
		if(cierreLlaves != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreLlaves.getLexema()));
		}

		return miRaiz;
	}
}
