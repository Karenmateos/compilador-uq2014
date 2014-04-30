package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.SimboloLexico;

public class CicloWhile {
	
	SimboloLexico palabraWhile;
	SimboloLexico aperturaParentesis;
	ExpresionComparacion expresion;
	SimboloLexico cierreParentesis;
	CuerpoCiclo cuerpoCiclo;
	
	public CicloWhile(SimboloLexico palabraWhile, SimboloLexico aperturaParentesis, ExpresionComparacion expresion, SimboloLexico cierreParentesis, CuerpoCiclo cuerpoCiclo){
		this.palabraWhile = palabraWhile;
		this.aperturaParentesis = aperturaParentesis;
		this.expresion = expresion;
		this.cierreParentesis = cierreParentesis;
		this.cuerpoCiclo = cuerpoCiclo;
		
	}
	
	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Ciclo While");

		if(palabraWhile != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(palabraWhile.getLexema()));
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
		
		if(cuerpoCiclo != null){
			miRaiz.add(cuerpoCiclo.getArbolVisual());
		}

		return miRaiz;
	}
	

}
