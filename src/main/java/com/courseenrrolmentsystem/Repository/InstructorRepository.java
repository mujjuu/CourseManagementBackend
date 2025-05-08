package com.courseenrrolmentsystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.courseenrrolmentsystem.Entity.Instructor;
import com.courseenrrolmentsystem.Entity.Student;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	//Custom Query -- Fetching Student By Instructor Id
	@Query("SELECT s FROM Student s JOIN Enrollment e ON e.student.id = s.id JOIN Course c ON e.course.id = c.id JOIN Instructor i ON c.instructor.id = i.id WHERE i.id = :inst_Instructorid")
	Optional<List<Student>> getStudentByInstructorId(int inst_Instructorid);
}
