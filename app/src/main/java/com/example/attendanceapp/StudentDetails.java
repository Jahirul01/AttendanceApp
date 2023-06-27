package com.example.attendanceapp;

public class StudentDetails {
    private String studentName,studentClassName,studentSection,studentRoll,studentPhone,studentAddress;

    public StudentDetails() {
    }

    // use for attendance


    public StudentDetails(String studentName, String studentClassName, String studentRoll) {
        this.studentName = studentName;
        this.studentClassName = studentClassName;
        this.studentRoll = studentRoll;
    }

    public StudentDetails(String studentName, String studentClassName, String studentSection, String studentRoll, String studentPhone, String studentAddress) {
        this.studentName = studentName;
        this.studentClassName = studentClassName;
        this.studentSection = studentSection;
        this.studentRoll = studentRoll;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }

    public String getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(String studentSection) {
        this.studentSection = studentSection;
    }

    public String getStudentRoll() {
        return studentRoll;
    }

    public void setStudentRoll(String studentRoll) {
        this.studentRoll = studentRoll;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
}
