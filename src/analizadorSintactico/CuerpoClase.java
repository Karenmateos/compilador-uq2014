package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
 * 
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz
 * GIC: <CuerpoClase> ::= “{“ [<ListaDeclaraciones>] [ListaAsignaciones] [<ListaMetodos>] “}”

 */

public class CuerpoClase {

	// Variable que almacema la apertura de llaves
	SimboloLexico aperturaLlaves = null;
	// Variable que almacema el cierre de llaves
	SimboloLexico cierreLlaves = null;
	// Variable que almacema un ArrayList de declaraciones de variable
	ArrayList<DeclaracionVariable> listaDeclaraciones = null;
	// Variable que almacema un ArrayList de asignaciones
	ArrayList<Asignacion> listaAsignaciones = null;
	// Variable que almacema un ArrayList de metodos
	ArrayList<DeclaracionMetodo>  listaMetodos = null;
	
	/**
	 * Constructor, permite crear objetos de tipo CuerpoClase
	 * @param aperturaLlaves
	 * @param listaDeclaraciones
	 * @param listaAsignaciones
	 * @param listaMetodos
	 * @param cierreLlaves
	 */
	public CuerpoClase(SimboloLexico aperturaLlaves, ArrayList<DeclaracionVariable> listaDeclaraciones, ArrayList<Asignacion> listaAsignaciones ,ArrayList<DeclaracionMetodo> listaMetodos, SimboloLexico cierreLlaves){
		this.aperturaLlaves = aperturaLlaves;
		this.cierreLlaves = cierreLlaves;
		this.listaDeclaraciones = listaDeclaraciones;
		this.listaAsignaciones = listaAsignaciones;
		this.listaMetodos = listaMetodos;
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
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
