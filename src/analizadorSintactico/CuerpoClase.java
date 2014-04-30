package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

public class CuerpoClase {

	ArrayList<DeclaracionVariable> listaDeclaraciones;
	ArrayList<Asignacion> listaAsignaciones;
	ArrayList<DeclaracionMetodo>  listaMetodos;
	
	public CuerpoClase(ArrayList<DeclaracionVariable> listaDeclaraciones,ArrayList<Asignacion> listaAsignaciones ,ArrayList<DeclaracionMetodo> listaMetodos){
		
		this.listaDeclaraciones = listaDeclaraciones;
		this.listaAsignaciones = listaAsignaciones;
		this.listaMetodos = listaMetodos;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Cuerpo de la Clase");

		if(listaDeclaraciones.size() > 0)
		{
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("lista de declaraciones");

			for (DeclaracionVariable declaracion : listaDeclaraciones) 
			{
				nodo.add(declaracion.getArbolVisual());			
			}
			miRaiz.add(nodo);
		}
		
		if(listaAsignaciones.size() >0){
		
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("lista de asignaciones");

			for (Asignacion asignacion : listaAsignaciones) 
			{
				nodo.add(asignacion.getArbolVisual());			
			}
			miRaiz.add(nodo);
			
		}

		if(listaMetodos.size()>0)
		{
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("lista de metodos");

			for (DeclaracionMetodo metodo : listaMetodos) 
			{
				nodo.add(metodo.getArbolVisual());			
			}
			miRaiz.add(nodo);
		}

		return miRaiz;
	}
}
