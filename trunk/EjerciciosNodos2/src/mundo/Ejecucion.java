package mundo;

public class Ejecucion {
	
	
	public static void main(String[] args) throws DataStructuresException{
		String ad = "ad";
		Node<Integer>a,b,c,d;
	    
		
		
	    a=new Node<Integer>(7, ad , 0);
	    b=new Node<Integer>();
	    c=new Node<Integer>();
	    d=new Node<Integer>();
	    
	   // a.setData(7);
	    b.setData(3);
	    c.setData(6);
	    d.setData(1);
	    
	    a.link(b, 0);
	    a.link(c, 1);
	    
	    b.link(c, 0);
	    
	    c.link(b, 1);
	    c.link(d, 2);
	    
	    d.link(a, 0);
	    
	    a.link(b.followlink(0), 2);
	    
	    d.followlink(0).unlink(1);
	    
	    c.link(b.followlink(0).followlink(2).followlink(0),1);
	    
	    System.out.println(a);
	    System.out.println(a.followlink(0));
	    try {
	    	System.out.println(a.followlink(1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    
	    System.out.println(a.followlink(2));
		
		

	}

}
