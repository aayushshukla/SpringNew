package com.infosys.main;

import com.infosys.beans.Student;
import com.infosys.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        Student s1 = new Student();
//        s1.setStudentId(101);
//        s1.setStudentName("Goku");
//        System.out.println("Student Roll no is"+s1.getStudentId());
//        System.out.println("Student Name is"+s1.getStudentName());

//      creating ref of ApplicationContext : j2ee container

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


       // Student s =  context.getBean(Student.class); // spring will get bean of the type you have requested
        // it bean is not found it will raise NoSuchBeanDefinitionException
       // System.out.println("Student Roll no is"+s.getStudentId());
        // System.out.println("Student Name is"+s.getStudentName());
         // No UniqueBeanDefinationException

        Student s  = context.getBean("student103",Student.class);
        System.out.println("Student Roll no is"+s.getStudentId());
        System.out.println("Student Name is"+s.getStudentName());

        Student s2  = context.getBean("student104",Student.class);
        System.out.println("Student Roll no is"+s2.getStudentId());
        System.out.println("Student Name is"+s2.getStudentName());

        Student s3  = context.getBean("student105",Student.class);
        System.out.println("Student Roll no is"+s3.getStudentId());
        System.out.println("Student Name is"+s3.getStudentName());

//        Student s1  = context.getBean("student",Student.class);
//        System.out.println("Student Roll no is"+s1.getStudentId());
//        System.out.println("Student Name is"+s1.getStudentName());

    }
}
