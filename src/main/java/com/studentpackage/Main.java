package com.studentpackage;
import java.util.List;
import java.util.Scanner;

import com.student.dao.GenericDAO;
import com.student.dao.GenericDAOimpl;
import com.student.entity.Batch;
import com.student.entity.Course;
import com.student.entity.Student;
import com.student.entity.StudentProfile;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		GenericDAO<Student,Integer> studentdao=new GenericDAOimpl<>(Student.class);
		GenericDAO<Batch,Integer> BatchDAO=new GenericDAOimpl<>(Batch.class);
		GenericDAO<Course,Integer> courseDAO=new GenericDAOimpl<>(Course.class);
		
		System.out.println("            ENTER YOUR CHOICE            ");
		System.out.println("PRESS 1 TO REGISTER AN STUDENT");
		System.out.println("PRESS 2 TO SEARCH AN STUDENT USING ID");
		System.out.println("PRESS 3 TO VIEW ALL STUDENTS");
		System.out.println("PRESS 4 TO UPDATE AN STUDENT");
		System.out.println("PRESS 5 TO DELETE AN STUDENT");
		System.out.println();
		System.out.print("ENTER YOUR CHOICE :");
		int choice=sc.nextInt();
		System.out.println();
		
		if(choice==1) {

			System.out.print("ENTER STUDENT DETAILS");
			System.out.println();
			
			System.out.print("ENTER STUDENT NAME :");
			String name=sc.next();
			
			System.out.print("ENTER STUDENT EMAIL :");
			String email=sc.next();
			
			System.out.print("ENTER STUDENT ADDRESS :");
			String address=sc.next();
			
			System.out.print("ENTER STUDENT POHONE NUMBER :");
			String phone=sc.next();
			
			System.out.print("ENTER STUIDENT COURSES CHOOSEN :");
			String course=sc.next();
			
			System.out.print("ENTER STUDENT BATCH TIMING :");
		    String batch=sc.next();
		    
			
			Course courses=new Course();
			courses.setCourseName(course);
			courseDAO.save(courses);
			
			Batch batches=new Batch();
			batches.setBatchName(batch);
			BatchDAO.save(batches);
			
			
			Student student=new Student();
			student.setname(name);
			student.setemail(email);
			
			
			StudentProfile profile=new StudentProfile();
			profile.setphone(phone);
			profile.setaddress(address);
			
			student.setStudentProfile(profile);
			profile.setStudent(student);
			
			student.setBatch(batches);
			
			student.addCourse(courses);
			
			studentdao.save(student);
			
			System.out.println("STUDENT DATA SAVED SUCCESSFULLY");
				
		
		
		}
		else if(choice==2){
			System.out.print("ENTR AN STUDNT ID TO SEARCH :");
			int searchid=sc.nextInt();
			
			Student searchstudent=studentdao.findById(searchid);
			
			if(searchstudent!=null) {
				System.out.println(searchstudent);
			}
			else {
				System.out.println("STUDENT NOT FOUND");
			}
		
		}	
		
		
		else if(choice==3) {
			List<Student> students=studentdao.findAll();
			
			if(students.isEmpty()) {
				System.out.println("STUDENTS NOT FOUND");
			}
			else {
				for(Student s:students) {
					System.out.println(s);
				}
			}
		}
		
		else if(choice==4) {
			System.out.print("ENTER AN ID TO UPDATE :");
			int updateid=sc.nextInt();
			
			Student updatestudent=studentdao.findById(updateid);
			
			if(updatestudent!=null) {
				System.out.print("ENTER NEW NAME :");
				String newname=sc.next();
				
				System.out.print("ENTER AN NEW EMAIL :");
				String newemail=sc.next();
				
				updatestudent.setname(newname);
				updatestudent.setemail(newemail);
				
				studentdao.update(updatestudent);
				System.out.println("STUDENT UPDATED");
			}
			else {
				System.out.println("STUDENT NOT UPDATED");
			}
		}
		
		else if(choice==5) {
			System.out.print("ENTER AN ID TO DELETE :");
			int deleteid=sc.nextInt();
			
			Student deletestudent=studentdao.findById(deleteid);
			
			if(deletestudent!=null) {
				studentdao.delete(deleteid);
				System.out.println("STUDENT DELETED SUCCESSFULLY");
			}
			else {
				System.out.println("STUDENT NOT DELTED");
			}
		}
		
		
		else{
			System.out.println("INVALID CHOICE");
		}
	}	



}
