package com.courseenrrolmentsystem.Exception;

public class StudentIdAndCourseIdNotFoundException extends RuntimeException {

	public StudentIdAndCourseIdNotFoundException(int student_id,int course_id) {
		super("Student with Id : " + student_id + " ,Or Course with Id "+course_id+" Not Found");
	}
}
