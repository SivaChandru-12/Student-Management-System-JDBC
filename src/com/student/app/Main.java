package com.student.app;
import java.util.Scanner;
import com.student.bean.Student;
import com.student.service.StudentService;
public class Main {
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		StudentService service=new StudentService();
		int choice;
		do
		{
			System.out.println("Student Management System");
			System.out.println("1.insert Student");
			System.out.println("2.View Student");
			System.out.println("3.Update Marks");
			System.out.println("4,exit");
			System.out.println("Enter your Choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			Student student = new Student();
			System.out.println("Enter Student Id:");
			student.setStudentId(sc.nextInt());
			sc.nextLine();
			
			System.out.println("Enter Student Name:");
			student.setStudentName(sc.nextLine());
			
			System.out.println("Enter Student Dept:");
			student.setDepartment(sc.nextLine());
			
			System.out.println("Enter Student Marks:");
			student.setMarks(sc.nextInt());
			
			if(service.insertStudent(student))
			{
				System.out.println("Student Insert Successfully.");
				
			}
			else
			{
				System.out.println("Insertion Failed");
			}
			break;
			
			case 2:

			    System.out.print("Enter Student ID : ");
			    int id = sc.nextInt();

			    Student s = service.findStudent(id);

			    if (s != null) {

			        System.out.println("Student ID : " + s.getStudentId());
			        System.out.println("Student Name : " + s.getStudentName());
			        System.out.println("Department : " + s.getDepartment());
			        System.out.println("Marks : " + s.getMarks());

			    } else {

			        System.out.println("Student Not Found");

			    }

			    break;

			case 3:

			    Student st = new Student();

			    System.out.print("Enter Student ID : ");
			    st.setStudentId(sc.nextInt());

			    System.out.print("Enter New Marks : ");
			    st.setMarks(sc.nextInt());

			    if (service.updateStudent(st))
			        System.out.println("Marks Updated Successfully");
			    else
			        System.out.println("Update Failed");

			    break;
			case 4:

			    System.out.println("Thank You");

			    break;
			default:

			    System.out.println("Invalid Choice");
			    
			}
		}
		while (choice != 4);

        sc.close();
		
	}

}
