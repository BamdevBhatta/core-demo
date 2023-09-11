package com.broadway.coreDemo.view;

import java.util.List;
import java.util.Scanner;

import com.broadway.coreDemo.model.Student;
import com.broadway.coreDemo.service.StudentServuce;
import com.broadway.coreDemo.service.StuentServiceImpl;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentServuce ss = new StuentServiceImpl();

		String flag = "y";
		System.out.println("Enter 'ADD' for inserting data into table Student");
		System.out.println("enter 'DEL' for deleting dat from database");
		System.out.println("Enter 'ALL' for to show the content of table Student: ");
		String op = sc.next();
		switch (op) {
		case "add":
			do {
				Student s = new Student();
				System.out.println("Enter fname");
				s.setFname(sc.next());
				System.out.println("Enter lname");
				s.setLname(sc.next());
				System.out.println("Enter city");
				s.setCity(sc.next());
				System.out.println("Enter college name:");
				s.setCollege(sc.next());
				System.out.println("Enter faculty:");
				s.setFaculty(sc.next());
				ss.addStudent(s);
				System.out.println("Add more press y/n");
				flag = sc.next();

			} while (flag.equalsIgnoreCase("y"));
			break;
		case "del":
			System.out.println("Enter index you want to delete");

			ss.deleteStudent(sc.nextInt());
			break;
		case "all" :
			List<Student> list1 = ss.getAllStudent();
			for (Student s : list1) {
				System.out.println("Name of Student: " + s.getFname()+" "+s.getLname());
				System.out.println("Name of College"+s.getCollege());
				System.out.println("Name of City: "+s.getCity());
				sc.close();

			}
			
		}

	}
}
