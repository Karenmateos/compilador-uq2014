package analizadorSintactico;

/**
 *
 * @author Jorge Leonardo Aguirre Martinez
 * @author Luis Alberto Delgado Ortiz
 * 
 * <SentenciaDecision> ::=  �WHEN� �(� <ExpresionComparacion> �)� <CuerpoWHEN>
 */
import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class When extends Sentencia{
	// Variable que almacema la palabra reservada del ciclo
	SimboloLexico when;
	// Variable que almacema la apertura de parentesis
	SimboloLexico aperturaParentesis;
	// Variable que almacema un objeto de tipo ExpresionComaparcion
	ExpresionComparacion expresion;
	// Variable que almacema el cierre de parentesis
	SimboloLexico cierreParentesis;
	// Variable que almacema un objeto de tipo CuerpoWhen
	CuerpoWhen cuerpoWhen;

	/**
	 * Constructor permite crear objetos de tipo When
	 * @param when
	 * @param aperturaParentesis
	 * @param expresion
	 * @param cierreParentesis
	 * @param cuerpoWhen
	 */
	public When(SimboloLexico when, SimboloLexico aperturaParentesis, ExpresionComparacion expresion, SimboloLexico cierreParentesis, CuerpoWhen cuerpoWhen){
		this.when = when;
		this.aperturaParentesis = aperturaParentesis;
		this.expresion = expresion;
		this.cierreParentesis = cierreParentesis;
		this.cuerpoWhen = cuerpoWhen;
	}

	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.when);

		if(when != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(when.getLexema() + Configuracion.dosPuntos + when.getTipo()));
		}

		if(aperturaParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(aperturaParentesis.getLexema()));
		}

		if(expresion != null){
			miRaiz.add(expresion.getArbolVisual());
		}

		if(cierreParentesis != null){
			miRaiz.add(new DefaultMutableTreeNode(cierreParentesis.getLexema()));
		}

		if(cuerpoWhen != null){
			miRaiz.add(cuerpoWhen.getArbolVisual());
		}

		return miRaiz;
	}
}
