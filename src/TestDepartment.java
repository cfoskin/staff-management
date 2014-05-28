import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestDepartment {
	Person mary, jimmy, michael, lucy, richard, ann,  john;
	Department cmp, hr;
	@Before
	public void setUp() throws Exception {
		mary = new Person("Mary", "Lecturer", true);
		jimmy = new Person("Jimmy", "Researcher", true);
		michael = new Person("Michael", "Lecturer", true);
		lucy = new Person("Lucy", "Lecturer", true);
		richard =  new Person("Richard", "Lecturer", true);
		john = new Person("John", "HRManager", false);
		ann = new Person("Ann", "Admin", false);
		
		cmp = new Department("Computing, Mathematics & Physics", "Micheal" );
		cmp.addStaff(mary);
		cmp.addStaff(jimmy);
		cmp.addStaff(michael);
		cmp.addStaff(lucy);
		cmp.addStaff(richard);
		
		hr = new Department("Human Resources", "Neil");
		hr.addStaff(john);
		hr.addStaff(ann);
		
	}

	@Test
	public void testDepartment() {
		assertEquals(cmp.getTitle(), "Computing, Mathematics & Physics");
		assertEquals(cmp.getManager(), "Micheal");
		assertNotNull(cmp.getDepartmentStaff());
	}

	@Test
	public void testAddStaff() {
		assertEquals(cmp.nmrStaff(), 5);
		cmp.addStaff(john);
		assertEquals(cmp.nmrStaff(), 6);
		assertEquals(cmp.getStaff(5).getName(), "John");
	}

	@Test
	public void testGetandSetStaff() {
		assertEquals(cmp.getStaff(0).getName(), "Mary");
		assertEquals(cmp.getStaff(0).getJobTitle(), "Lecturer");
		assertEquals(cmp.getStaff(0).getAcademic(), true);
		cmp.setDepartmentStaff(hr.getDepartmentStaff());
		assertEquals(cmp.nmrStaff(), 2);
		assertEquals(cmp.getStaff(0).getName(), "John");
		
	}

	@Test
	public void testNmrStaff() {
		assertEquals(cmp.nmrStaff(), 5);
		assertEquals(hr.nmrStaff(), 2);
	}

	

	@Test
	public void testGetSetTitle() {
		assertEquals(cmp.getTitle(),"Computing, Mathematics & Physics");
		cmp.setTitle("CMP");
		assertEquals(cmp.getTitle(),"CMP");
		
	}
		

	@Test
	public void testGetSetManager() {
		assertEquals(cmp.getManager(),"Micheal");
		cmp.setManager("MoH");
		assertEquals(cmp.getManager(),"MoH");
		
	}


	@Test
	public void testToString() {
		assertFalse(cmp.toString().startsWith("&"));

	}

}