package com.courseenrrolmentsystem.Helper;

import com.courseenrrolmentsystem.Entity.Enrollment;

public class EnrollmentRequest {
	private Enrollment enrollment;
	private int student_id;
	private int course_id;
	
	public Enrollment getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}
