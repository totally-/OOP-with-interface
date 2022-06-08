# OOP-with-interface

This program uses two different classes, Programmer and Tester, that implement the same interface, AbleToWork, in different ways.

A programmer is able to write a certain number of lines of code per day, captured by an instance variable linesOfCodeWrittenPerDay. 
A programmer's work method returns the number of lines of code he/she wrote on a given day, which is a random number between 50% and 150% of linesOfCodeaWrittenPerDay (some days are not as good as others, and some tasks are harder/easier than others). 

We use the following code to generate a such random number:
Random randGen = new Random();
int codeWritten = (int)(linesOfCodePerDay * 0.5) + randGen.nextInt(linesOfCodePerDay);

A Tester is able to test a given number of lines of code per day, captured by an instance variable linesOfCodeTestedPerDay. 
A tester's work method returns the number of lines of code he/she tested that day, which is a random number between 75% and 125% 
of linesOfCodeTestedPerDay. We will use nextInt (int bound) of class Random to generate such random number:

Random randGen = new Random();
int codeTested = (int)(linesOfCodeTestedPerDay * 0.75) + (int)(randGen.nextInt(linesOfCodeTestedPerDay)*0.5);
Besides the instance variable linesOfCodeWrittenPerDay / linesOfCodeTestedPerDay, both programmer and tester have a name and ID number.


A constructor, getters/setters, and toString() method for the Programmer and Tester classes are implemented. 
 We defined the Project class, which models a software development project. It has the following properties:
    linesOfCode: an estimate of the number of lines of code the project will require 
    linesOfCodeWritten: the number of lines of code that have been written by the programmers working on it.
    linesOfCodeTested: the number of lines of code that have been tested so far.
    duration: how many days managers have given for completion of the project.
    employees: a List that stores the employees that are associated with the project. 

Constructor: takes in the number of lines of code for the project and required duration.

addEmployee (AbleToWork employee): adds an employee to the project. Since Programmer and Tester are sub-type of AbleToWork, 
                                   we could use a formal parameter with type AbleToWork to accept either Programmer or Tester actual                                      parameter.
                                   
int doProject(): do the project. Each day, as long as the project is not complete, it should call each employee's work method. 
                 It must return the number of days the project took. 
                 
Getters and Setters 

Driver class TestProject:
                         In the main method, we created a new instance of Project, 
                                  added a few programmers and testers, 
                                  run the doProject method, 
                                  and report how long it took and whether it was completed on time.
