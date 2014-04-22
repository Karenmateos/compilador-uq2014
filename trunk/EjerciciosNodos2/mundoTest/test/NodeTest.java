package test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import mundo.DataStructuresException;
import mundo.Node;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testNode() {

		Node<Integer> a =new Node<Integer>();
		Node<Integer> b =new Node<Integer>();
		Assert.assertNotNull(a);
		Assert.assertNotNull(b);

	}

	@Test
	public void testNodeInformation() {

		Node<Integer> a =new Node<Integer>(5);
		Node<String> b =new Node<String>("6");
		Assert.assertEquals( new Integer(5), a.getData());
		Assert.assertEquals("6", b.getData());
	}

	@Test
	public void testNodeInformationString() {

		Node<Integer> a =new Node<Integer>(5, "loquesea");
		Node<String> b =new Node<String>("6", "otracosa");
		Assert.assertEquals("loquesea", a.getName());
		Assert.assertEquals("otracosa", b.getName());

	}

	@Test
	public void testNodeInformationStringInt() {

		Node<Integer> a =new Node<Integer>(5, "loquesea" , 0);
		Node<String> b =new Node<String>("6", "otracosa", 4);
		Assert.assertEquals( 0, a.getMaxPorts());
		Assert.assertEquals(4, b.getMaxPorts());
		Assert.assertEquals(1, b.getSize());
	}

	@Test
	public void testSetData() {
		
		Node<Integer> a =new Node<Integer>(5);
		Node<String> b =new Node<String>("6");
		a.setData(3);
		b.setData("hola");
		Assert.assertEquals(new Integer(3), a.getData());
		Assert.assertEquals("hola", b.getData());
	}

	@Test
	public void testGetData() {
		
		Node<Integer> a =new Node<Integer>(3);
		Node<String> b =new Node<String>("hola");
		Assert.assertEquals(new Integer(3), a.getData());
		Assert.assertEquals("hola", b.getData());

	}

	@Test 
	public void testGetSize() throws DataStructuresException {
		
		Node<Integer> a =new Node<Integer>(3);
		a.link(a, 0);
		a.link(a, 1);
		a.link(a, 2);
		Assert.assertEquals(3, a.getSize());
	}
	
	//Comprueba que se lanza la Excepcion	
	@Test (expected = DataStructuresException.class)
	public void testLink() throws DataStructuresException {
		
		Node<Integer> a =new Node<Integer>(3);
		Node<Integer> b =new Node<Integer>(3);
		a.link(a, -1);
		
	}
		
	@Test
	public void testLink2() throws DataStructuresException {
		
		Node<Integer> a =new Node<Integer>(3);
		Node<Integer> b =new Node<Integer>(3);
		a.link(a, 0);
		a.link(b, 1);
		a.link(a, 2);
		Assert.assertEquals(b, a.followlink(1));
	}
	
	//Comprueba que se lanza la Excepcion
	@Test (expected = DataStructuresException.class)
	public void testUnlink() throws DataStructuresException {
		
		Node<Integer> a =new Node<Integer>(3);
		a.unlink(2);
	}
	
	@Test (expected = DataStructuresException.class)
	public void testUnlink2() throws DataStructuresException {
		
		Node<Integer> a = new Node<Integer>(3);
		a.link(a, 2);
		a.unlink(2);
		a.followlink(2);
	}

	@Test
	public void testIslinked() throws DataStructuresException{
		Node<Integer> a = new Node<Integer>(3);
		a.link(a, 0);
		a.link(a, 1);
		a.link(a, 2);
		Assert.assertEquals(true, a.islinked(1));
	}
	
	@Test (expected = DataStructuresException.class)
	public void testIslinked2() throws DataStructuresException{
		Node<Integer> a = new Node<Integer>(3);
		a.link(a, 0);
		a.link(a, 1);
		a.link(a, 2);
		Assert.assertEquals(a, a.islinked(-1));
	}

	@Test
	public void testFollowlink() throws DataStructuresException{
		Node<Integer> a = new Node<Integer>(3);
		a.link(a, 0);
		a.link(a, 1);
		a.link(a, 2);
		Assert.assertEquals(a, a.followlink(1));
	}

	@Test (expected = DataStructuresException.class)
	public void testFollowlink2() throws DataStructuresException{
		Node<Integer> a = new Node<Integer>(3);
		a.link(a, 0);
		a.link(a, 1);
		a.link(a, 2);
		Assert.assertEquals(a, a.followlink(3));
	}
	
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxPorts() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMaxPorts() {
		fail("Not yet implemented");
	}

}
