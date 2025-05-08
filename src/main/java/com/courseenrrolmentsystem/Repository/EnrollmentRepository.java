package com.courseenrrolmentsystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.courseenrrolmentsystem.Entity.Enrollment;


public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

	//Custom Query -- Fetching Enrollments Using Student id -- using named parameter
	@Query("SELECT e FROM Enrollment e JOIN Student s ON e.student.id=s.id where s.id = :stud_StudentId ")
	Optional<List<Enrollment>> getEnrollmentByStudentId(int stud_StudentId);
	
	
	//Custom Query -- Fetching Enrollments Using Course Id --using named parameter
	@Query("SELECT e FROM Enrollment e JOIN Course c ON e.course.id=c.id where c.id = :cour_CourseId")
	Optional<List<Enrollment>> getEnrollmentByCourseId(int cour_CourseId);
}
