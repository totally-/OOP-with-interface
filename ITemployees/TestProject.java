

package ITemployees;

public class TestProject {

	public static void main(String[] args) {
		
		//create a new instance of Project
		Project project01 = new Project(20000, 14); 
		
		//create instances of Programmer and Tester to add them to the project
		Programmer programmer01 = new Programmer("Sam", 1234, 1000);
		Programmer programmer02 = new Programmer("Chris", 1111, 1200);
		Tester tester01 = new Tester("Todd", 2345, 700);
		Tester tester02 = new Tester("Dana", 3456, 750);
		
		//add some programmers and testers to the project
		project01.addEmployee(programmer01);
		project01.addEmployee(programmer02);
		project01.addEmployee(tester01);
		project01.addEmployee(tester02);
		
		
		//Do the project
		project01.doProject(); 
		
		//Report how long the project took to complete and whether it was finished on time
		System.out.println(project01);	
	
		
	} //end of main

} //end of class
