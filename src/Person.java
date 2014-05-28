


/**
 * This is a module class that stores and maintains the info of a staff member
 * @author Colum Foskin
 * @version 1
 */

public class Person
{
	private String name;
	private String jobTitle;
	private boolean academic;

	/**
	 * Constructor for objects of class Module
	 */
	public Person(String name, String jobTitle,boolean academic)
	{
		this.name= name;
		this.jobTitle=jobTitle;
		this.academic=academic;
	}

	/**
	 * setName() - This mutator method sets the staff member’s name to 
	 * the value passed in as parameter.
	 * @param  title   the new staff member’s name
	 */
	public void setName(String name)
	{
		this.name= name;
	}

	/**
	 * setJobTitle() - This mutator method sets the jobTitle of the module to 
	 * the value passed in as parameter.
	 * @param  jobTitle   the new jobTitle of the module
	 */  
	public void setJobTitle(String jobTitle)
	{
		this.jobTitle=jobTitle;
	}

	/**
	 * setAcademic() - This mutator method sets the academic of the module to 
	 * either true or false.
	 * @param  academic   the new value (true or false) of whether or not the staff member is an academic.
	 */      
	public void setAcademic(boolean academic)
	{
		this.academic= academic;
	}   


	/**
	 * getName() 
	 * 
	 * @return     Staff member's name
	 */
	public String getName()
	{
		return name;
	}


	/**
	 * getJobTitle()  
	 * @return     jobTitle of staff member
	 */   
	public String getJobTitle()
	{
		return jobTitle;
	}

	/**
	 * getAcademic() 
	 * 
	 * @return     true if the staff member is an academic, false otherwise
	 */      
	public boolean getAcademic()
	{
		return academic;
	} 

	/**
	 * toString() - This method returns the details of the staff member’s  object
	 * 
	 * @return     the details of the staff member’s object
	 */
	public String toString()
	{
		return name + jobTitle + academic ;  

	}

}
