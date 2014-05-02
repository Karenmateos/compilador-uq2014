package analizadorSintactico;

import javax.swing.tree.DefaultMutableTreeNode;

import analizadorLexico.Configuracion;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <UnidadCompilacion> ::=  <Clase>
*/
public class UnidadCompilacion {

	static Clase clase;

	@SuppressWarnings("static-access")
	public UnidadCompilacion(Clase clase) 
	{
		this.clase = clase;
	}

	/**
	 * Constructor permite crear objetos vacios de la clase UnidadCompilacion
	 */
	public UnidadCompilacion() {}

	/**
	 * Metodo que retorna el arbol sintactico de la clase
	 * @return
	 */
	public DefaultMutableTreeNode getArbolVisual()
	{
		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.unidadCompilacion);
		miRaiz.add(clase.getArbolVisual());

		return miRaiz;
	}

	/**
	 * Metodo para acceder a la declaracion clase
	 * @return un obejto de tipo Clase
	 */
	public static Clase getDeclaracionClase() {
		return clase;
	}   
}
