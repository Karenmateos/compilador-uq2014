package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

public class UnidadCompilacion {

	static DeclaracionClase declaracionClase;

	@SuppressWarnings("static-access")
	public UnidadCompilacion(DeclaracionClase declaracionClase) 
	{
		this.declaracionClase = declaracionClase;
	}

	public UnidadCompilacion() {}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Unidad de Compilaci�n");
		miRaiz.add(declaracionClase.getArbolVisual());

		return miRaiz;
	}

	public static DeclaracionClase getDeclaracionClase() {
		return declaracionClase;
	}   
}
