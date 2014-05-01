package analizadorSintactico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <SentenciaDecision> ::=  “WHEN” “(“ <ExpresionComparacion> “)” <CuerpoWHEN>
*/
import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

public class When extends Sentencia{
	SimboloLexico when;
	SimboloLexico aperturaParentesis;
	ExpresionComparacion expresion;
	SimboloLexico cierreParentesis;
	CuerpoWhen cuerpoWhen;
	
	public When(SimboloLexico when, SimboloLexico aperturaParentesis, ExpresionComparacion expresion, SimboloLexico cierreParentesis, CuerpoWhen cuerpoWhen){
		this.when = when;
		this.aperturaParentesis = aperturaParentesis;
		this.expresion = expresion;
		this.cierreParentesis = cierreParentesis;
		this.cuerpoWhen = cuerpoWhen;
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.when);

		if(when != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(when.getLexema()));
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
