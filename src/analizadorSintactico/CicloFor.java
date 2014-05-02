package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class CicloFor extends Sentencia{
	// Variable que almacema la palabra reservada inicial del ciclo for
	SimboloLexico palabraFor;
	// Variable que almacema la apertura de parentesis
	SimboloLexico aperturaParentesis;
	// Variable que almacema un objeto de tipo Asignacion
	Asignacion asiganacion;
	// Variable que almacema un ;
	SimboloLexico puntoyComa;
	// Variable que almacema un objeto de tipo ExpresionComparacion
	ExpresionComparacion expresionComparacion;
	// Variable que almacema un id de variable
	SimboloLexico idVariable;
	// Variable que almacema un operador de asignacion
	SimboloLexico igual;
	// Variable que almacema un objeto de tipo ExpresionMatematica
	ExpresionMatematica expresionMatematica;
	// Variable que almacema el cierre de parentesis
	SimboloLexico cierreParentesis;
	// Variable que almacema un objeto de tipo CuerpoCiclo
	CuerpoCiclo cuerpoCiclo;
	
	/**
	 * Constructor, permite crear objetos de tipo CicloFor
	 * @param palabraFor
	 * @param aperturaParentesis
	 * @param asiganacion
	 * @param puntoyComa
	 * @param expesionComparacion
	 * @param idVariable
	 * @param igual
	 * @param expresionMatematica
	 * @param cierreParentesis
	 * @param cuerpoCiclo
	 */
	public CicloFor(SimboloLexico palabraFor, SimboloLexico aperturaParentesis, Asignacion asiganacion, SimboloLexico puntoyComa, ExpresionComparacion expesionComparacion, SimboloLexico idVariable, SimboloLexico igual, ExpresionMatematica expresionMatematica, SimboloLexico cierreParentesis, CuerpoCiclo cuerpoCiclo){
		this.palabraFor = palabraFor;
		this.aperturaParentesis = aperturaParentesis;
		this.asiganacion = asiganacion;
		this.puntoyComa = puntoyComa;
		this.expresionComparacion = expesionComparacion;
		this.idVariable = idVariable;
		this.igual = igual;
		this.expresionMatematica = expresionMatematica;
		this.cierreParentesis = cierreParentesis;
		this.cuerpoCiclo = cuerpoCiclo;
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual(){
		
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cicloFor);
		
		if(palabraFor != null){
			miRaiz.add(new DefaultMutableTreeNode(palabraFor.getLexema() + Configuracion.dosPuntos + palabraFor.getTipo()));
		}
		
		if(aperturaParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}
		
		if(asiganacion != null){
			miRaiz.add(asiganacion.getArbolVisual());
		}
		
		if(puntoyComa != null){
			miRaiz.add(new DefaultMutableTreeNode(puntoyComa.getLexema()));
		}
		
		if(expresionComparacion != null){
			miRaiz.add(expresionComparacion.getArbolVisual());
		}
		
		if(puntoyComa != null){
			miRaiz.add(new DefaultMutableTreeNode(puntoyComa.getLexema()));
		}
		
		if(idVariable != null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema() + Configuracion.dosPuntos + idVariable.getTipo()));
		}
		
		if(igual != null){
			miRaiz.add(new DefaultMutableTreeNode(igual.getLexema()));
		}
		
		if(expresionMatematica != null){
			miRaiz.add(expresionMatematica.getArbolVisual());
		}
		
		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}
		
		if(cuerpoCiclo != null){
			miRaiz.add(cuerpoCiclo.getArbolVisual());
		}
		
		return miRaiz;
	}

}
