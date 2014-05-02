package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
* Esta clase permite crear la categoria sintactica DeclaracionVariable
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <DeclaracionVariable> ::= <TipoDato> <Variables> “;”
*/
public class DeclaracionVariable extends Sentencia{
	// Variable que almacema el tipo de dato
	SimboloLexico tipoDato;
	// Variable que almacema un AyyarList de identificadores de variable
	ArrayList<SimboloLexico> idVariables;
	// Variable que almacema un punto y coma (;)
	SimboloLexico terminal;

	/**
	 * Constructor, permite crear objetos de tipo DeclaracionVariable
	 * @param tipoDato
	 * @param idVariables
	 * @param terminal
	 */
	public DeclaracionVariable(SimboloLexico tipoDato, ArrayList<SimboloLexico> idVariables, SimboloLexico terminal){

		this.tipoDato = tipoDato;
		this.idVariables = idVariables;
		this.terminal = terminal;

	}

	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.declaracionVariable);

		if(tipoDato != null){
			miRaiz.add(new DefaultMutableTreeNode(tipoDato.getLexema() + Configuracion.dosPuntos + tipoDato.getTipo()));
		}

		if(idVariables.size() > 0){
			for (SimboloLexico identificador : idVariables)
			{
				miRaiz.add(new DefaultMutableTreeNode(identificador.getLexema() + Configuracion.dosPuntos + identificador.getTipo()));
			}
		}
		
		if(terminal != null){
			miRaiz.add(new DefaultMutableTreeNode(terminal.getTipo()));
		}
		
		return miRaiz;
	}
}
