package com.courseenrrolmentsystem.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.courseenrrolmentsystem.Entity.Course;
import com.courseenrrolmentsystem.Entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

	//Custom Query -- Fetching Course By Student Id
	@Query("SELECT c FROM Course c JOIN Enrollment e ON e.course.id = c.id JOIN Student s ON e.student.id = s.id WHERE s.id = :stud_Studentid")
	Optional<List<Course>> getCourseByStudentId(int stud_Studentid );
}
