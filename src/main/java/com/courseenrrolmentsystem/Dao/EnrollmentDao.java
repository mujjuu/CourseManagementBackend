package com.courseenrrolmentsystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.courseenrrolmentsystem.Entity.Enrollment;
import com.courseenrrolmentsystem.Repository.EnrollmentRepository;

@Repository
public class EnrollmentDao {

	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	
	//Adding Enrollment for the student
	public Enrollment addEnrollment(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}
	
	//Fetching All Enrollments
	public List<Enrollment> getAllEnrollments(){
		return enrollmentRepository.findAll();
	}
	
	//Fetching Enrollment By Its Id
	public Optional<Enrollment> getEnrollmentById(int id){
		return enrollmentRepository.findById(id);
	}
	
	//Update Enrollment Date
	public Enrollment updateEnrollmentDate(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}
	
	//Delete Enrollment
	public void deleteEnrollment(Enrollment enrollment) {
		enrollmentRepository.delete(enrollment);
	}
	
	//Custom Query -- Fetching Enrollments Using Student id 
	public Optional<List<Enrollment>> getEnrollmentByStudentId(int student_id){
		return enrollmentRepository.getEnrollmentByStudentId(student_id);
	}
	
	//Custom Query -- Fetching Enrollments Using Course Id
	public Optional<List<Enrollment>> getEnrollmentByCourseId(int course_id){
		return enrollmentRepository.getEnrollmentByCourseId(course_id);
	}
}
