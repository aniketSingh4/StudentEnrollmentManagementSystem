package org.project.service;

import java.util.List;

import org.project.dao.StudentService;
import org.project.entity.Course;
import org.project.entity.Enrollment;
import org.project.entity.Instructor;
import org.project.entity.ResponseStructure;
import org.project.entity.Student;
import org.project.repository.CourseRepository;
import org.project.repository.EnrollmentRepository;
import org.project.repository.InstructorRepository;
import org.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public void addStudent(Student student) 
	{
		studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() 
	{
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) 
	{
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Data Not Found!."));
	}

	@Override
	public void updateStudent(Student student) 
	{
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(long id) 
	{
		studentRepository.deleteById(id);
		
	}

	@Override
	public Course getCourseByStudentId(long id) 
	{
		Student student = studentRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Student not found"));
		
		return student.getCourse();
	}

	@Override
	public ResponseStructure<Student> addStudent(Student student, long id1, long id2, long id3) 
	{
		Enrollment enrollment = enrollmentRepository.findById(id1)
				.orElseThrow(() -> new RuntimeException("Enrollment not found"));
		
		
		Course course = courseRepository.findById(id2)
		        .orElseThrow(() -> new RuntimeException("Course not found"));
		
		Instructor instructor = instructorRepository.findById(id3)
				.orElseThrow(()-> new RuntimeException("Instructor not found."));
		    
		    student.setEnrollment(enrollment);
		    student.setCourse(course);
		    student.setInstructor(instructor);
		    studentRepository.save(student);
		    
		    ResponseStructure<Student> s = new ResponseStructure<>();
		    s.setStatusCode(200);
		    s.setMessage("Data Saved");
		    s.setData(student);
		    
		    return s;
		    
	}

	@Override
	public Enrollment getEnrollmentByStudentId(long id) 
	{
		Student student = studentRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Enrollment not found!."));
		return student.getEnrollment();
	}

	@Override
	public Instructor getInstructorByStudentId(long id) 
	{
		Student student = studentRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Instructor Not Found."));
		
		return student.getInstructor();
	}
}
