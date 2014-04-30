package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

public class UnidadDeCompilacion {
	
	static DeclaracionClase declaracionClase;
	
	@SuppressWarnings("static-access")
	public UnidadDeCompilacion(DeclaracionClase declaracionClase) 
	{
		this.declaracionClase = declaracionClase;
	}
	
	public UnidadDeCompilacion() {}
	
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
