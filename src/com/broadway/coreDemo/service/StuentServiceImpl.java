package com.broadway.coreDemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;

import com.broadway.coreDemo.model.Student;

import db.Dbconn;

public class StuentServiceImpl implements StudentServuce{

	 static List<Student> slist = new ArrayList<>();
	
	@Override
	public void addStudent(Student s) {
		String fname = s.getFname();
		String lname = s.getLname();
		String clz = s.getCollege();
		String faculty = s.getFaculty();
		 String city = s.getCity();
	Connection con = Dbconn.conGet();
	String sql = "insert into student (fname,lname,college,city,faculty) values (?,?,?,?,?)";
	try {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, fname);
		pstmt.setString(2, lname);
		pstmt.setString(3, clz);
		pstmt.setString(4, city);
		pstmt.setString(5, faculty);
		pstmt.execute();
		
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public void deleteStudent(int index) {
		Connection con = Dbconn.conGet();
		System.out.println(index);
		String sql = "delete from student where id ='"+index+"'";
		try {
			Statement stm = con.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getAllStudent() {
		List <Student> list = new ArrayList<>();
		Connection con = Dbconn.conGet();
		String sql = "select * from student";
		try {
			//Student s  = new Student();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Student s  = new Student();
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));
				s.setCity(rs.getString("city"));
				s.setCollege(rs.getString("college"));
				s.setFaculty(rs.getString("faculty"));
				list.add(s);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
