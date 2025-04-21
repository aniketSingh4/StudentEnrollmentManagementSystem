package org.project.dao;

import java.util.List;

import org.project.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentService 
{
	public void addStudent(Student student);
	
	public ResponseStructure<Student> addStudent(Student student, long id1, long id2, long id3);
	
	public List<Student> getAllStudent();
	
	public Student getStudentById(long id);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(long id);
	
	public Course getCourseByStudentId(long id);
	
	public Enrollment getEnrollmentByStudentId(long id);
	
	public Instructor getInstructorByStudentId(long id);

}
