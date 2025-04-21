package org.project.dao;

import java.util.List;

import org.project.entity.Instructor;
import org.project.entity.ResponseStructure;
import org.project.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorService 
{
	public void addInstructor(Instructor instructor);
	
	public ResponseStructure<Instructor> addInstructor(Instructor instructor, long id);
	
	public List<Instructor> getAllInstructor();
	
	public Instructor getInstructorById(long id);
	
	public void updateInstructor(Instructor instructor);
	
	public void deleteInstructor(long id);
	
	public List<Student> getStudentByInstructorId(long id);

}
