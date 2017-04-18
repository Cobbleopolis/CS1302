//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Project 2 | Option 1
package com.cobble.cs1302.project2;

public class Client {

    private String firstName;

    private String lastName;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String zipCode;

    private double balance;

    public Client(String input) {
        String[] fields = input.split("\\|"); // Escape the pipe because split takes regex and pipe is used for the OR operator.

        this.firstName = fields[0];
        this.lastName = fields[1];
        this.address1 = fields[2];
        this.address2 = fields[3];
        this.city = fields[4];
        this.state = fields[5];
        this.zipCode = fields[6];
        this.balance = Double.valueOf(fields[7].substring(1)); // Strip the $ from the string and convert to a double.
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return this.firstName + "|" + this.lastName + "|" + this.address1 + "|" + this.address2 + "|" + this.city + "|" + this.state + "|" + this.zipCode + "|" + this.balance;
    }
}