package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* <Clase> ::= <ModificadorAcceso> <IdClase> <CuerpoClase>
*/
public class Clase {

	SimboloLexico modificadorAcceso;
	SimboloLexico idClase;
	CuerpoClase cuerpoClase;

	public Clase(SimboloLexico modificadorAcceso,SimboloLexico idClase, CuerpoClase cuerpoClase)
	{
		this.modificadorAcceso = modificadorAcceso;
		this.idClase = idClase;
		this.cuerpoClase = cuerpoClase;
	}

	public DefaultMutableTreeNode getArbolVisual(){

		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.declaracionClase);

		if(modificadorAcceso != null){
			miRaiz.add(new DefaultMutableTreeNode(modificadorAcceso.getLexema()));
		}

		if(idClase != null){
			miRaiz.add(new DefaultMutableTreeNode(idClase.getLexema()));
		}

		if(cuerpoClase != null){
			miRaiz.add(cuerpoClase.getArbolVisual());
		}

		return miRaiz;

	}

}
