package com.courseenrrolmentsystem.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.courseenrrolmentsystem.Dao.EnrollmentDao;
import com.courseenrrolmentsystem.Entity.Course;
import com.courseenrrolmentsystem.Entity.Enrollment;
import com.courseenrrolmentsystem.Entity.Student;
import com.courseenrrolmentsystem.Exception.CourseNotFoundException;
import com.courseenrrolmentsystem.Exception.EnrollmentIdNotFoundException;
import com.courseenrrolmentsystem.Exception.IdNotFoundException;
import com.courseenrrolmentsystem.Exception.StudentIdAndCourseIdNotFoundException;
import com.courseenrrolmentsystem.Repository.CourseRepository;
import com.courseenrrolmentsystem.Repository.StudentRepository;
import com.courseenrrolmentsystem.responsestructure.ResponseStructure;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentDao enrollmentDao;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	//Adding Enrollment for the student
	public ResponseEntity<ResponseStructure<Enrollment>> addEnrollment(Enrollment enrollment,int student_id,int course_id){
		Optional<Student> student_opt = studentRepository.findById(student_id);
		Optional<Course> course_opt = courseRepository.findById(course_id);
		
		if(student_opt.isPresent() && course_opt.isPresent()) {
			enrollment.setStudent(student_opt.get());
			enrollment.setCourse(course_opt.get());
			enrollmentDao.addEnrollment(enrollment);
			ResponseStructure<Enrollment> structure = new ResponseStructure<Enrollment>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(enrollment);
			return new ResponseEntity<ResponseStructure<Enrollment>>(structure,HttpStatus.CREATED);
			
		}
		else {
			throw new StudentIdAndCourseIdNotFoundException(student_id, course_id);
		}
		
	}
	
	//Fetching All Enrollments
	public ResponseEntity<ResponseStructure<List<Enrollment>>> getAllEnrollments(){
		List<Enrollment> enrollments = enrollmentDao.getAllEnrollments();
		ResponseStructure<List<Enrollment>> structure = new ResponseStructure<List<Enrollment>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(enrollments);
		return new ResponseEntity<ResponseStructure<List<Enrollment>>>(structure,HttpStatus.OK);
	}
	
	//Fetching Enrollment By Its Id
	public ResponseEntity<ResponseStructure<Enrollment>> getEnrollmentById(int id){
		Optional<Enrollment> opt = enrollmentDao.getEnrollmentById(id);
		ResponseStructure<Enrollment> structure= new ResponseStructure<Enrollment>();
		
		if(opt.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Enrollment>>(structure,HttpStatus.OK);
		}
		else {
			throw new EnrollmentIdNotFoundException(id);
		}
	}
	
	//Update Enrollment Date
	public ResponseEntity<ResponseStructure<Enrollment>> updateEnrollmentDate(Enrollment enrollment,int student_id,int course_id){
		Optional<Student> student_opt = studentRepository.findById(student_id);
		Optional<Course> course_opt = courseRepository.findById(course_id);
		
		if(student_opt.isPresent() && course_opt.isPresent()) {
			enrollment.setStudent(student_opt.get());
			enrollment.setCourse(course_opt.get());
			enrollmentDao.updateEnrollmentDate(enrollment);
			ResponseStructure<Enrollment> structure = new ResponseStructure<Enrollment>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(enrollment);
			return new ResponseEntity<ResponseStructure<Enrollment>>(structure,HttpStatus.OK);
		}
		else {
			throw new StudentIdAndCourseIdNotFoundException(student_id, course_id);
		}	
	}
	
	//Delete Enrollment
	public ResponseEntity<ResponseStructure<Enrollment>> deleteEnrollment(int id){
		Optional<Enrollment> opt = enrollmentDao.getEnrollmentById(id);
		ResponseStructure<Enrollment> structure = new ResponseStructure<Enrollment>();
		if(opt.isPresent()) {
			enrollmentDao.deleteEnrollment(opt.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Record Deleted");
			return new ResponseEntity<ResponseStructure<Enrollment>>(structure,HttpStatus.OK);
		}
		else {
			throw new EnrollmentIdNotFoundException(id);
		}
	}
	
	//Custom Query -- Fetching Enrollments Using Student id 
	public ResponseEntity<ResponseStructure<List<Enrollment>>> getEnrollmentByStudentId(int student_id){
		Optional<Student> student_opt = studentRepository.findById(student_id);
		
		if(student_opt.isEmpty()) {
			throw new IdNotFoundException(student_id);
		}
		
		List<Enrollment> enrollments = enrollmentDao.getEnrollmentByStudentId(student_id).orElse(Collections.emptyList());
		ResponseStructure<List<Enrollment>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage(enrollments.isEmpty() ? "No Enrollments For Student With Id : "+student_id :"Success");
		structure.setData(enrollments);
		return new ResponseEntity<ResponseStructure<List<Enrollment>>>(structure,HttpStatus.OK);
	}
	
	//Custom Query -- Fetching Enrollments Using Course Id
	public ResponseEntity<ResponseStructure<List<Enrollment>>> getEnrollmentByCourseId(int course_id){
		Optional<Course> course_opt = courseRepository.findById(course_id);
		
		if(course_opt.isEmpty()) {
			throw new CourseNotFoundException(course_id);
		}
		
		List<Enrollment> enrollments = enrollmentDao.getEnrollmentByCourseId(course_id).orElse(Collections.emptyList());
		ResponseStructure<List<Enrollment>> structure = new ResponseStructure<List<Enrollment>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage(enrollments.isEmpty() ? "No Enrollments with Course Id : "+course_id :"Success");
		structure.setData(enrollments);
		return new ResponseEntity<ResponseStructure<List<Enrollment>>>(structure,HttpStatus.OK);
	}
}
