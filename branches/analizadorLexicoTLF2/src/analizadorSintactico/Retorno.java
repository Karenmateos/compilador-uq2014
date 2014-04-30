package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

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
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Retorno");

		if(send != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(send.getLexema()));
		}
		
		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema()));
		}
		
		if(terminal != null){
			miRaiz.add(new DefaultMutableTreeNode(terminal.getLexema()));
		}

		return miRaiz;
	}
}
