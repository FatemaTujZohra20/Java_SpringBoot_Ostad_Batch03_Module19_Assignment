package com.chronicle.uni_enroll.UniEnroll.model;

public class Student extends Person {
    private final String studentId;
    
    public Student (String name, String email, String studentId) {
        super(name, email);
        this.studentId = studentId;
    }
    
    @Override
    public String describeRole() {
        return "Enrolled Student [ID: " + studentId + "]";
    }
    
    public String getStudentId() {
        return studentId;
    }
}
