package org.project.repository;

import java.util.List;

import org.project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>
{
	// Custom query method
    List<Student> findByInstructorId(Long instructorId);

}
