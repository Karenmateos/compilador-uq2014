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

		if(listaDeclaraciones !=null && listaDeclaraciones.size() > 0)
		{
			DefaultMutableTreeNode nodoDeclaraciones = new DefaultMutableTreeNode("lista de declaraciones");

			for (DeclaracionVariable declaracion : listaDeclaraciones) 
			{
				nodoDeclaraciones.add(declaracion.getArbolVisual());			
			}
			miRaiz.add(nodoDeclaraciones);
		}
		
		if(listaAsignaciones != null && listaAsignaciones.size() >0){
		
			DefaultMutableTreeNode nodoAsignaciones = new DefaultMutableTreeNode("lista de asignaciones");

			for (Asignacion asignacion : listaAsignaciones) 
			{
				nodoAsignaciones.add(asignacion.getArbolVisual());			
			}
			miRaiz.add(nodoAsignaciones);
			
		}

		if(listaMetodos !=null && listaMetodos.size()>0)
		{
			DefaultMutableTreeNode nodoMetodos = new DefaultMutableTreeNode("lista de metodos");

			for (DeclaracionMetodo metodo : listaMetodos) 
			{
				nodoMetodos.add(metodo.getArbolVisual());			
			}
			miRaiz.add(nodoMetodos);
		}

		return miRaiz;
	}
}
