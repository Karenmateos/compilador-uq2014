package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
 * 
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz
 *<CuerpoClase> ::= “{“ [<ListaDeclaraciones>] [ListaAsignaciones] [<ListaMetodos>] “}”

 */

public class CuerpoClase {

	SimboloLexico llaveAbre = null;
	SimboloLexico llaveCierra = null;
	ArrayList<DeclaracionVariable> listaDeclaraciones = null;
	ArrayList<Asignacion> listaAsignaciones = null;
	ArrayList<DeclaracionMetodo>  listaMetodos = null;
	
	public CuerpoClase(SimboloLexico llaveAbre,ArrayList<DeclaracionVariable> listaDeclaraciones,ArrayList<Asignacion> listaAsignaciones ,ArrayList<DeclaracionMetodo> listaMetodos, SimboloLexico llaveCierra){
		this.llaveCierra = llaveCierra;
		this.llaveAbre = llaveAbre;
		this.listaDeclaraciones = listaDeclaraciones;
		this.listaAsignaciones = listaAsignaciones;
		this.listaMetodos = listaMetodos;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoClase);
		
		if(llaveAbre!=null){
			miRaiz.add(new DefaultMutableTreeNode(llaveAbre.getLexema()));
		}

		if(listaDeclaraciones!=null && listaDeclaraciones.size() > 0)
		{
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaDeclaraciones);

			for (DeclaracionVariable declaracion : listaDeclaraciones) 
			{
				nodo.add(declaracion.getArbolVisual());			
			}
			miRaiz.add(nodo);
		}
		
		if(listaAsignaciones!=null &&  listaAsignaciones.size() > 0){
		
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaAsignaciones);

			for (Asignacion asignacion : listaAsignaciones) 
			{
				nodo.add(asignacion.getArbolVisual());			
			}
			miRaiz.add(nodo);
			
		}

		if(listaMetodos!=null && listaMetodos.size()>0)
		{
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.listaMetodos);

			for (DeclaracionMetodo metodo : listaMetodos) 
			{
				nodo.add(metodo.getArbolVisual());			
			}
			miRaiz.add(nodo);
		}
		
		if(llaveCierra!=null){
			miRaiz.add(new DefaultMutableTreeNode(llaveCierra.getLexema()));
		}

		return miRaiz;
	}
}
