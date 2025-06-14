package com.infosys.demo.services;

import com.infosys.demo.beans.Department;
import com.infosys.demo.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements  DepartmentServiceInterface {

    @Autowired
    DepartmentRepo departmentRepo;


    @Override
    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department findDepartment(int deptId) {
        return departmentRepo.findById(deptId).get();
    }


}
