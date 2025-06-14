package com.infosys.demo.beans;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int courseId;
    private String courseName;

    @ManyToMany(mappedBy = "coursesList")
    private List<Student> enrolledStudentList;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getEnrolledStudentList() {
        return enrolledStudentList;
    }

    public void setEnrolledStudentList(List<Student> enrolledStudentList) {
        this.enrolledStudentList = enrolledStudentList;
    }
}
