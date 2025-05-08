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
import com.courseenrrolmentsystem.Entity.Student;
import com.courseenrrolmentsystem.Service.StudentService;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//Adding ( Creating ) Student
	@PostMapping()
	public ResponseEntity<ResponseStructure<Student>> addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	
	//Fetching All Students Details 
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	//Fetching Single Student from student table using id
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int id){
		return studentService.getStudentById(id);
	}
	
	//Updating Single Student from Student table
	@PutMapping()
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student){
		return studentService.updateStudent(student);
	}
	
	//Deleting Single Student from Student table
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id){
		return studentService.deleteStudent(id);
	}
	
	//Custom Query -- Fetching Course By Student Id
	@GetMapping("/courses/{student_id}")
	public ResponseEntity<ResponseStructure<List<Course>>> getCourseByStudentId(@PathVariable int student_id){
		return studentService.getCourseByStudentId(student_id);
	}
	
	
}
