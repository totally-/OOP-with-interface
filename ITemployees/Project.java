
package ITemployees;

import ableToWorkInterface.AbleToWork;

import java.util.*;


public class Project {

	//Instance and class variables
	private int linesOfCode; //estimate of the number of codes the project will require
	private int duration; //the number of days the managers have allowed for completion of the project
	private List<AbleToWork> employees;  //list that stores employees associated with the project
	
	private int linesOfCodeWritten; //the total number of lines of code written by the programmers
	private int linesOfCodeTested; //the total number of lines of code that have been tested so far
	
	
	private int days; //the number of days given by managers for completion of the problem

	//Constructor
	public Project(int linesOfCode, int duration){
		
		this.linesOfCode = checkLinesOfCode(linesOfCode);
		this.duration = checkDuration(duration);
		this.employees = new ArrayList<AbleToWork>();
		
	} //end of constructor

	//Alternate Constructor
	public Project(int linesOfCode, int duration, List<AbleToWork> employees){
	
		this.linesOfCode = checkLinesOfCode(linesOfCode);
		this.duration = checkDuration(duration);
		addEmployees(employees);
		
		
	} //end of constructor

	//set linesOfCode
	public void setLinesOfCode(int linesOfCode){
		this.linesOfCode = linesOfCode;
	} //end of setLinesOfCode

	// set the lines of code written
	//this is private because the value of linesOfCodeWritten is calculated by the doProject method of this class
	private void setLinesOfCodeWritten(int linesOfCodeWritten){
		this.linesOfCodeWritten = linesOfCodeWritten;
	} //end of setLinesOfCodeWritten

	// set the lines of code tested
	//this is private because the value of linesOfCodeTested is calculated by the doProject method of this class
	private void setLinesOfCodeTested(int linesOfCodeTested){
		this.linesOfCodeTested = linesOfCodeTested;
	} //end of setLinesOfCodeTested

	//set the duration
	public void setDuration(int duration){
		this.duration = duration;
	} //end of setDuration

	//add an employee to the generic list named 'employees' of type AbleToWork
	public void addEmployee(AbleToWork employee){
		employees.add(employee);
	} //end of addEmployee
	
	public void addEmployees(List<AbleToWork> employees){
		List<AbleToWork> list = new ArrayList<AbleToWork>();
		for(AbleToWork employee : employees){
			list.add(employee);
		} //end of for-each loop
		this.employees = list;
	} //end of addEmployee

	//get linesOfCode
	public int getLinesOfCode(){
		return linesOfCode;
	} //end of getLinesOfCode

	//get linesOfCodeWritten
	public int getLinesOfCodeWritten(){
		return linesOfCodeWritten;
	} //end of getLinesOfCodeWritten

	//get linesOfCodeTested
	public int getLinesOfCodeTested(){
		return linesOfCodeTested;
	} //end of getLinesOFCodeTested

	//get the duration
	public int getDuration(){
		return duration;
	} //end of getDuration
	
	public List<AbleToWork> getEmployees(){
		return employees; //return the memory address of employees List of type AbleToWork
	} //end of getEmployees
	
	private static void advanceInputStream(int num, Scanner console){
		if(console.hasNextInt()){ //console.hasNextInt() returns true if the next token in the console's 
		//input can be interpreted as an int value
			num = console.nextInt();
		} //end of if	
		else{
			console.next(); //advance the input stream to prevent infinite loop
		} //end of else
	} //end of advanceInputStream

	//check linesOfCode for bad input
	private int checkLinesOfCode(int linesOfCode){
		Scanner console = new Scanner(System.in);
		while(linesOfCode <= 0){
			try{

				System.out.println("Invalid input. Please enter a value for linesOfCode greater than 0");
				linesOfCode = console.nextInt();
			} //end of try
			catch(Exception e){
				advanceInputStream(linesOfCode, console);
				System.out.println("checkLinesOfCode method: " + e);
			} //end of catch
		} //end of while
		return linesOfCode;
	} //end of checkLinesOfCode

	//check duration for bad input
	private int checkDuration(int duration){
		Scanner console = new Scanner(System.in);
		while(duration <= 0){
			try{
				System.out.println("Invalid input. Please enter a value for duration greater than 0");
				duration = console.nextInt();
			} //end of if	

			catch(Exception e){
				advanceInputStream(duration, console);
				System.out.println("checkDuration method: " + e);
			} //end of catch
		} //end of while
		return duration;
	} //end of checkDuration

	//calculate whether the project was completed on time or not, print out if it was or was not, and return the number of days it took to complete
	public int doProject(){

		int programmerObj = 0; //used to determine the number of Programmer objects in the generic list named 'employees' of type AbleToWork
		int testerObj = 0; //used to determine the number of Tester objects in the generic list named 'employees' of type AbleToWork

		//Determine the number of programmers and testers working on the project
		for(AbleToWork obj : employees){
			if(obj instanceof Programmer){
				programmerObj++;
			} //end of if
			else if(obj instanceof Tester){
				testerObj++;
			} //end of else if
		} //end of for loop

		//test to see if there is at least one programmer and at least one tester working on the project
		if(programmerObj == 0 || testerObj == 0){
			System.out.println("Unable to determine time needed to complete project. \n"
					+ "There must be at least one programmer and at least one tester.");
			return -1; //exit the doProject method and return -1 if there is not at least one programmer and at least one tester
			//working on the project
		} //end of if


		int days = 0; //used to represent the number of days it took to complete the project
		int dailyLinesOfCodeWritten = 0; //lines of code written per day
		int dailyLinesOfCodeTested = 0; //lines of code tested per day
		int totalLinesOfCodeWritten = 0; //total lines of code written (dependent upon random value variable and control statement of while loop, so this
		//value is an approximation that will meet or conservatively exceed the value of linesOfCode)
		int totalLinesOfCodeTested = 0; //total lines of code tested //total lines of code written (dependent upon random value variable and control
		//statement of while loop, so this value is an approximation that will meet or conservatively exceed the value of linesOfCode)


		//Determine the number of days required to complete the project
		//NOTE: the project is considered complete when both totalLinesOfCodeWritten AND totalLinesOfCodeTested are equal to linesOfCode
		//however, because we are using approximations with random values, both these values will rarely, if ever, be equal to linesOfCode but
		// will tend to slightly exceed it instead.
		//The project is considered finished when both totalLinesOfCodeWritten AND totalLinesOfCodeTested are greater than or equal to linesOfCode.
		while(totalLinesOfCodeWritten < linesOfCode || totalLinesOfCodeTested < linesOfCode){ 
			for(AbleToWork obj: employees){
				if(obj instanceof Programmer){
					if(totalLinesOfCodeWritten < linesOfCode){
						dailyLinesOfCodeWritten = obj.work(((Programmer) obj).getLinesOfCodeExpected());
						totalLinesOfCodeWritten += dailyLinesOfCodeWritten;
					} //end of nested if
				} //end of if
				else if(obj instanceof Tester){
					if(totalLinesOfCodeTested < linesOfCode){
						dailyLinesOfCodeTested = obj.work(((Tester) obj).getLinesOfCodeTestedPerDay());
						totalLinesOfCodeTested += dailyLinesOfCodeTested;
					} //end of nested if
				} //end of else if
			} //end of for loop	
			days++; //increment the number of days
		} //end of while loop

		setLinesOfCodeWritten(totalLinesOfCodeWritten); //set the totalLinesOfCodeWritten
		setLinesOfCodeTested(totalLinesOfCodeTested); //set the totalLinesOfCodeTested

		this.days = days;
		return days; //return the number of days it took to complete the project
	} //end of doProject

	public String toString(){ //----------------------------------------------------------

		String strEmployees = "";
		for(AbleToWork obj : employees){
			if(obj instanceof Programmer){
				strEmployees += ((Programmer) obj).getName() + "\n"; 
			} //end of if
			else if(obj instanceof Tester){
				strEmployees += ((Tester) obj).getName() + "\n";
			} //end of else
		} //end of for-each loop

		//Days needed to complete the project
		String daysNeeded;
		if(days == 0){ //NOTE: days will always = 0 if doProject method was never called
			daysNeeded = "Undetermined. Must execute doProject method to determine the number of days needed to complete the project";
		} //end of if
		else{
			daysNeeded = Integer.toString(days);
		} //end of else

		//if the project was never started
		String finished;
		if(linesOfCodeWritten == 0 && linesOfCodeTested == 0){
			finished = "Project never started. Cannot determine if project was completed on time if doProject method was never exectued.";
		} //end of if
		else if(linesOfCodeWritten > 0 && linesOfCodeTested > 0 && days <= duration){ //if the project was completed on time
			finished = "The project was completed on time.";
		} //end of else-if
		else{
			finished = "The project was NOT completed on time."; //if the project was not completed on time
		} //end of else

		
		String projectData = "Lines of Code: " + linesOfCode
				+ "\nLines of Code Written: " + linesOfCodeWritten
				+ "\nLines of Code Tested: " + linesOfCodeTested
				+ "\nDuration: " + duration
				+ "\nDays Needed to finish project: " + daysNeeded
				+ "\n" + finished
				+ "\nEmployees: \n" + strEmployees;

		return projectData;

	} //end of toString

} //end of Project class
