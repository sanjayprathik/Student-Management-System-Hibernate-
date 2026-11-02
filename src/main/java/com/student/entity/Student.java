package com.student.entity;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	@ManyToMany
	@JoinTable(
			name="student_course",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="course_id")
			)
	private List<Course> courses=new ArrayList<>();
	
	@OneToOne(mappedBy="student",cascade=CascadeType.ALL,orphanRemoval=true)
	private StudentProfile profile;
	
	public Student() {
		
	}
	
	public Student(String name,String email) {
		this.name=name;
		this.email=email;
	}
	
	public int getid() {
		return id;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public String getname() {
		return name;
	}
	
	public void setemail(String email) {
		this.email=email;
	}
	
	public String getemail() {
		return email;
	}
	
	public void setBatch(Batch batch2) {
		this.batch=batch2;
	}
	
	public Batch getBatch() {
		return batch;
	}
	
	public void setStudentProfile(StudentProfile profile) {
		this.profile=profile;
	}
	
	public StudentProfile getStudentProfile() {
		return profile;
	}
	
	public List<Course> getCourses(){
		return courses;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
		course.getStudents().add(this);
	}
	
	
	public String toString() {
		return "STUDENT ID ;"+id+"   "+"STUDENT NAME :"+name+"   "+"STUDENT EMAIL :"+email;
	}

}
