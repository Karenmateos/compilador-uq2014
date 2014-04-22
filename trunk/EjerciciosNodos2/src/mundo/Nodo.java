package mundo;

import java.util.Vector;


public class Nodo<Information>
{
	private Information data;
	private String name;
	private int maxPorts;

	private Vector<Node<Information>> links;

	public Nodo() {
		this(null, null, 0);
	} 

	public Nodo( Information valorInicial ) { //punto 1
		this(valorInicial,null, 0);
	} 

	public Nodo( Information valorInicial, String name ) { //punto 1
		this(valorInicial,name,0);
	} 

	public Nodo( Information valorInicial, String name, int ports ) { //punto 1
		this.maxPorts = ports;
		if( maxPorts == 0 ) {
			links=new Vector<Node<Information>>(1);
			links.setSize(1);
		}
		else {
			links=new Vector<Node<Information>>(maxPorts);
			links.setSize(maxPorts);
		}

		data = valorInicial;
		this.name = name;
	} 

	public void setData(Information data) {     
		this.data=data;

	}
	public Information getData(){
		return data;

	}
	public int getSize(){
		return links.size();

	}	   

	public void link(Node destination,int index) {
		//la posicion indice no existe en el vector de enlaces
		if( getMaxPorts() == 0 ) {
			if (index >=links.size()){
				// el vector crece y en las posiciones intermedias
				// se asigna null
				links.setSize(index+1);

			}
			links.set(index,destination);
		}
		else {
			if( index < links.size() ) {
				links.set(index,destination);
			}
		}
	}

	public void unlink(int index){
		links.set(index,null);

	}	   

	public boolean islinked(int index){
		return links.get(index)!=null;


	}
	public Node followlink(int index){
		return links.get(index);

	}
	public String toString(){
		return "El nodo " + name + " tiene: " + data;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPorts() {
		return maxPorts;
	}

	public void setMaxPorts(int maxPorts) {
		this.maxPorts = maxPorts;
	}	

}	   
