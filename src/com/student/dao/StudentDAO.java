package com.student.dao;
import java.sql.*;
import com.student.bean.*;
import com.student.util.*;
public class StudentDAO {
                 public Student findStudent(int StudentId)
                 {
                	 Student student=null;
                	 try
                	 {
                		 Connection con=DBUtil.getDBConnection();
                		 String sql="SELECT * FROM STUDENT WHERE STUDENT_ID=? ";
                		  PreparedStatement ps=con.prepareStatement(sql);
                		  ps.setInt(1,StudentId);
                		 ResultSet rs=ps.executeQuery();
                		 if(rs.next())
                		 {
                			 student =new Student();
                			 student.setStudentId(rs.getInt("STUDENT_ID"));
                			 student.setStudentName(rs.getString("STUDENT_NAME"));
                			 student.setDepartment(rs.getString("DEPARTMENT"));
                			 student.setMarks(rs.getInt("MARKS"));
                			 
                			 
                		 }
                		 con.close();
                	 }
                	 catch(Exception e)
                	 {
                		 e.printStackTrace();
                	 }
                	 return student;
                 }
                 public boolean  insertStudent(Student student)
                 {
                 	boolean result =false;
                 	try
                 	{
                 		Connection con=DBUtil.getDBConnection();
                 		String sql = "INSERT INTO STUDENT (STUDENT_ID, STUDENT_NAME, DEPARTMENT, MARKS) VALUES (?, ?, ?, ?)";
                 		  PreparedStatement ps=con.prepareStatement(sql);
                 		  ps.setInt(1, student.getStudentId());
                 		  ps.setString(2, student.getStudentName());
                 		  ps.setString(3, student.getDepartment());
                 		  ps.setInt(4, student.getMarks());
                 		 result=ps.executeUpdate()>0;
                 		 con.close();
                 	}
                 	 catch(Exception e)
               	 {
               		 e.printStackTrace();
               	 }
                 	return result;
                 }
                 public boolean updateStudent(Student student)
                 {
                	 boolean result=false;
                	 try
                	 {
                		 Connection con=DBUtil.getDBConnection();
                		 String sql="UPDATE STUDENT SET MARKS=? WHERE STUDENT_ID=?";
                		 PreparedStatement ps=con.prepareStatement(sql);
                		 ps.setInt(1, student.getMarks());
                		 ps.setInt(2, student.getStudentId());
                		 result=ps.executeUpdate()>0;
                		 con.close();	 
                	 }
                	 catch(Exception e)
                   	 {
                   		 e.printStackTrace();
                   	 }
                	 return result;
                 }
}
