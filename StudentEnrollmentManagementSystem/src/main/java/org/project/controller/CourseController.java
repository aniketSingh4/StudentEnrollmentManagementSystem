package org.project.controller;

import java.util.List;

import org.project.entity.Course;
import org.project.service.CourseServiceImpl;
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
@RequestMapping("/course")
public class CourseController 
{
	@Autowired
	private CourseServiceImpl courseService;
	
	@GetMapping
	public List<Course> getAllCourse()
	{
		return courseService.getAllCourse();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable long id)
	{
		return courseService.getCourseById(id);
	}
	
	@PostMapping
	public String addCourse(@RequestBody Course course)
	{
		courseService.addCourse(course);
		return "Course Data Added.";
	}
	
	@PutMapping
	public String updateCourse(@RequestBody Course course)
	{
		courseService.updateCourse(course);
		return "Course Data Updated.";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable long id)
	{
		courseService.deleteCourse(id);
		return "Course Data Deleted " + id;
	}

}
