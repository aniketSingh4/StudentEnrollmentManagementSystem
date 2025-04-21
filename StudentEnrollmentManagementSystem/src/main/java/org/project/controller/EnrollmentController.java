package org.project.controller;

import java.util.List;

import org.project.entity.Enrollment;
import org.project.repository.EnrollmentRepository;
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
@RequestMapping("/enrollment")
public class EnrollmentController 
{
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	
	@GetMapping
	public List<Enrollment> getAllEnrollment()
	{
		return enrollmentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Enrollment getEnrollmentbyId(@PathVariable long id)
	{
		return enrollmentRepository.findById(id).orElseThrow(()-> new RuntimeException("No Data Found!."));
		
	}
	
	@PostMapping
	public String saveEnrollment(@RequestBody Enrollment enrollment)
	{
		enrollmentRepository.save(enrollment);
		return "Enrollment DAta Saved.";
	}
	
	@PutMapping
	public String updateEnrollment(@RequestBody Enrollment enrollment)
	{
		enrollmentRepository.save(enrollment);
		return "Enrollment Data Updated.";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEnrollment(@PathVariable long id)
	{
		enrollmentRepository.deleteById(id);
		return "Enrollment Data Updated.";
	}

}
