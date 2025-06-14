package com.infosys.demo.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(name = "sname")
    @NotBlank(message = "student name cant be empty")
    private  String studentName;
    @Column(name = "semail")
    @Email(message = "please enter  valid email ")
    private  String studentEmail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private  Department department;

    @ManyToMany(targetEntity = Courses.class,cascade = CascadeType.ALL)
    // Jointable  it is middle(intermediate ) table that links 2 entities in many to many relationship.
    // it contains fk pointing to primary keys of 2 related tables
    // maninly use with ManyToMany  Mapping  , sometime with unidirection @OneToMany mapping
    @JoinTable(name = "student_courses",  // name of the join table
    joinColumns = @JoinColumn(name = "student_id"), // fk referring to current entity(Student)
    inverseJoinColumns = @JoinColumn(name = "course_id")) // fk referring to other entity(Course)
    private  List<Courses> coursesList;


    public Student()
    {}

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student(String studentName, String studentEmail) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
}
