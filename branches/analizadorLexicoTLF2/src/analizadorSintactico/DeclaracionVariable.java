package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class DeclaracionVariable extends Sentencia{

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
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Declaracion de Variables");

		if(tipoDato != null){
			miRaiz.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		}

		if(idVariables.size() > 0){
			for (SimboloLexico identificador : idVariables)
			{
				miRaiz.add(new DefaultMutableTreeNode(identificador.getLexema()));
			}
		}
		
		if(terminal != null){
			miRaiz.add(new DefaultMutableTreeNode(terminal.getTipo()));
		}
		
		return miRaiz;
	}
}
