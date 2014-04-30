package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.xml.internal.bind.v2.model.core.ID;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class ExpresionMatematica {

	SimboloLexico idVariable = null;
	ArrayList<Operacion> operaciones= null;

	public ExpresionMatematica(SimboloLexico idVariable, ArrayList<Operacion> operaciones){

		this.idVariable = idVariable;
		this.operaciones = operaciones;

	}

	public DefaultMutableTreeNode getArbolVisual(){

		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.expresionMatematica);

		if(idVariable!=null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getTipo()+Configuracion.dosPuntos+idVariable.getLexema()));
		}

		if(operaciones.size()>0){
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.operaciones);

			for(Operacion operacion: operaciones){				
				nodo.add(operacion.getArbolVisual());
			}			
			miRaiz.add(nodo);		

		}	

		return miRaiz;
	}

}
