package com.courseenrrolmentsystem.Exception;

public class EnrollmentIdNotFoundException extends RuntimeException {

	public EnrollmentIdNotFoundException(int id) {
		super("Enrollment for Id : "+id+" ,Not Found");
	}
}
