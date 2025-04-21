package org.project.service;

import java.util.List;

import org.project.dao.EnrollmentService;
import org.project.entity.Enrollment;
import org.project.entity.Student;
import org.project.repository.EnrollmentRepository;
import org.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService
{
	@Autowired
	private EnrollmentRepository enrollmentRepo;
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void addEnrollment(Enrollment enrollment) 
	{
		enrollmentRepo.save(enrollment);
		
	}

	@Override
	public List<Enrollment> getAllEnrollment() 
	{
		return enrollmentRepo.findAll();
	}

	@Override
	public Enrollment getEnrollmentById(long id) 
	{
		return enrollmentRepo.findById(id).orElseThrow(() -> new RuntimeException("No Enrollment Data Found."));
	}

	@Override
	public void updateEnrollment(Enrollment enrollment) 
	{
		enrollmentRepo.save(enrollment);
	}

	@Override
	public void deleteEnrollment(long id) 
	{
		enrollmentRepo.deleteById(id);
	}

	@Override
	public Enrollment getEnrollmentByStudentId(long id) 
	{
		Student student = studentRepo.findById(id).orElseThrow(()-> new RuntimeException("No Enrollment Record Found!."));
		return student.getEnrollment();
	}

}
