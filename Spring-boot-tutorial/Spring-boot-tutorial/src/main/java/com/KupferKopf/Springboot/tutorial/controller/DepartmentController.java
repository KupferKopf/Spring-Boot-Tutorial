package com.KupferKopf.Springboot.tutorial.controller;


import com.KupferKopf.Springboot.tutorial.entity.Department;
import com.KupferKopf.Springboot.tutorial.service.DepartmentService;
import com.KupferKopf.Springboot.tutorial.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments") // called 1st when wanting to save a department entity, calls the service layer to continue the action downwards
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DeparmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        LOGGER.info("Inside fetchDepartmentList of DeparmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside fetchDepartmentById of DeparmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DeparmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department has been successfully deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DeparmentController");
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DeparmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }



}
