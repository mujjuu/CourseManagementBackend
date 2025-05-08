package com.courseenrrolmentsystem.Helper;

import com.courseenrrolmentsystem.Entity.Course;

public class CourseRequest {

	private Course course;
	private int instructor_id;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}
}

