package com.courseenrrolmentsystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.courseenrrolmentsystem.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	//Custom Query -- Fetching Courses Using InstructorId
	@Query("SELECT c FROM Course c JOIN Instructor i ON c.instructor.id = i.id where i.id = :instr_Instructorid")
	Optional<List<Course>> getCourseByInstructorId(int instr_Instructorid);
}
