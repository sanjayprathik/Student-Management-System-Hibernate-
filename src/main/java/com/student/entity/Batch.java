package com.student.entity;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Batch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String batchName;
	
	@OneToMany(mappedBy="batch")
	private List<Student> students=new ArrayList();
	
	public Batch() {
		
	}
	
	public Batch(String batchName) {
		this.batchName=batchName;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setBatchName(String batchname) {
		this.batchName=batchname;
	}
	
	public String getBatchName() {
		return batchName;
	}
	
	public void addstudent(Student student) {
		students.add(student);
		student.setBatch(this);
	}
	
	

}
