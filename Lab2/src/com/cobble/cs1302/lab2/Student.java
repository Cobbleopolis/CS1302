package com.cobble.cs1302.lab2;
import java.util.*;

public class Student {

    private static Scanner scan = new Scanner(System.in); //scanner object to accept course grades from user

	//declare static member variables
	public static int noOfCourses = 4;
	private static int noOfStudents = 0;
	
	//Declare private member variables
	private String firstName, lastName;
	private double[] courseGrades = new double[noOfCourses];
	
	//Constructors
	
	Student(){
		noOfStudents++;
	}
	
	Student(String fname, String lname){
		this();
		firstName = fname;
		lastName = lname;
	}
	
	//get and set methods - accessors & mutators
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}

    public double[] getCourseGrades() {
        return this.courseGrades;
    }

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	//Set course grade values for a student. Allow user to input the grade values as doubles
	
	public void setCourseGrade(){
		int i = 0; 	//index counter for courseGrades array
		//accept course grades from user as double values between 0 & 100
		while(i< noOfCourses){
			System.out.println("Enter course grade for course# " + i);
			courseGrades[i] = scan.nextDouble();
			if (courseGrades[i]>= 0.0 && courseGrades[i] <= 100.0)
				i++;
			else
				System.out.println("Invalid input: enter grade values between 0 & 100 only");
		}
	}
	
	//Print course grade for a student 
	//A = 90-100; B = 80 - 89.99; C = 70 - 79.99; D = 60 - 69.99; C = less than 60
	//This method needs to be implemented
	
	public void printCourseGrade(){
        String format = "%7d %15.2f %15s%n";
        System.out.printf("Student: %s, %s%n", lastName, firstName);
        System.out.printf("%7s %15s %15s%n", "Course#", "Point Grade", "Letter Grade");
        for(int i = 0; i < courseGrades.length; i++) {
            double grade = courseGrades[i];
            char letterGrade = getLetterGrade(grade);
            System.out.printf(format, i, grade, letterGrade);
        }
        System.out.println("Avg GPA: " + getAvgGPA());
        System.out.println();
    }
	
	public char getAvgGPA(){
        double avg = 0;
        for(double grade : courseGrades)
            avg += grade;
        avg /= courseGrades.length;
		return getLetterGrade(avg);
	}

	public static char getLetterGrade(double grade) {
        char letterGrade;
        if (grade >= 90)
            letterGrade = 'A';
        else if (grade >= 80)
            letterGrade = 'B';
        else if (grade >= 70)
            letterGrade = 'C';
        else if (grade > 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';
        return letterGrade;
    }
	
}
