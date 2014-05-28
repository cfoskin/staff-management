import java.util.ArrayList;

/**
 * This is a  class that stores and maintains the info of a 
 * department
 * @author Colum Foskin.
 * @version 1
 */
public class Department
{
	private ArrayList<Person> staff;
	private String title;
	private String manager;


	/**
	 * Constructor for objects of class Course
	 */
	public Department(String title, String manager)
	{
		staff= new ArrayList<Person>();
		this.title=title;
		this.manager= manager;
	}



	public ArrayList<Person> getStaff()
	{
		return staff;
	}


	/**
	 * getStaff(..) - This method returns a staff member based on 
	 * the integer index passed as its parameter. 
	 */
	public Person getStaff(int i)
	{
		return staff.get(i);  
	}




	/**
	 * addstaff() - This method accepts a parameter of type staff 
	 * and adds it to the collection of staff  
	 */
	
	public void addStaff(Person person)
	{
		staff.add(person);
	}


	/**
	 * nmrStaff() - This method returns the number of staff 
	 * members in the department
	 * @return     the number of staff members in the department 
	 */
	public int nmrStaff()
	{
		return staff.size();
	}



	public ArrayList<Person> getDepartmentStaff()
	{
		return staff;

	}

	/**
	 * @param departmentStaff
	 */
	public void setDepartmentStaff(ArrayList<Person> departmentStaff)
	{
		this.staff= departmentStaff;
	}


	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}

	public String getManager()
	{ 
		return manager;
	}    
	public void setManager(String manager)
	{
		this.manager= manager;
	}
	/**
	 * toString() - This method returns the String version of the 
	 * department object.
	 * @return     the string version of the department object.
	 */
	public String toString()
	{
		return title + manager;
	}






}
