package com.courseenrrolmentsystem.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.courseenrrolmentsystem.Dao.StudentDao;
import com.courseenrrolmentsystem.Entity.Course;
import com.courseenrrolmentsystem.Entity.Student;
import com.courseenrrolmentsystem.Exception.IdNotFoundException;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	//Adding ( Creating ) Student
	public ResponseEntity<ResponseStructure<Student>> addStudent(Student student){
		studentDao.addStudent(student);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(student);
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
	}
	
	//Fetching All Students Details
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents(){
		List<Student> students =  studentDao.getAllStudents();
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(students);
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.OK);
	}
	
	//Fetching Single Student from student table using id
	public ResponseEntity<ResponseStructure<Student>> getStudentById(int id){
		
		Optional<Student> opt = studentDao.getStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException(id);
		}
	}
	
	//Updating Single Student from Student table
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student){
		studentDao.updateStudent(student);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(student);
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
	}
	
	//Deleting Single Student from Student table
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id){
		Optional<Student> opt = studentDao.getStudentById(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if(opt.isPresent()) {
			studentDao.deleteStudent(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Record Deleted");
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException(id);
		}
	}
	
	//Custom Query -- Fetching Course By Student Id
	public ResponseEntity<ResponseStructure<List<Course>>> getCourseByStudentId(int student_id) {
	    Optional<Student> studentOpt = studentDao.getStudentById(student_id);
	    
	    if (studentOpt.isEmpty()) {
	        throw new IdNotFoundException(student_id);
	    }

	    List<Course> courses = studentDao.getCourseByStudent(student_id).orElse(Collections.emptyList());
	    ResponseStructure<List<Course>> structure = new ResponseStructure<>();
	    structure.setStatusCode(HttpStatus.OK.value());
	    structure.setMessage(courses.isEmpty() ? "No courses found for student whose Id : "+student_id : "Success");
	    structure.setData(courses);

	    return new ResponseEntity<ResponseStructure<List<Course>>>(structure,HttpStatus.OK);
	}
	
}
