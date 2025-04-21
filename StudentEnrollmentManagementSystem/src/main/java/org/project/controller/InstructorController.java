package org.project.controller;

import java.util.List;

import org.project.entity.Instructor;
import org.project.entity.ResponseStructure;
import org.project.entity.Student;
import org.project.service.InstructorServiceImpl;
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
@RequestMapping("/instructor")
public class InstructorController 
{
	@Autowired
	private InstructorServiceImpl instructorService;
	
	@GetMapping
	public List<Instructor> getAllInstructor()
	{
		return instructorService.getAllInstructor();
	}
	
	@GetMapping("/{id}")
	public Instructor getInstructorById(@PathVariable long id)
	{
		return instructorService.getInstructorById(id);
	}
	
	@GetMapping("/student/{id}")
	public List<Student> getStudentById(@PathVariable long id)
	{
		return instructorService.getStudentByInstructorId(id);
	}
	
	@PostMapping
	public String addInstructor(@RequestBody Instructor instructor)
	{
		instructorService.addInstructor(instructor);
		return "Instructor Data Added!";
	}
	
	@PostMapping("/student/{id}")
	public ResponseStructure<Instructor> addInstructor(@RequestBody Instructor instructor, @PathVariable long id)
	{
		return instructorService.addInstructor(instructor, id);
	}
	
	@PutMapping
	public String updateInstructor(@RequestBody Instructor instructor)
	{
		 instructorService.updateInstructor(instructor);
		return "Instructor Data Updated.";
	}
	
	@DeleteMapping("/{id}")
    public String deleteInstructor(@PathVariable long id)
    {
		instructorService.deleteInstructor(id);
		return "Instructor Data Deleted!.";
    }
}
