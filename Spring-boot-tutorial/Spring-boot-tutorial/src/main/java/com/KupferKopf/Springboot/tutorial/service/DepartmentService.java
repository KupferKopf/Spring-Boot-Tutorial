package com.KupferKopf.Springboot.tutorial.service;

import com.KupferKopf.Springboot.tutorial.entity.Department;
import com.KupferKopf.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department); // 2nd to be called for department entity, continuing to the impl

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public Department fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException;


}
