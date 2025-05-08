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

import com.courseenrrolmentsystem.Entity.Enrollment;
import com.courseenrrolmentsystem.Service.EnrollmentService;
import com.courseenrrolmentsystem.Helper.EnrollmentRequest;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;
	
	//Adding Enrollment for the student
	@PostMapping()
	public ResponseEntity<ResponseStructure<Enrollment>> addEnrollment(@RequestBody EnrollmentRequest enrollmentRequest){
		return enrollmentService.addEnrollment(enrollmentRequest.getEnrollment(), enrollmentRequest.getStudent_id(), enrollmentRequest.getCourse_id());
	}
	
	//Fetching All Enrollments
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Enrollment>>> getAllEnrollments(){
		return enrollmentService.getAllEnrollments();
	}
	
	//Fetching Enrollment By Its Id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Enrollment>> getEnrollmentBId(@PathVariable int id){
		return enrollmentService.getEnrollmentById(id);
	}
	
	//Update EnrollmentDate
	@PutMapping()
	public ResponseEntity<ResponseStructure<Enrollment>> updateEnrollmentDate(@RequestBody EnrollmentRequest enrollmentRequest){
		return enrollmentService.updateEnrollmentDate(enrollmentRequest.getEnrollment(), enrollmentRequest.getStudent_id(), enrollmentRequest.getCourse_id());
	}
	
	//Delete Enrollment
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Enrollment>> deleteEnrollment(@PathVariable int id){
		return enrollmentService.deleteEnrollment(id);
	}
	
	//Custom Query -- Fetching Enrollments Using Student id 
	@GetMapping("/enrollments/stud/{student_id}")
	public ResponseEntity<ResponseStructure<List<Enrollment>>> getEnrollmentByStudentId(@PathVariable int student_id){
		return enrollmentService.getEnrollmentByStudentId(student_id);
	}
	
	//Custom Query -- Fetching Enrollments Using Course Id
	@GetMapping("/enrollments/cour/{course_id}")
	public ResponseEntity<ResponseStructure<List<Enrollment>>> getEnrollmentByCourseId(@PathVariable int course_id){
		return enrollmentService.getEnrollmentByCourseId(course_id);
	}
}
