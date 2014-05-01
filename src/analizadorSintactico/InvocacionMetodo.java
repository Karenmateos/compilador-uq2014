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
	SimboloLexico identificador;
	ArrayList<Argumento> argumentos;
	SimboloLexico aperturaParentesis;
	SimboloLexico cierreParentesis;
	SimboloLexico terminal;

	public InvocacionMetodo(SimboloLexico identificador, SimboloLexico abreParentesis, ArrayList<Argumento> argumentos, SimboloLexico cierreParentesis, SimboloLexico terminal) 
	{
		this.identificador = identificador;
		this.aperturaParentesis = abreParentesis;
		this.argumentos = argumentos;
		this.cierreParentesis = cierreParentesis;
		this.terminal = terminal;
	}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.unidadCompilacion);

		if(identificador != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(identificador.getTipo() +Configuracion.dosPuntos+ identificador.getLexema()));
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
