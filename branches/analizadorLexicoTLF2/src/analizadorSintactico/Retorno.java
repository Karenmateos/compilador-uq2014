package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
* Esta clase permite crear la categoria sintactica Retorno
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <Retorno> ::= “<SEND>” <idVeriable> “;”

*/
public class Retorno {
	// Variable que almacema la palabra reservada del retorno
	SimboloLexico send;
	// Variable que almacema el id de variable
	SimboloLexico idVariable;
	// Variable que almacema un punto y coma (;)
	SimboloLexico terminal;

	/**
	 * Constructor, permite crear objetos de tipo Retorno
	 * @param send
	 * @param idVariable
	 * @param terminal
	 */
	public Retorno(SimboloLexico send, SimboloLexico idVariable, SimboloLexico terminal) 
	{
		this.send = send;
		this.idVariable = idVariable;
		this.terminal = terminal;
	}

	/**
	 * Metodo que permite obtener el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.retorno);

		if(send != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(send.getLexema() + Configuracion.dosPuntos + send.getTipo()));
		}
		
		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema() + Configuracion.dosPuntos + idVariable.getTipo()));
		}
		
		if(terminal != null){
			miRaiz.add(new DefaultMutableTreeNode(terminal.getLexema()));
		}

		return miRaiz;
	}
}
