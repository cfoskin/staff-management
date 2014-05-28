
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestPerson {
    Person mary, john;
	@Before
	public void setUp() throws Exception {
		mary = new Person("Mary", "Lecturer", true);
		john = new Person("John", "HRManager", false);
	
	}

	@Test
	public void testPerson() {
		assertEquals(mary.getName(), "Mary");
		assertEquals(mary.getJobTitle(), "Lecturer");
		assertEquals(mary.getAcademic(), true);
		assertEquals(john.getName(), "John");
		assertEquals(john.getJobTitle(), "HRManager");
		assertEquals(john.getAcademic(), false);
	}

	@Test
	public void testSetandGetName() {
		assertEquals(mary.getName(), "Mary");
		mary.setName("Maire");
		assertEquals(mary.getName(), "Maire");
		
	}

	@Test
	public void testSetandGetJobTitle() {
		assertEquals(mary.getJobTitle(), "Lecturer");
		mary.setJobTitle("Researcher");
		assertEquals(mary.getJobTitle(), "Researcher");
		
	}

	@Test
	public void testSetandGetAcademic() {
		assertEquals(mary.getAcademic(), true);
		mary.setAcademic(false);
		assertEquals(mary.getAcademic(), false);
		mary.setAcademic(true);
		assertEquals(mary.getAcademic(), true);
	}

	

	@Test
	public void testToString() {
		assertFalse(mary.toString().startsWith("&"));
	}

}