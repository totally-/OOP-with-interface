

package ITemployees;

import ableToWorkInterface.AbleToWork;
import java.util.*;

public class Tester implements AbleToWork{

	//Instance and class variables
	private String testerName; //the tester's name
	private int testerID; //the tester's ID number
	private int linesOfCodeTestedPerDay; //the number of lines of code the tester is expected to test each day
	private int actualLinesOfCodeTested; //the actual number of lines of code tested by the tester each day

	//Constructor
	public Tester(String testerName, int testerID, int linesOfCodeTestedPerDay){
		this.testerName = testerName;
		this.testerID = testerID;
		this.linesOfCodeTestedPerDay = linesOfCodeTestedPerDay;
		this.actualLinesOfCodeTested = work(linesOfCodeTestedPerDay);

	} //end of constructor

	//set the tester's name
	public void setName(String testerName){
		this.testerName = testerName;
	} //end of setName

	//set the tester's ID
	public void setID(int testerID){
		this.testerID = testerID;
	} //end of setID

	//set the daily number of lines of code expected to be tested by the tester
	public void setLinesOfCodeTestedPerDay(int linesOfCodeTestedPerDay){
		this.linesOfCodeTestedPerDay = linesOfCodeTestedPerDay;
		this.actualLinesOfCodeTested = work(linesOfCodeTestedPerDay);
	} //end of setLinesOfCodeTestedPerDay

	//get the tester's Name
	public String getName(){
		return testerName;
	} //end of getName

	//get the tester's ID
	public int getID(){
		return testerID;
	} //end of getID

	//get expected number of lines tested daily by the tester
	public int getLinesOfCodeTestedPerDay(){
		return linesOfCodeTestedPerDay;
	} //end of getLinesOfCodeTested
	
	//get the actual number of lines of code written per day
	public int getActualLinesOfCodeTestedPerDay(){
		return actualLinesOfCodeTested;
	} //end of getLinesOfCodeTestedPerDay
	
	
	@Override
	public int work(int linesOfCodeTestedPerDay){
		//return a random number between 75 and 125% of actualLinesOfCodeTested
		Random randGen = new Random();
		int codeTested = (int) (linesOfCodeTestedPerDay * 0.75) + (int)(randGen.nextInt(linesOfCodeTestedPerDay) * 0.5); //75% + (50% *(anywhere from 0 1-100%))
		
		return codeTested;
	} //end of work method

	//toString
	public String toString(){
		
		String testerData = "Tester's Name: " + testerName
				+ "\nTester's ID: " + testerID
				+ "\nTheoretical Number of Lines Of Code Expected To Be Tested Each Day By The Tester: " + linesOfCodeTestedPerDay
				+ "\nWork (actual number of lines of code tested today): " + actualLinesOfCodeTested 
				+ "\n---------------------------------\n";

		return testerData;
	} //end of toString

} //end of Tester class
