
package ITemployees;

import ableToWorkInterface.AbleToWork;
import java.util.*;

public class Programmer implements AbleToWork{
	
	//Instance and class variables
	private String programmerName; //the programmer's name
	private int programmerID; //the programmer's ID number
	private int linesOfCodeExpected; //the number of lines of code a programmer is expected to write each day
	private int linesOfCodeWrittenPerDay; //the actual number of lines of code the programmer wrote per day
	
	//Constructor
	public Programmer(String programmerName, int programmerID, int linesOfCodeExpected){
		this.programmerName = programmerName;
		this.programmerID = programmerID;
		this.linesOfCodeExpected = linesOfCodeExpected;
		this.linesOfCodeWrittenPerDay = work(linesOfCodeExpected);
	} //end of constructor
	
	//set the programmer's name
	public void setName(String programmerName){
		this.programmerName = programmerName;
	} //end of setName
	
	//set the programmer's ID
	public void setID(int programmerID){
		this.programmerID = programmerID;
	} //end of setID
	
	//set the lines of code expected to be written from the programmer
	public void setLinesOfCodeExpected(int linesOfCodeExpected){
		this.linesOfCodeExpected = linesOfCodeExpected;
		this.linesOfCodeWrittenPerDay = work(linesOfCodeExpected);
	} //end of setLinesOfCodeWrittenPerDay
	
	//get the programmer's Name
	public String getName(){
		return programmerName;
	} //end of getName
	
	//get the programmer's ID
	public int getID(){
		return programmerID;
	} //end of getID
	
	//get expected lines of code written per day
	public int getLinesOfCodeExpected(){
		return linesOfCodeExpected;
	} //end of getLinesOfCode
	
	//get actual number of lines of code written per day
	public int getLinesOfCodeWrittenPerDay(){
		return linesOfCodeWrittenPerDay;
	} //end of getLinesOfCodeWrittenPerDay
	
	@Override
	public int work(int linesOfCodeExpected){
		//return a random number between 50 and 150% of linesOfCodeWrittenPerDay
		Random randGen = new Random();
		int codeWritten = (int) (linesOfCodeExpected * 0.5) + randGen.nextInt(linesOfCodeExpected); //50% + (anywhere from 0 to 100%)
		// randGen.nextInt(linesOfCodeWrittenPerDay) returns a random value within the range of the linesOfCodeWrittenPerDay
		// for ex., if linesOfCodeWrittenPerDay is 100, it will return a value from 0 to 100.
		return codeWritten;
	} //end of work method
	
	//toString
	public String toString(){
		
		//String programmerName, int programmerID, int linesOfCodeWritten
		String programmerData = "Programmer's Name: " + programmerName
				+ "\nProgrammer's ID: " + programmerID
				+ "\nTheoretical Number of Expected lines of code written by programmer daily: " + linesOfCodeExpected
				+ "\nWork (actual number of lines of code written today): " + linesOfCodeWrittenPerDay 
				+"\n---------------------------------\n";
		
		return programmerData;
	} //end of toString

} //end of Programmer class
