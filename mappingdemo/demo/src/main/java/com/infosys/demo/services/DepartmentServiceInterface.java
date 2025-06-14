package com.infosys.demo.services;

import com.infosys.demo.beans.Department;

import java.util.List;

public interface DepartmentServiceInterface {

    public void saveDepartment(Department department);
    public List<Department> getAllDepartment();
    public Department findDepartment(int deptId);

}
