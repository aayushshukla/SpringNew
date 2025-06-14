package com.infosys.demo;

import com.infosys.demo.beans.Courses;
import com.infosys.demo.beans.Department;
import com.infosys.demo.beans.Student;
import com.infosys.demo.services.DepartmentService;
import com.infosys.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MappingdemoApplication implements CommandLineRunner {

	@Autowired
	DepartmentService departmentService;
	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(MappingdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new department");
		System.out.println("Enter 2 to get all deparments");
		System.out.println("Enter 3 to add student with courses");
		int option = scanner.nextInt();
		switch (option)
		{
			case 1:
				System.out.println("Enter department name");
				String dname =scanner.next();
				Department department = new Department(dname);
				List<Student> slist = new ArrayList<>();
				System.out.println("Enter no of students to add");
				int n = scanner.nextInt();
				for(int i=0;i<n;i++)
				{
					System.out.println("enter student name");
                    String sname =scanner.next();
					System.out.println("enter student email");
					String smail =scanner.next();
					Student s  = new Student(sname,smail);
					s.setDepartment(department);
					slist.add(s);
				}

				department.setStudentList(slist);
				departmentService.saveDepartment(department);
				System.out.println("object is saved");
				break;
			case 3:
				System.out.println("Enter student name");
				String sname =scanner.next();
				System.out.println("enter student email");
				String smail =scanner.next();
				System.out.println("enter dept id");
				int deptId =scanner.nextInt();

				Department department1 =departmentService.findDepartment(deptId);
				 List<Courses> coursesList = new ArrayList<>();
				System.out.println("Enter no of courses to add");
				int ncourses = scanner.nextInt();
				for(int i=0;i<ncourses;i++)
				{
					System.out.println("enter course name");
					String courseName =scanner.next();
					Courses courses = new Courses();
					courses.setCourseName(courseName);
					coursesList.add(courses);
				}
				Student student = new Student(sname,smail);
				student.setDepartment(department1);
				student.setCoursesList(coursesList);
				studentService.addStudent(student);
				System.out.println("data is saved");
				break;

			default:
				System.out.println("select valid option");

		}
	}
}
