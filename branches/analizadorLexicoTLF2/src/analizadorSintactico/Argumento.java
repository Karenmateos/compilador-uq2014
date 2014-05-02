package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;
/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <Argumento> ::= <TipoDato> <IdVariable>
*/
public class Argumento {
	
	// Variable que almacena el tipo de dato
	SimboloLexico tipoDato;
	// Variable que almacena el id de variable
	SimboloLexico idVariable;
	
	/**
	 * Constructor, permite crear objetos de tipo Argumento
	 * @param tipoDato
	 * @param idVariable
	 */
	public Argumento(SimboloLexico tipoDato, SimboloLexico idVariable){
		this.tipoDato = tipoDato;
		this.idVariable = idVariable;
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.argumento);

		if(tipoDato != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(tipoDato.getLexema() + Configuracion.dosPuntos + tipoDato.getTipo()));
		}
		
		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema()  + Configuracion.dosPuntos + idVariable.getTipo()));
		}
		
		return miRaiz;
	}
}
