package com.example.attendanceapp;

public class TeacherDetails {
    private String teacherName;
    private String teacherIndex;
    private String teacherPhone;
    private String teacherEmail;
    private String teacherPass;

    public   TeacherDetails() {

    }

    public TeacherDetails(String teacherName, String teacherIndex, String teacherPhone, String teacherEmail, String teacherPass) {
        this.teacherName = teacherName;
        this.teacherIndex = teacherIndex;
        this.teacherPhone = teacherPhone;
        this.teacherEmail = teacherEmail;
        this.teacherPass = teacherPass;
    }

    public TeacherDetails(String teacherPass) {
        this.teacherPass = teacherPass;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherIndex() {
        return teacherIndex;
    }

    public void setTeacherIndex(String teacherIndex) {
        this.teacherIndex = teacherIndex;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPass() {
        return teacherPass;
    }

    public void setTeacherPass(String teacherPass) {
        this.teacherPass = teacherPass;
    }
}
