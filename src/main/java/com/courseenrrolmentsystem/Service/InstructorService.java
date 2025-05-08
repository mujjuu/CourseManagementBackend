package com.courseenrrolmentsystem.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.courseenrrolmentsystem.Dao.InstructorDao;
import com.courseenrrolmentsystem.Entity.Instructor;
import com.courseenrrolmentsystem.Entity.Student;
import com.courseenrrolmentsystem.Exception.InstructorNotFoundException;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@Service
public class InstructorService {

	@Autowired
	InstructorDao instructorDao;
	
	//Adding Instructor
	public ResponseEntity<ResponseStructure<Instructor>> addInstructor(Instructor instructor){
		instructorDao.addInstructor(instructor);
		ResponseStructure<Instructor>  structure = new ResponseStructure<Instructor>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(instructor);
		return new ResponseEntity<ResponseStructure<Instructor>>(structure,HttpStatus.CREATED);
	}
	
	//Fetching All Instructor Details
	public ResponseEntity<ResponseStructure<List<Instructor>>> getAllInstructors(){
		List<Instructor> instructors = instructorDao.getAllInstructors();
		ResponseStructure<List<Instructor>> structure = new ResponseStructure<List<Instructor>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(instructors);
		return new ResponseEntity<ResponseStructure<List<Instructor>>>(structure,HttpStatus.OK);
	}
	
	//Fetching Single Instructor By its Id
	public ResponseEntity<ResponseStructure<Instructor>> getInstructorById(int id){
		Optional<Instructor> opt = instructorDao.getInstructorById(id);
		
		ResponseStructure<Instructor> structure = new ResponseStructure<Instructor>();
		
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Instructor>>(structure,HttpStatus.OK);
		}
		else {
			throw new InstructorNotFoundException(id);
		}
	}
	
	//Updating Single Instructor
	public ResponseEntity<ResponseStructure<Instructor>> updateInstructor(Instructor instructor){
		instructorDao.updateInstructor(instructor);
		ResponseStructure<Instructor> structure = new ResponseStructure<Instructor>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(instructor);
		return new ResponseEntity<ResponseStructure<Instructor>>(structure,HttpStatus.OK);
		
	}
	
	//Delete Instructor by passing id 
	public ResponseEntity<ResponseStructure<Instructor>> deleteInstructor(int id){
		Optional<Instructor> opt= instructorDao.getInstructorById(id);
		ResponseStructure<Instructor> structure = new ResponseStructure<Instructor>();
		
		if(opt.isPresent()) {
			instructorDao.deleteInstructor(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Instructor Deleted");
			return new ResponseEntity<ResponseStructure<Instructor>>(structure,HttpStatus.OK);
		}
		else {
			throw new InstructorNotFoundException(id);
		}
	}
	
	//Custom Query -- Fetching Student By Instructor Id
	public ResponseEntity<ResponseStructure<List<Student>>> getStudentByInstructorId(int instructor_id){
		Optional<Instructor> instructorOpt = instructorDao.getInstructorById(instructor_id);
		if(instructorOpt.isEmpty()) {
			throw new InstructorNotFoundException(instructor_id);
		}
		List<Student> students = instructorDao.getStudentByInsstructorId(instructor_id).orElse(Collections.emptyList());
		
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage(students.isEmpty() ? "No Students found for Instructor with Id : "+instructor_id :"success");
		structure.setData(students);
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.OK);
	}
}
