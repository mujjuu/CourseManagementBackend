package com.courseenrrolmentsystem.Exception;

public class InstructorNotFoundException extends RuntimeException {
 
	 public InstructorNotFoundException(int id) {
	        super("Instructor with this Id : " + id + " , Not Found");
	    }
}
