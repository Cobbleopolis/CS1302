package Homework3;

import java.util.Date;

public class Employee extends Person {

	private double salary;
	private Date dateHired;
	
	public Employee(String name, String emailAddress, double salary) {
		super(name, emailAddress);
		this.salary = salary;
		this.dateHired = new Date();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDateHired() {
	    return dateHired;
    }
		
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
