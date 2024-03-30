package com.KupferKopf.Springboot.tutorial.service;

import com.KupferKopf.Springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department); // 2nd to be called for department entity, continuing to the impl

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);
}