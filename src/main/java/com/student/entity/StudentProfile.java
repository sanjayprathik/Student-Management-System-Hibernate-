package com.student.entity;
import jakarta.persistence.*;

@Entity
public class StudentProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	private String address;
	
	private String phone;
	
	@OneToOne
	@JoinColumn(name="student_id",unique=true)
	private Student student; 
	
	public StudentProfile() {
		
	}
	
	public StudentProfile(String address,String phone) {
		this.address=address;
		this.phone=phone;
	}
	
	public int getid() {
		return id;
	}
	
	public void setaddress(String address) {
		this.address=address;
	}
	
	public String getaddress() {
		return address;
	}
	
	public void setphone(String phone) {
		this.phone=phone;
	}
	
	public String getphone() {
		return phone;
	}
	
	public void setStudent(Student student) {
		this.student=student;
	}
	
	public Student getStudent() {
		return student;
	}

}
