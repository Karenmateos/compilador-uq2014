package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <Clase> ::= <ModificadorAcceso> <IdClase> <CuerpoClase>
*/
public class Clase {

	// Variable que almacema un modificador de acceso
	SimboloLexico modificadorAcceso;
	// Variable que almacema un id de clase
	SimboloLexico idClase;
	// Variable que almacema un objeto de tipo CuerpoClase
	CuerpoClase cuerpoClase;

	/**
	 * Constructor, permite crear objetos de tipo Clase
	 * @param modificadorAcceso
	 * @param idClase
	 * @param cuerpoClase
	 */
	public Clase(SimboloLexico modificadorAcceso,SimboloLexico idClase, CuerpoClase cuerpoClase)
	{
		this.modificadorAcceso = modificadorAcceso;
		this.idClase = idClase;
		this.cuerpoClase = cuerpoClase;
	}

	/**
	 * Metodo que genera el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual(){

		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.declaracionClase);

		if(modificadorAcceso != null){
			miRaiz.add(new DefaultMutableTreeNode(modificadorAcceso.getLexema() + Configuracion.dosPuntos + modificadorAcceso.getTipo()));
		}

		if(idClase != null){
			miRaiz.add(new DefaultMutableTreeNode(idClase.getLexema() + Configuracion.dosPuntos + idClase.getTipo()));
		}

		if(cuerpoClase != null){
			miRaiz.add(cuerpoClase.getArbolVisual());
		}

		return miRaiz;

	}

}
