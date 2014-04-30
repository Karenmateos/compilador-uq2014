package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

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
			miRaiz.add(new DefaultMutableTreeNode(modificadorAcceso));
		}

		if(idClase != null){
			miRaiz.add(new DefaultMutableTreeNode(idClase));
		}

		if(cuerpoClase != null){
			miRaiz.add(cuerpoClase.getArbolVisual());
		}

		return miRaiz;

	}

}
