package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

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
		
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Clase");
		
		miRaiz.add(new DefaultMutableTreeNode(modificadorAcceso));
		miRaiz.add(new DefaultMutableTreeNode(idClase));
		
		miRaiz.add(cuerpoClase.getArbolVisual());

		return miRaiz;

	}
	
}
