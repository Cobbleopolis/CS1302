//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Lab3 Exercise 2
package com.cobble.cs1302.lab3;

import java.util.Scanner;

public class Calculator {
    public static Scanner scanner = new Scanner(System.in);
    /** Main method */
    public static void main(String[] args) {
        System.out.println("Please enter operand1 operator operand2: ");
        String in = scanner.nextLine().replaceAll("\\s", "");
        if (!in.matches("^\\d+[+-.*/]\\d+$")) {
            System.err.println("Please enter operand1 operator operand2");
            System.exit(1);
        }
        scanner.close();
        int splitIndex = Math.max(in.indexOf('+'),
                Math.max(in.indexOf('-'),
                        Math.max(in.indexOf('*'),
                                Math.max(in.indexOf('.'),
                                        in.indexOf('/')
                                )
                        )
                )
        );
        if (splitIndex == -1) {
            System.err.println("Please enter a valid operator. (+, -, . *, /)");
            System.exit(2);
        }
        String[] ins = {
                in.substring(0, splitIndex).trim(),
                "" + in.charAt(splitIndex),
                in.substring(splitIndex + 1).trim()
        };

        scanner.close();

        // The result of the operation
        int result = 0;

        // Determine the operator
        switch (ins[1].charAt(0)) {
            case '+':
                result = Integer.parseInt(ins[0]) +
                        Integer.parseInt(ins[2]);
                break;
            case '-':
                result = Integer.parseInt(ins[0]) -
                        Integer.parseInt(ins[2]);
                break;
            case '.':
            case '*':
                result = Integer.parseInt(ins[0]) *
                        Integer.parseInt(ins[2]);
                break;
            case '/':
                result = Integer.parseInt(ins[0]) /
                        Integer.parseInt(ins[2]);
                break;
            default:
                System.out.println("Please enter a valid operator. (+, -, . *, /)");
                System.exit(2);
        }

        // Display result
        System.out.println(ins[0] + ' ' + ins[1] + ' ' + ins[2]
                + " = " + result);
    }
}
