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
* <InvocacionMetodo>::= idMetodo "(" [<Argumentos>] ")" ";"
*/
public class InvocacionMetodo {
	// Variable que almacema el id de variable
	SimboloLexico identificador;
	// Variable que almacema un ArrayList de argumentos
	ArrayList<Argumento> argumentos;
	// Variable que almacema la apertura de parentesis
	SimboloLexico aperturaParentesis;
	// Variable que almacema el cierre de parentesis
	SimboloLexico cierreParentesis;
	// Variable que almacema un punto y coma (;)
	SimboloLexico terminal;

	/**
	 * Constructor, permite crear objetos de tipo InvocacionMetodo
	 * @param identificador
	 * @param abreParentesis
	 * @param argumentos
	 * @param cierreParentesis
	 * @param terminal
	 */
	public InvocacionMetodo(SimboloLexico identificador, SimboloLexico abreParentesis, ArrayList<Argumento> argumentos, SimboloLexico cierreParentesis, SimboloLexico terminal) 
	{
		this.identificador = identificador;
		this.aperturaParentesis = abreParentesis;
		this.argumentos = argumentos;
		this.cierreParentesis = cierreParentesis;
		this.terminal = terminal;
	}

	/**
	 * Metodo que permite obtener el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.unidadCompilacion);

		if(identificador != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(identificador.getLexema() + Configuracion.dosPuntos + identificador.getTipo()));
		}
		
		if(aperturaParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}
		
		if(argumentos.size() > 0)
		{		
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.argumentos);

			for (Argumento argumento : argumentos) 
			{
				nodo.add(argumento.getArbolVisual());
			}

			miRaiz.add(nodo);
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}
		
		if(terminal != null){
			miRaiz.add(new DefaultMutableTreeNode(terminal.getLexema()));
		}

		return miRaiz;
	}
	
}
