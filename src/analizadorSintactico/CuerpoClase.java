package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;


import analizadorLexico.Configuracion;

/**
 * 
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz
 *<CuerpoClase> ::= “{“ [<ListaDeclaraciones>] [ListaAsignaciones] [<ListaMetodos>] “}”

 */

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
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoClase);

		if(listaDeclaraciones.size() > 0)
		{
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaDeclaraciones);

			for (DeclaracionVariable declaracion : listaDeclaraciones) 
			{
				nodo.add(declaracion.getArbolVisual());			
			}
			miRaiz.add(nodo);
		}
		
		if(listaAsignaciones.size() >0){
		
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaAsignaciones);

			for (Asignacion asignacion : listaAsignaciones) 
			{
				nodo.add(asignacion.getArbolVisual());			
			}
			miRaiz.add(nodo);
			
		}

		if(listaMetodos.size()>0)
		{
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaMetodos);

			for (DeclaracionMetodo metodo : listaMetodos) 
			{
				nodo.add(metodo.getArbolVisual());			
			}
			miRaiz.add(nodo);
		}

		return miRaiz;
	}
}
