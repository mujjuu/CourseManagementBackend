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

import com.courseenrrolmentsystem.Entity.Instructor;
import com.courseenrrolmentsystem.Entity.Student;
import com.courseenrrolmentsystem.Service.InstructorService;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	InstructorService instructorService;
	
	//Adding Instructor
	@PostMapping()
	public ResponseEntity<ResponseStructure<Instructor>> addInstructor(@RequestBody Instructor instructor){
		return instructorService.addInstructor(instructor);
	}
	
	//Fetching All Instructor Details
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Instructor>>> getAllInstructors(){
		return instructorService.getAllInstructors();
	}
	
	//Fetching Single Instructor By its Id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Instructor>> getInstructorById(@PathVariable int id){
		return instructorService.getInstructorById(id);
	}
	
	//Updating Single Instructor
	@PutMapping()
	public ResponseEntity<ResponseStructure<Instructor>> updateInstructor(@RequestBody Instructor instructor){
		return instructorService.updateInstructor(instructor);
	}
	
	//Delete Instructor by passing id 
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Instructor>> deleteInstructor(@PathVariable int id){
		return instructorService.deleteInstructor(id);
	}
	
	//Custom Query -- Fetching Student By Instructor Id
	@GetMapping("/students/{instructor_id}")
	public ResponseEntity<ResponseStructure<List<Student>>> getStudentByInstructorId(@PathVariable int instructor_id){
		return instructorService.getStudentByInstructorId(instructor_id);
	}
}
