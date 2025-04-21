package org.project.dao;

import java.util.List;

import org.project.entity.Enrollment;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentService 
{
	public void addEnrollment(Enrollment enrollment);
	
	public List<Enrollment> getAllEnrollment();
	
	public Enrollment getEnrollmentById(long id);
	
	public void updateEnrollment(Enrollment enrollment);
	
	public void deleteEnrollment(long id);
	
	public Enrollment getEnrollmentByStudentId(long id);

}
