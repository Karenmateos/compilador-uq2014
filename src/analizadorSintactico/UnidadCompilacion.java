package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

public class UnidadCompilacion {

	static Clase clase;

	@SuppressWarnings("static-access")
	public UnidadCompilacion(Clase clase) 
	{
		this.clase = clase;
	}

	public UnidadCompilacion() {}

	public DefaultMutableTreeNode getArbolVisual()
	{
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode("Unidad de Compilacion");
		miRaiz.add(clase.getArbolVisual());

		return miRaiz;
	}

	public static Clase getDeclaracionClase() {
		return clase;
	}   
}
