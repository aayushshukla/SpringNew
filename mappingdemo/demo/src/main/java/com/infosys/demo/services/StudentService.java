package com.infosys.demo.services;

import com.infosys.demo.beans.Student;
import com.infosys.demo.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentInterface{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
