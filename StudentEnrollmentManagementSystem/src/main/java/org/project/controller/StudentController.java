package org.project.controller;

import java.util.List;

import org.project.entity.Course;
import org.project.entity.Enrollment;
import org.project.entity.Instructor;
import org.project.entity.ResponseStructure;
import org.project.entity.Student;
import org.project.service.CourseServiceImpl;
import org.project.service.EnrollmentServiceImpl;
import org.project.service.InstructorServiceImpl;
import org.project.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentServiceImpl studentService;

	
	@GetMapping
	public List<Student> getAllStudent() 
	{
		return studentService.getAllStudent();
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable long id) 
	{
		return studentService.getStudentById(id);
	}

	// Getting course by student id
	@GetMapping("/course/{id}")
	public Course getCourseByStudentId(@PathVariable long id) 
	{
		return studentService.getCourseByStudentId(id);
	}

	// Getting enrollment by student id
	@GetMapping("/enrollment/{id}")
	public Enrollment getEnrollmentByStudentId(@PathVariable long id) 
	{
		return studentService.getEnrollmentByStudentId(id);
	}
	
	//Getting Instructor By Student Id
	@GetMapping("/instructor/{sid}")
	public Instructor getInstructorByStudentId(@PathVariable long sid)
	{
		return studentService.getInstructorByStudentId(sid);
	}

	@PostMapping
	public String addStudent(@RequestBody Student student) 
	{
		studentService.addStudent(student);
		return "Student Data Saved.";
	}

	@PostMapping("enrollment/{enrollmentId}/course/{courseId}/instructor/{instructorId}")
	public ResponseStructure<Student> addStudent(@RequestBody Student student, 
			                 @PathVariable long enrollmentId , 
			                 @PathVariable Long courseId, 
			                 @PathVariable long instructorId) 
	{
		return studentService.addStudent(student, enrollmentId, courseId, instructorId);
		//return "Student Data Added with Enrollment Id and Course Id";
	}

	@PutMapping
	public String updateStudent(@RequestBody Student student) 
	{
		studentService.updateStudent(student);
		return "Student Data Updated.";
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable long id) 
	{
		studentService.deleteStudent(id);
		return "Student Data Deleted!.";
	}

}
