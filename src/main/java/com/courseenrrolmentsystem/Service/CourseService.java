package com.courseenrrolmentsystem.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.courseenrrolmentsystem.Dao.CourseDao;
import com.courseenrrolmentsystem.Entity.Course;
import com.courseenrrolmentsystem.Entity.Instructor;
import com.courseenrrolmentsystem.Exception.CourseNotFoundException;
import com.courseenrrolmentsystem.Exception.InstructorNotFoundException;
import com.courseenrrolmentsystem.Repository.InstructorRepository;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;
	
	@Autowired
	InstructorRepository instructorRepository;
	
	//Adding Course into Database
	public ResponseEntity<ResponseStructure<Course>> addCourse(Course course,int instructor_id){
		Optional<Instructor> instructor_opt = instructorRepository.findById(instructor_id); 
		
		if(instructor_opt.isPresent()) {
			course.setInstructor(instructor_opt.get());
			courseDao.addCourse(course);
			ResponseStructure<Course> structure = new ResponseStructure<Course>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(course);
			return new ResponseEntity<ResponseStructure<Course>>(structure,HttpStatus.CREATED);
			
		}
		else {
			throw new InstructorNotFoundException(instructor_id);
		}
	}
	
	//Fetching All The Course Details
	public ResponseEntity<ResponseStructure<List<Course>>> getAllCourse(){
		List<Course> courses = courseDao.getAllCourse();
		ResponseStructure<List<Course>> structure = new ResponseStructure<List<Course>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(courses);
		return new ResponseEntity<ResponseStructure<List<Course>>>(structure,HttpStatus.OK);
	}
	
	//Fetching Course By Its Id
	public ResponseEntity<ResponseStructure<Course>> getCourseById(int id){
		Optional<Course> opt =  courseDao.getCourseById(id);
		ResponseStructure<Course> structure = new ResponseStructure<Course>();
		
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Course>>(structure,HttpStatus.OK);
		}
		else {
			throw new CourseNotFoundException(id);
		}
	}
	
	//Update Course Into Database
	public ResponseEntity<ResponseStructure<Course>> updateCourse(Course course,int instructor_id){
		Optional<Instructor> instructor_opt = instructorRepository.findById(instructor_id);
		
		if(instructor_opt.isPresent()) {
			course.setInstructor(instructor_opt.get());
			courseDao.updateCourse(course);
			ResponseStructure<Course> structure = new ResponseStructure<Course>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(course);
			return new ResponseEntity<ResponseStructure<Course>>(structure,HttpStatus.OK);
		}
		else {
			throw new InstructorNotFoundException(instructor_id);
		}
	}
	
	//Delete Course From Database
	public ResponseEntity<ResponseStructure<Course>> deleteCourse(int id){
		Optional<Course> opt = courseDao.getCourseById(id);
		ResponseStructure<Course> structure= new ResponseStructure<Course>();
		if(opt.isPresent()) {
			courseDao.deleteCourse(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Course Deleted");
			return new ResponseEntity<ResponseStructure<Course>>(structure,HttpStatus.OK);
		}
		else {
			throw new CourseNotFoundException(id);
		}
	}
	
	//Custom Query -- Fetching Courses Using InstructorId
	public ResponseEntity<ResponseStructure<List<Course>>> getCourseByInstructorId(int instructor_id){
		Optional<Instructor> instructorOpt = instructorRepository.findById(instructor_id);
		
		if(instructorOpt.isEmpty()) {
			throw new InstructorNotFoundException(instructor_id);
		}
		List<Course> courses = courseDao.getCourseByInstructorId(instructor_id).orElse(Collections.emptyList());
		ResponseStructure<List<Course>> structure = new ResponseStructure<List<Course>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage(courses.isEmpty() ? " No Courses found with Instructor Id : "+instructor_id :"Success");
		structure.setData(courses);
		return new ResponseEntity<ResponseStructure<List<Course>>>(structure,HttpStatus.OK);
	}
}
