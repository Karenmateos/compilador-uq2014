package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
* Esta clase permite crear la categoria sintactica DeclaracionMetodo
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <DeclaracionMetodo> ::= <ModificadorAcceso> <TipoDato> <IdMetodo> “(“ [<Argumentos>] “)”  <CuerpoMetodo>
*/
public class DeclaracionMetodo {
	
	// Variable que almacema el modificador de acceso
	SimboloLexico modificadorAcceso;
	// Variable que almacema el tipo de dato
	SimboloLexico tipoDato;
	// Variable que almacema el id del metodo
	SimboloLexico idMetodo;
	// Variable que almacema la apertura parentesis
	SimboloLexico aperturaParentesis;
	// Variable que almacema un ArrayList de argumentos
	ArrayList<Argumento> argumentos;
	// Variable que almacema el cierre de parentesis
	SimboloLexico cierreParentesis;
	// Variable que almacema un objeto de tipo CuerpoMetodo
	CuerpoMetodo cuerpoMetodo;
	
	/**
	 * Constructor, permite crear objetos de tipo DeclaracionMetodo
	 * @param modificadorAcceso
	 * @param tipoDato
	 * @param idMetodo
	 * @param aperturaParentesis
	 * @param argumentos
	 * @param cierreParentesis
	 * @param cuerpoMetodo
	 */
	public DeclaracionMetodo(SimboloLexico modificadorAcceso, SimboloLexico tipoDato, SimboloLexico idMetodo, SimboloLexico aperturaParentesis, ArrayList<Argumento> argumentos, SimboloLexico cierreParentesis, CuerpoMetodo cuerpoMetodo){
		this.modificadorAcceso = modificadorAcceso;
		this.tipoDato = tipoDato;
		this.idMetodo = idMetodo;
		this.aperturaParentesis = aperturaParentesis;
		this.argumentos = argumentos;
		this.cierreParentesis = cierreParentesis;
		this.cuerpoMetodo = cuerpoMetodo;
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.declaracionMetodo);

		if(modificadorAcceso != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(modificadorAcceso.getLexema() + Configuracion.dosPuntos + modificadorAcceso.getTipo()));
		}
		
		if(tipoDato != null){
			miRaiz.add(new DefaultMutableTreeNode(tipoDato.getLexema() + Configuracion.dosPuntos + tipoDato.getTipo()));
		}
		
		if(idMetodo != null){
			miRaiz.add(new DefaultMutableTreeNode(idMetodo.getLexema() + Configuracion.dosPuntos + idMetodo.getTipo()));
		}
		
		if(aperturaParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}
		
		if(argumentos !=null || argumentos.size() > 0)
		{		
			DefaultMutableTreeNode aNode = new DefaultMutableTreeNode(Configuracion.argumentos);

			for (Argumento argumento : argumentos) 
			{
				aNode.add(argumento.getArbolVisual());
			}

			miRaiz.add(aNode);
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}
		
		if(cuerpoMetodo != null){
			miRaiz.add(cuerpoMetodo.getArbolVisual());
		}

		return miRaiz;
	}
}
