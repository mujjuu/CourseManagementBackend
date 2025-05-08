package com.courseenrrolmentsystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.courseenrrolmentsystem.Entity.Course;
import com.courseenrrolmentsystem.Repository.CourseRepository;

@Repository
public class CourseDao {

	@Autowired
	CourseRepository courseRepository;
	
	//Adding Course into Database
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}
	
	//Fetching All The Course Details
	public List<Course> getAllCourse(){
		return courseRepository.findAll();
	}
	
	//Fetching Course By Its Id
	public Optional<Course> getCourseById(int id) {
		return courseRepository.findById(id);
	}
	
	//Update Course Into Database
	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}
	
	//Delete Course from Database
	public void deleteCourse(Course course) {
		courseRepository.delete(course);
	}
	
	//Custom Query -- Fetching Courses Using InstructorId
	public Optional<List<Course>> getCourseByInstructorId(int instructor_id){
		return courseRepository.getCourseByInstructorId(instructor_id);
	}
}
