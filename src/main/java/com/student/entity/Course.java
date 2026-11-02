package com.student.entity;
import java.util.*;

import jakarta.persistence.*;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String courseName;
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students=new ArrayList<>();
	
	public Course() {
		
	}
	
	public Course(String courseName) {
		this.courseName=courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName=courseName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public int getId() {
		return id;
	}
	
	public List<Student> getStudents(){
		return students;
	}

}
