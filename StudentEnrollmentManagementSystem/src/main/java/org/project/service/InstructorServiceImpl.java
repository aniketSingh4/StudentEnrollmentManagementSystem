package org.project.service;

import java.util.ArrayList;
import java.util.List;

import org.project.dao.InstructorService;
import org.project.entity.Instructor;
import org.project.entity.ResponseStructure;
import org.project.entity.Student;
import org.project.repository.InstructorRepository;
import org.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService
{
	@Autowired
	private InstructorRepository instructorRepo;
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void addInstructor(Instructor instructor) 
	{
		instructorRepo.save(instructor);
		
	}

	@Override
	public List<Instructor> getAllInstructor() 
	{
		return instructorRepo.findAll();
	}

	@Override
	public Instructor getInstructorById(long id) 
	{
		return instructorRepo.findById(id).orElseThrow(()-> new RuntimeException("No Instructor Record Found!."));
	}

	@Override
	public void updateInstructor(Instructor instructor) 
	{
		instructorRepo.save(instructor);
	}

	@Override
	public void deleteInstructor(long id) 
	{
		instructorRepo.deleteById(id);
	}

	@Override
	public List<Student> getStudentByInstructorId(long id) 
	{
		Instructor instructor = instructorRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Student Data Not Found!."));
		return instructor.getStudents();
		
		//return instructorRepo.findByInstructorId(id);
	}

	@Override
	public ResponseStructure<Instructor> addInstructor(Instructor instructor, long id) 
	{
		Student student = studentRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("No Student Data Found!."));
		
		//Store student data into arrayList
		ArrayList<Student> list = new ArrayList<>();
		list.add(student);
		
		instructor.setStudents(list);
		instructorRepo.save(instructor);
		
		ResponseStructure<Instructor> res = new ResponseStructure<>();
		res.setStatusCode(200);
		res.setMessage("Instructor Data Saved.");
		res.setData(instructor);
		
		return res;
		
	}
}
