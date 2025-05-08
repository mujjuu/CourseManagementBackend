package com.courseenrrolmentsystem.Exception;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(int id) {
        super("Student with this Id : " + id + " , Not Found");
    }
}
