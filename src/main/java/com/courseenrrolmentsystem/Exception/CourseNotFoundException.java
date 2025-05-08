package com.courseenrrolmentsystem.Exception;

public class CourseNotFoundException extends RuntimeException {
 
	
	public CourseNotFoundException(int id) {
        super("Course with Id : " + id + " , Not Found");
    }
}
