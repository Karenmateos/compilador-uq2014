package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
 * 
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz
 *<CuerpoClase> ::= �{� [<ListaDeclaraciones>] [ListaAsignaciones] [<ListaMetodos>] �}�

 */

public class CuerpoClase {

	SimboloLexico aperturaLlaves = null;
	SimboloLexico cierreLlaves = null;
	ArrayList<DeclaracionVariable> listaDeclaraciones = null;
	ArrayList<Asignacion> listaAsignaciones = null;
	ArrayList<DeclaracionMetodo>  listaMetodos = null;
	
	public CuerpoClase(SimboloLexico aperturaLlaves, ArrayList<DeclaracionVariable> listaDeclaraciones, ArrayList<Asignacion> listaAsignaciones ,ArrayList<DeclaracionMetodo> listaMetodos, SimboloLexico cierreLlaves){
		this.aperturaLlaves = aperturaLlaves;
		this.cierreLlaves = cierreLlaves;
		this.listaDeclaraciones = listaDeclaraciones;
		this.listaAsignaciones = listaAsignaciones;
		this.listaMetodos = listaMetodos;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cuerpoClase);
		
		if(aperturaLlaves!=null){
			miRaiz.add(new DefaultMutableTreeNode(aperturaLlaves.getLexema()));
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
		
		if(cierreLlaves!=null){
			miRaiz.add(new DefaultMutableTreeNode(cierreLlaves.getLexema()));
		}

		return miRaiz;
	}
}
