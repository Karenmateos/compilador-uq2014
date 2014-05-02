package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <WHILE> ::= “WHILE” “(“ <ExpresionComparacion> “)” <CuerpoCiclo>

*/
public class CicloWhile extends Sentencia{
	
	// Variable que almacema la palabra reservada del ciclo While
	SimboloLexico palabraWhile;
	// Variable que almacema la apaertura de parentesis
	SimboloLexico aperturaParentesis;
	// Variable que almacema un objeto de ExpresionComparacion
	ExpresionComparacion expresion;
	// Variable que almacema el cierre de parentesis
	SimboloLexico cierreParentesis;
	// Variable que almacema un objeto de tipo CuerpoCiclo
	CuerpoCiclo cuerpoCiclo;
	
	/**
	 * Constructor, permite crear objetos de tipo CicloWhile
	 * @param palabraWhile
	 * @param aperturaParentesis
	 * @param expresion
	 * @param cierreParentesis
	 * @param cuerpoCiclo
	 */
	public CicloWhile(SimboloLexico palabraWhile, SimboloLexico aperturaParentesis, ExpresionComparacion expresion, SimboloLexico cierreParentesis, CuerpoCiclo cuerpoCiclo){
		this.palabraWhile = palabraWhile;
		this.aperturaParentesis = aperturaParentesis;
		this.expresion = expresion;
		this.cierreParentesis = cierreParentesis;
		this.cuerpoCiclo = cuerpoCiclo;
		
	}
	
	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.cicloWhile);

		if(palabraWhile != null)
		{
			miRaiz.add(new DefaultMutableTreeNode(palabraWhile.getLexema() + Configuracion.dosPuntos + palabraWhile.getTipo()));
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
