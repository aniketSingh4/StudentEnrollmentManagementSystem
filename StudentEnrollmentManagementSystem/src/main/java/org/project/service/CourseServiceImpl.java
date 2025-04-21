package org.project.service;

import java.util.List;

import org.project.dao.CourseService;
import org.project.entity.Course;
import org.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public void addCourse(Course course) 
	{
		courseRepo.save(course);
	}

	@Override
	public List<Course> getAllCourse() 
	{
		return courseRepo.findAll();
	}

	@Override
	public Course getCourseById(long id) 
	{
		return courseRepo.findById(id).orElseThrow(()-> new RuntimeException("No Course Data Found."));
	}

	@Override
	public void updateCourse(Course course) 
	{
		courseRepo.save(course);
	}

	@Override
	public void deleteCourse(long id) 
	{
		courseRepo.deleteById(id);
	}

}
