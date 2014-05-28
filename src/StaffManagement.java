
import java.util.ArrayList;

/**
 * This is a class that stores and maintains the staff 
 * management system in WIT.
 * @author Colum Foskin
 * @version 1
 * I have changed the menu system as stated in the extra credit section. 
 * It now prints a menu which calls the other  sub menus and looks tidier.
 *  
 */

public class  StaffManagement 
{
	private ArrayList<Department> departments;
	private ArrayList<Person> allStaff;
	Person mary, jimmy, michael, lucy, richard, john, ann;
	Department hr, cmp;

	/**
	 * Constructor for objects of class StaffManagement
	 */
	public StaffManagement()

	{

		allStaff = new ArrayList<Person>();
		departments = new ArrayList<Department>();

		mary = new Person("Mary", "Lecturer", true);

		jimmy = new Person("Jimmy", "Researcher", true);

		michael = new Person("Michael", "Lecturer", true);

		lucy = new Person("Lucy", "Lecturer", true);

		richard =  new Person("Richard", "Lecturer", true);

		john = new Person("John", "HRManager", false);

		ann = new Person("Ann", "Admin", false);

		allStaff.add(mary);
		allStaff.add(jimmy);
		allStaff.add(michael);
		allStaff.add(lucy);
		allStaff.add(richard);
		allStaff.add(john);
		allStaff.add(ann);

		cmp = new Department("Computing, Mathematics & Physics", "Micheal" );
		cmp.addStaff(mary);
		cmp.addStaff(jimmy);
		cmp.addStaff(michael);
		cmp.addStaff(lucy);
		cmp.addStaff(richard);
		cmp.addStaff(john);
		departments.add(cmp);
		hr = new Department("Human Resources", "Neil");
		hr.addStaff(john);  
		hr.addStaff(ann);
		departments.add(hr);


	}
	public ArrayList<Department> getDepartments()
	{
		return departments;
	}
	public void setDepartments(ArrayList<Department> departments)
	{
		departments= new ArrayList<Department>();
	}

	public ArrayList<Person> getAllStaff()
	{
		return allStaff;
	}
	public void setAllStaff(ArrayList<Person> allStaff)
	{
		allStaff= new ArrayList<Person>();
	}


	/** adds staff to the allStaff array 
	 * list of People.
	 * 
	 */
	private void addStaff()
	{
		StdOut.print("Enter Name of staff to add:");
		String personName=StdIn.readString(); 
		StdOut.print("Enter title of staff to add:");
		String personTitle=StdIn.readString(); 
		StdOut.print("Enter 0 or 1:");
		Boolean personAcademic=StdIn.readBoolean(); 
		Person person = new Person(personName, personTitle, personAcademic);
		allStaff.add(person);
	} 


	/**
	 *  listStaff() - This method prints the index number 
	 *  and the details of each element in the staff      
	 *  ArrayList to the console.
	 */
	public void listStaff()
	{
		if(allStaff.size()>0)
		{
			for(int i=0; i<allStaff.size(); i++ )
			{
				StdOut.println(i + ":" +  allStaff.get(i));       
			}
		}
		else
		{ 
			StdOut.println("No staff");
		}
	}


	/**
	 * editStaff Member() - This method lists all the stored * staff members, asks the user to select
	 * one to edit and enters the new details, and updates the 
	 * selected object in the ArrayList. 
	 */
	public void editStaffMember()
	{
		int staffIndex=0;
		listStaff();
		StdOut.println("Enter the index of the staff you wish to edit");
		staffIndex=StdIn.readInt();
		StdOut.println("Enter the name of the staff member");
		Person person = allStaff.get(staffIndex);
		String newTitle=StdIn.readString();
		person.setName(newTitle);
	}

	/**
	 * deleteStaffMember() - This method lists all the stored staff members, asks the user to 
	 * select one to delete and removes it from the ArrayList. 
	 */
	public void deleteStaffMember()
	{
		int staffIndex=0;
		listStaff();   	
		StdOut.println("Enter the index of the staff member you wish to delete");
		staffIndex=StdIn.readInt();
		allStaff.get(staffIndex);
		StdOut.print("delete staff (y/n)?");
		String deletePerson = StdIn.readString();
		if (deletePerson.equals("y") && staffIndex <= allStaff.size())
		{
			allStaff.remove(staffIndex);
		}
	}

	/**
	 * addCourse() - This method creates a Department and adds  * it to the courses ArrayList.  
	 */     
	public void addDepartment()
	{
		StdOut.println("Enter the title of the new department");
		String departmentTitle=StdIn.readString(); 
		StdOut.println("Enter the title of the new manager");
		String managerTitle=StdIn.readString();
		Department department = new Department(departmentTitle, managerTitle);  
		departments.add(department);
	}


	/**listDepartments() - This method lists all of the departments */

	public void listDepartments()
	{
		if(departments.size()>0)
		{
			for(int i=0; i<departments.size(); i++ )
			{
				StdOut.println(i + ":" + departments.get(i).getTitle() + "\n");
			}
		}
		else
		{ 
			StdOut.println("No departments");
		}

	}


	/**
	 * listDepartmentContents() - This method lists all of the staff in a selected department
	 * stored in the ArrayList. */

	public void listDepartmentContents()
	{
		listDepartments();
		StdOut.println("Enter the index of the department whose staff you wish to view");
		int index=StdIn.readInt();
		Department viewDepartment = departments.get(index);
		StdOut.println(viewDepartment);
		for (int i = 0; i < viewDepartment.nmrStaff(); i++)
		{
			StdOut.println(viewDepartment.getStaff(i));
		}
	}

	/**
	 * editDepartment() - This method asks the user to select one department from all
	 * of the departments (via index).  The user is   then allowed to 
	 * add any number of staff  to their selected department and repeatedly asks user y/n until no is answered*/

	public void editDepartment()
	{
		listDepartments();
		StdOut.println("Enter the index of the department you wish to view");
		int index=StdIn.readInt();
		Department viewDepartment = departments.get(index);
		StdOut.print("Add staff (y/n)?");
		String addPerson = StdIn.readString();  
		while (addPerson.equals("y"))
		{
			listStaff();
			StdOut.print("Select staff member ==>");
			int personIndex = StdIn.readInt();
			Person selectedStaff = allStaff.get(personIndex);
			viewDepartment.addStaff(selectedStaff);
			StdOut.print("Add a staff member (y/n)?");
			addPerson = StdIn.readString();
		} 
	}

	/**
	 * deleteDepartments() - This method lists all of the departments,
	 * and allows the user to select one and delete it. The index must be valid.*/

	public void deleteDepartment()
	{ 
		int index= 0;
		listDepartments();
		StdOut.println("Enter the index of the department you want to delete");
		index=StdIn.readInt();
		StdOut.print("are u sure (y/n)?");
		departments.get(index);  
		String deleteDepartment = StdIn.readString();
		if (deleteDepartment.equals("y") && index <= departments.size())
		{
			departments.remove(index);
		}

	}



	/**
	 * listBigDepartments() - This method lists all of the departments ('big' is defined as having 
	 * more than 5 staff members)
	 **/
	public void listBigDepartments()
	{
		if(departments.size()>0)
		{
			for(int i=0; i<departments.size(); i++ )
			{
				if(departments.get(i).getStaff().size() > 5)
					StdOut.println(departments.get(i) + "\n");       
			}
		}
		else
		{ 
			StdOut.println("No big departments");
		}

	}

	/**lists academic departments if it contains at least 1 academic.
	 * 
	 */
	public void listAcademicDepartments()
	{ 
		boolean isAcademic= false;
		if(departments.size()>0)
		{
			for(int i=0; i<departments.size(); i++ )
			{
				isAcademic= false;
				ArrayList <Person> depStaff = departments.get(i).getStaff();
				
				for(int j=0; j< depStaff.size();j++)
				{	
					if(depStaff.get(i).getAcademic()==true)
					{
						isAcademic = true;
					}
				}
				if (isAcademic) 
				StdOut.println(departments.get(i) + "\n");       
			}
		}
		else
		{ 
			StdOut.println("No academic departments");
		}
	}




	/** save() - This method saves the contents of the staff ArrayList to 
	 *  an XML file called "alStaff.xml"
	 */
	public void save()
	{
		StdStream.saveToFile(allStaff, "myStaffMembers.xml"); 
	}

	/**
	 * load() - This method reads the contents of the XML file called 
	 * "allStaff.xml" stored in the project directory.  The contents are 
	 * casted as an ArrayList of Person's and stored in the staff management object.  
	 * */
	public void load()
	{
		allStaff = (ArrayList<Person>) StdStream.readFromFile("myStaffMembers.xml");
	}


	/** calls the main run method runMain()
	 * 
	 */
	public static void main(String[] argvs)
	{
		StaffManagement app = new StaffManagement();
		app.runMain();
	}

	/** I have changed the menu system as stated in the extra credit section. 
	 * It now prints a menu which calls the other  sub menus and looks tidier.
	 * 
	 */
	public void runMain()
	{
		int option= subMenu();
		while (option!=0) 
		{
			switch(option)   
			{  
			case 1 :
				run1();
				break;
			case 2 :
				run2();
				break;
			case 3 :
				run3();
				break;
			case 4 :
				run4();
				break;
			default:
				break;
			}	  
			option=subMenu();
		} 
		StdOut.println("Exiting... bye");    
	}

	public void run1()
	{
		int option=menu1();
		while (option!=0) 
		{
			switch(option)
			{
			case 1 :
				addStaff();	    	       
				break;
			case 2 :
				listStaff();
				break;
			case 3 :
				editStaffMember();
				break;
			case 4 :
				deleteStaffMember();
				break;
			default : 
				break;
			} option=menu1();      
		}
	}

	public void run2()
	{
		int option=menu2();
		while (option!=0) 
		{
			switch(option)
			{
			case 1 :
				addDepartment();
				break;
			case 2 :
				listDepartments();
				break;
			case 3 :
				listDepartmentContents();
				break;
			case 4 :
				editDepartment();
				break;
			case 5 :
				deleteDepartment();
				break;
			default : 
				break;
			}      
			option=menu2();
		}
	}
	public void run3()
	{
		int option=menu3();
		while (option!=0) 
		{
			switch(option)
			{
			case 1 :
				listBigDepartments();
				break;
			case 2 :
				listAcademicDepartments();
				break;
			default : 
				break;
			} 
			option=menu3();   
		}
	}

	public void run4()
	{
		int option=menu4();
		while (option!=0) 
		{
			switch(option)
			{
			case 1 :
				save();    	 	
				break;
			case 2 :
				load();
				break;
			default : 
				break;
			} 
			option=menu4();   
		}
	}

	private int subMenu()
	{
		StdOut.println("Staff Management Menu" + "\n" + "--------------" + "\n" + "1. Manage Staff Members" + "\n" + "2. Manage Departments" + "\n" + "3. Reports" + "\n" + "4. Save and Load Staff Member Details" + "\n" + "o. Exit");
		StdOut.println("--------------");
		int optionA= StdIn.readInt();
		return optionA;
	}
	private int menu1()
	{
		StdOut.println("STAFF" + "\n");
		StdOut.println("--------------" + "\n");
		StdOut.println("1. Add staff member" + "\n" + "2. List staff members" + "\n" + "3. Edit staff member" + "\n" + "4. Delete a staff member" + "\n" + "0. Exit");    	
		StdOut.println("--------------" + "\n");
		int choice= StdIn.readInt();
		return choice;
	}
	private int menu2()
	{
		StdOut.println("DEPARTMENT" + "\n");
		StdOut.println("--------------" + "\n");
		StdOut.println( "1. Add a department" + "\n" + "2. List all departments" + "\n" + "3. list department staff" + "\n" + "4. Edit department contents" + "\n" + "5. Delete a department" + "\n" + "0. Exit");
		StdOut.println("--------------" + "\n");
		int choice= StdIn.readInt();
		return choice;
	}
	private int menu3()
	{
		StdOut.println("REPORTS" + "\n");
		StdOut.println("--------------");
		StdOut.println("1. List all departments that have more then 5 staff members" + "\n" + "2. List all the academic departments (ie: those with at least one academic staff members" + "\n" + "0. Exit");
		StdOut.println("--------------" + "\n");
		int choice= StdIn.readInt();
		return choice;
	}

	private int menu4()
	{
		StdOut.println("SAVE AND LOAD" + "\n");
		StdOut.println("--------------");
		StdOut.println("1. Save staff member details only" + "\n" + "2 Load staff members details only" + "\n"	 + "0. Exit");
		int choice= StdIn.readInt();
		return choice;
	}
}
