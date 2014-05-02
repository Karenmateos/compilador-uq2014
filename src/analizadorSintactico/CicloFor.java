package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class CicloFor extends Sentencia{
	SimboloLexico palabraFor;
	SimboloLexico aperturaParentesis;
	Asignacion asiganacion;
	SimboloLexico puntoyComa;
	ExpresionComparacion expresionComparacion;
	SimboloLexico idVariable;
	SimboloLexico igual;
	ExpresionMatematica expresionMatematica;
	SimboloLexico cierreParentesis;
	CuerpoCiclo cuerpoCiclo;
	
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
	
	public DefaultMutableTreeNode getArbolVisual(){
		
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
