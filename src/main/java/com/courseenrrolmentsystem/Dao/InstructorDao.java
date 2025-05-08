package com.courseenrrolmentsystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.courseenrrolmentsystem.Entity.Instructor;
import com.courseenrrolmentsystem.Entity.Student;
import com.courseenrrolmentsystem.Repository.InstructorRepository;

@Repository
public class InstructorDao {

	@Autowired
	InstructorRepository instructorRepository;
	
	//Adding Instructor 
	public Instructor addInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	//Fetching All Instructors Details
	public List<Instructor> getAllInstructors(){
		return instructorRepository.findAll();
	}
	
	//Fetching Single Instructor By Id
	public Optional<Instructor> getInstructorById(int id) {
		return instructorRepository.findById(id);
	}
	
	//Updating Single Instructor
	public Instructor updateInstructor(Instructor instructor) {
		return instructorRepository.save(instructor);
	}
	
	//Delete Instructor by passing id
	public void deleteInstructor(Instructor instructor) {
		instructorRepository.delete(instructor);
	}
	
	//Custom Query -- Fetching Student By Instructor Id
	public Optional<List<Student>> getStudentByInsstructorId(int instructor_id){
		return instructorRepository.getStudentByInstructorId(instructor_id);
	}
	
}
