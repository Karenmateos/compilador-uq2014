package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <Retorno> ::= �<SEND>� <idVariable> �;�

*/
public class Retorno {
	SimboloLexico send;
	SimboloLexico idVariable;
	SimboloLexico terminal;

	public Retorno(SimboloLexico send, SimboloLexico idVariable, SimboloLexico terminal) 
	{
		this.send = send;
		this.idVariable = idVariable;
		this.terminal = terminal;
	}

	public DefaultMutableTreeNode getArbolVisual()
	{
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
