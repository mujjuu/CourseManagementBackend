package com.courseenrrolmentsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseenrrolmentsystem.Entity.Course;
import com.courseenrrolmentsystem.Service.CourseService;
import com.courseenrrolmentsystem.Helper.CourseRequest;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	//Adding Course into Database
	@PostMapping()
	public ResponseEntity<ResponseStructure<Course>> addCourse(@RequestBody CourseRequest courseRequest){
		return courseService.addCourse(courseRequest.getCourse(),courseRequest.getInstructor_id());
	}
	
	//Fetching All The Course Details
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Course>>> getAllCourse(){
		return courseService.getAllCourse();
	}
	
	//Fetching Course By Its Id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Course>> getCourseById(@PathVariable int id){
		return courseService.getCourseById(id);
	}
	
	//Update Course Into Database
	@PutMapping()
	public ResponseEntity<ResponseStructure<Course>> updateCourse(@RequestBody CourseRequest courseRequest){
		return courseService.updateCourse(courseRequest.getCourse(), courseRequest.getInstructor_id());
	}
	
	//Delete Course From Database
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Course>> deleteCourse(@PathVariable int id){
		return courseService.deleteCourse(id);
	}
	
	//Custom Query -- Fetching Courses Using InstructorId
	@GetMapping("/courses/{instructor_id}")
	public ResponseEntity<ResponseStructure<List<Course>>> getCourseByInstructorId(@PathVariable int instructor_id) {
     return courseService.getCourseByInstructorId(instructor_id);
	}
	
}
