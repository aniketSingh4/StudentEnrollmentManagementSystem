package org.project.dao;

import java.util.List;

import org.project.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseService 
{
	public void addCourse(Course course);
	
	public List<Course> getAllCourse();
	
	public Course getCourseById(long id);
	
	public void updateCourse(Course course);
	
	public void deleteCourse(long id);

}
