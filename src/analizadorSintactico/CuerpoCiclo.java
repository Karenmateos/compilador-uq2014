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
* GIC: <CuerpoCiclo> ::=  “{” [<ListaSentencias>]  “}”

*/
public class CuerpoCiclo {
	// Variable que almacema la apertura de llaves
	SimboloLexico aperturaLlaves;
	// Variable que almacema un ArrayList de sentencias
	ArrayList<Sentencia> sentencias;
	// Variable que almacema el cierre de llaves
	SimboloLexico cierreLlaves;

	/**
	 * Constructor, permite crear objetos de tipo CuerpoCilco
	 * @param aperturaParentesis
	 * @param sentencias
	 * @param cierreParentesis
	 */
	public CuerpoCiclo(SimboloLexico aperturaParentesis, ArrayList<Sentencia> sentencias, SimboloLexico cierreParentesis){
		this.aperturaLlaves = aperturaParentesis;
		this.sentencias = sentencias;
		this.cierreLlaves = cierreParentesis;
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
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
