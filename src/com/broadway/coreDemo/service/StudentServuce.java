package com.broadway.coreDemo.service;

import java.util.*;

import com.broadway.coreDemo.model.Student;

public interface StudentServuce {
	void addStudent(Student s);
	

	void deleteStudent(int index);

	List<Student> getAllStudent();
}
