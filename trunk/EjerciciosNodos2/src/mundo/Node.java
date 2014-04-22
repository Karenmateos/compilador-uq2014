package mundo;

import java.util.Vector;


public class Node<Information>
{
	private Information data;
	private String name;
	private int maxPorts;

	private Vector<Node<Information>> links;

	public Node() {
		this(null, null, 0);
	} 

	public Node( Information valorInicial ) { //punto 1
		this(valorInicial,null, 0);
	} 

	public Node( Information valorInicial, String name ) { //punto 1
		this(valorInicial,name,0);
	} 

	public Node( Information valorInicial, String name, int ports ) { //punto 1
		this.maxPorts = ports;
		if( maxPorts == 0 ) {
			links=new Vector<Node<Information>>(1);
		}
		else {
			links=new Vector<Node<Information>>(maxPorts);
		}
		links.setSize(1);
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

	public void link(Node destination,int index) throws DataStructuresException {
		//la posicion indice no existe en el vector de enlaces
		if( getMaxPorts() == 0 ) {

			if(index < 0){
				throw new DataStructuresException(Constants.ERROR_01);
			}
			if (index >=links.size()){
				// el vector crece y en las posiciones intermedias
				// se asigna null
				links.setSize(index+1);

			}
			links.set(index,destination);
		}
		else {
			if( index < links.size() && index >= 0 ) {
				links.set(index,destination);
			}
			else {
				throw new DataStructuresException(Constants.ERROR_01);
			}			
		}
	}

	public void unlink (int index) throws DataStructuresException {
		
		if(index < 0 || index >= getSize())
		{
			throw new DataStructuresException(Constants.ERROR_01);
		}
		else if(links.get(index) == null){
			throw new DataStructuresException(Constants.ERROR_02);
		}
		
		links.set(index,null);

	}	   

	public boolean islinked(int index) throws DataStructuresException{
		
		if(index < 0 || index >= getSize())
		{
			throw new DataStructuresException(Constants.ERROR_01);
		}
		
		return links.get(index)!=null;


	}
	public Node followlink(int index) throws DataStructuresException{
		if(index < 0 || index >= getSize())
		{
			throw new DataStructuresException(Constants.ERROR_01);
		}
		
		if(links.get(index) == null){
			throw new DataStructuresException(Constants.ERROR_02);
		}
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

	public void setMaxPorts(int maxPorts) throws DataStructuresException {
		if( maxPorts < this.maxPorts ) {
			for(int i = maxPorts; i < links.size(); i++ ) {
				if( links.get(i) != null )
					throw new DataStructuresException(Constants.ERROR_03);
			}
			this.maxPorts = maxPorts;
			links.setSize(maxPorts);
		}
		else {
			this.maxPorts = maxPorts;
			links.setSize(maxPorts);
		}
	}	

}	   
