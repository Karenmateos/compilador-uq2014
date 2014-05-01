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
	SimboloLexico aperturaParentesis;
	ArrayList<Sentencia> sentencias;
	Retorno retorno;
	SimboloLexico cierreParentesis;

	public CuerpoMetodo(SimboloLexico aperturaParentesis, ArrayList<Sentencia> sentencias, Retorno retorno, SimboloLexico cierreParentesis){
		this.aperturaParentesis = aperturaParentesis;
		this.sentencias = sentencias;
		this.retorno = retorno;
		this.cierreParentesis = cierreParentesis;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoMetodo);

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
		
		if(retorno != null){
			miRaiz.add(retorno.getArbolVisual());
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}

		return miRaiz;
	}
}
