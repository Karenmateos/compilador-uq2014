package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class DeclaracionVariable {

	SimboloLexico tipoDato;
	ArrayList<SimboloLexico> idVariables;
	SimboloLexico terminal;
	
	public DeclaracionVariable(SimboloLexico tipoDato, ArrayList<SimboloLexico> idVariables, SimboloLexico terminal){
	
		this.tipoDato = tipoDato;
		this.idVariables = idVariables;
		this.terminal = terminal;
		
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Declaracion de Variables");

		raiz.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		
		for (SimboloLexico identificador : idVariables)
		{
			raiz.add(new DefaultMutableTreeNode(identificador.getLexema()));
		}

		raiz.add(new DefaultMutableTreeNode(terminal.getTipo()));
		
		return raiz;
	}
}
