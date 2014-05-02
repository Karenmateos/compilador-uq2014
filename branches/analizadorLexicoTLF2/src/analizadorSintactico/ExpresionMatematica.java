package analizadorSintactico;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.xml.internal.bind.v2.model.core.ID;

import analizadorLexico.Configuracion;
import analizadorLexico.SimboloLexico;

/**
*
* @author Jorge Leonardo Aguirre Martinez
* @author Luis Alberto Delgado Ortiz
* 
* GIC: <ExprecionMatematica> ::= <IdVariable> <Operacion> | <valor> <Operacion> 
*/
public class ExpresionMatematica {

	// Variable que almacema el id de variable
	SimboloLexico idVariable = null;
	// Variable que almacema un ArrayList de operaciones
	ArrayList<Operacion> operaciones= null;

	/**
	 * Constructor, permite crear objetos de tipo ExpresionMatematica
	 * @param idVariable
	 * @param operaciones
	 */
	public ExpresionMatematica(SimboloLexico idVariable, ArrayList<Operacion> operaciones){
		this.idVariable = idVariable;
		this.operaciones = operaciones;
	}

	/**
	 * Metodo que permite obtener el arbol sintactico de la clase
	 * @return el arbol sintactico de la clase
	 */
	public DefaultMutableTreeNode getArbolVisual(){

		// Variable que almacema un objeto de tipo DefaultMutableTreeNode
		DefaultMutableTreeNode miRaiz = new DefaultMutableTreeNode(Configuracion.expresionMatematica);

		if(idVariable!=null){
			miRaiz.add(new DefaultMutableTreeNode(idVariable.getLexema() + Configuracion.dosPuntos + idVariable.getTipo()));
			System.out.println("paso idV");
		}

		if(operaciones!=null && operaciones.size()>0){
			System.out.println("pase");
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(Configuracion.operaciones);

			for(Operacion operacion: operaciones){				
				nodo.add(operacion.getArbolVisual());
			}			
			miRaiz.add(nodo);		

		}	

		return miRaiz;
	}

}
