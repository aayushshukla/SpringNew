package com.infosys.config;

import com.infosys.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// when we work in spring we can perform task in two ways  1. xml   2. annotation
/*
  Indicates that a class declares one or more @Bean methods and may be processed by the
  Spring container to generate bean definitions and service requests for those beans at runtime

 */
@Configuration
public class AppConfig {
    // definaton how object will be created
    //indicates that a method produces a bean to be managed by the Spring container.
    @Bean // let spring know that it need to call this method when it intialiase its context and add the returned value to the
    // context
    Student student(){
         Student s1 = new Student();  // create student bean object
         s1.setStudentId(102);
         s1.setStudentName("Aayush");
         return s1;

    }
// custome name to bean : name , value , name
    @Bean(name = "student103")
    Student student1(){
        Student s1 = new Student();  // create student bean object
        s1.setStudentId(103);
        s1.setStudentName("Shravani");
        return s1;

    }

    @Bean(value = "student104")
    Student student2(){
        Student s1 = new Student();  // create student bean object
        s1.setStudentId(104);
        s1.setStudentName("Sanjay");
        return s1;

    }

    @Bean("student105")
    Student student3(){
        Student s1 = new Student();  // create student bean object
        s1.setStudentId(105);
        s1.setStudentName("Soham");
        return s1;

    }

}
