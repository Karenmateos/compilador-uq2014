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
	SimboloLexico tipoDato;
	SimboloLexico idVariable;
	
	public Argumento(SimboloLexico tipoDato, SimboloLexico idVariable){
		this.tipoDato = tipoDato;
		this.idVariable = idVariable;
	}
	
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
