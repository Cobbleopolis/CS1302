package com.cobble.cs1302.lab2;

public class TestStudent {

	public static void main(String[] args) {
		
		Student[] studentList = new Student[5];
		studentList[0] = new Student("Person", "One");
		studentList[1] = new Student("Person", "Two");
		studentList[2] = new Student("Person", "Three");
		studentList[3] = new Student("Person", "Four");
		studentList[4] = new Student("Person", "Five");

        for(Student student : studentList)
            student.setCourseGrade();

        System.out.println();
        System.out.println();

        for(Student student : studentList)
            student.printCourseGrade();

        System.out.println();

        for(int i = 0; i < Student.noOfCourses; i++) {
            System.out.println("Course# " + i);
            System.out.printf("%15s %15s %15s%n", "Student Name", "Point Grade", "Letter Grade");
            for(Student student : studentList) {
                double grade = student.getCourseGrades()[i];
                System.out.printf("%15s %15.2f %15s%n",
                    student.getLastName() + ", " + student.getFirstName(),
                    grade,
                    Student.getLetterGrade(grade)
                );
            }
            System.out.println();
        }
	}

}
