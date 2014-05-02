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
* <CuerpoMetodo> ::= �{� [<ListaSentencias>] [<Retorno>] �}�
*/
public class CuerpoMetodo {
	// Variable que almacema la apertura de llaves
	SimboloLexico aperturaLlaves;
	// Variable que almacema un ArrayList de sentencias
	ArrayList<Sentencia> sentencias;
	// Variable que almacema un objeto de tipo Retorno
	Retorno retorno;
	// Variable que almacema el cierre de Llaves
	SimboloLexico cierreLlaves;

	/**
	 * Constructor, permite crear objetos de tipo Cuerpo Metodo
	 * @param aperturaParentesis
	 * @param sentencias
	 * @param retorno
	 * @param cierreParentesis
	 */
	public CuerpoMetodo(SimboloLexico aperturaParentesis, ArrayList<Sentencia> sentencias, Retorno retorno, SimboloLexico cierreParentesis){
		this.aperturaLlaves = aperturaParentesis;
		this.sentencias = sentencias;
		this.retorno = retorno;
		this.cierreLlaves = cierreParentesis;
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoMetodo);

		if(aperturaLlaves != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(aperturaLlaves.getLexema()));
		}
		
		if(sentencias!=null && sentencias.size() > 0){
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
