package com.courseenrrolmentsystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.courseenrrolmentsystem.Entity.Course;
import com.courseenrrolmentsystem.Entity.Student;
import com.courseenrrolmentsystem.Repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;
	
	//Adding ( Creating ) the Student
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	
	//Fetching All Students Details
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	
	//Fetching Single Student from student table using id
	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
	}
	
	//Updating Single Student from Student table 
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//Deleting Single Student from Student table
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}
	
	//Custom Query -- Fetching Course By Student Id
	public Optional<List<Course>> getCourseByStudent(int student_id){
		return studentRepository.getCourseByStudentId(student_id);
	}
	
}
