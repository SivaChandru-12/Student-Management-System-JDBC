package com.student.service;
import com.student.bean.Student;
import com.student.dao.StudentDAO;

public class StudentService {
	private StudentDAO dao=new StudentDAO();
	
        public Student findStudent(int studentId)
        {
        	return dao.findStudent(studentId);
        }
        public boolean insertStudent(Student student)
        {
        	return dao.insertStudent(student);
        }
        public boolean updateStudent(Student student)
        {
        	return dao.updateStudent(student);
        }
}
