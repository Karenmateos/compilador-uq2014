package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.xml.internal.bind.v2.model.core.ID;

import analizadorLexico.SimboloLexico;

public class ExpresionMatematica {

	SimboloLexico idVariable = null;
	ArrayList<Operacion> operaciones= null;
	
	public ExpresionMatematica(SimboloLexico idVariable, ArrayList<Operacion> operaciones){
		
		this.idVariable = idVariable;
		this.operaciones = operaciones;
		
	}
	
	public DefaultMutableTreeNode getArbolVisual(){
		
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Exprecion Matematica");
		
		if(idVariable!=null){
		miRaiz.add(new DefaultMutableTreeNode(idVariable.getTipo()+": "+idVariable.getLexema()));
		}
		if(operaciones.size()>0){
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Operaciones");
			
			for(Operacion operacion: operaciones){
				
				nodo.add(operacion.getArbolVisual());
			}
			
			miRaiz.add(nodo);
			
			return miRaiz;
		}
		
		
		return miRaiz;
	}
	
}
