package com.KupferKopf.Springboot.tutorial.controller;

import com.KupferKopf.Springboot.tutorial.entity.Employee;
import com.KupferKopf.Springboot.tutorial.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    /* CRUD
        create/save/Post
        read/fetch/get
        update/put
        delete

        "/departments/{id}"
        @PathVariable("id) -> to get the value out of the path
        "/departments/name/{name}"
        @RequestBody -> asking/requesting the
     */


    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        LOGGER.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchAllEmployees(){
        LOGGER.info("Inside fetchAllEmployees of EmployeeController");
        return employeeService.fetchEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@Valid @PathVariable("id") Long employeeId){
        LOGGER.info("Inside fetchEmployeeById of EmployeeController");
        return employeeService.fetchEmployeeById(employeeId);
    }

    @GetMapping("/employees/firstname/{firstname}")
    public List<Employee> fetchEmployeesByFirstName(@PathVariable("firstname") String employeeFirstname){
        LOGGER.info("Inside fetchEmployeesByFirstName of EmployeeController");
        return employeeService.fetchEmployeesByFirstName(employeeFirstname);
    }

    @GetMapping("/employees/lastname/{lastname}")
    public List<Employee> fetchEmployeesByLastName(@PathVariable("lastname") String employeeLastname){
        LOGGER.info("Inside fetchEmployeesByLastName of EmployeeController");
        return employeeService.fetchEmployeesByLastName(employeeLastname);
    }

    @GetMapping("/employees/name/{firstname} {lastname}")
    public Employee fetchEmployeeByFirstNameAndLastName(@PathVariable("firstname") String employeeFirstname, @PathVariable("lastname") String employeeLastname){
        LOGGER.info("Insider fetchEmployeeByFirstNameAndLastName of EmployeeController");
        return employeeService.fetchEmployeeByFirstNameAndLastName(employeeFirstname,employeeLastname);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeId, @RequestBody Employee employee){
        LOGGER.info("Inside updateEmployee of EmployeeController");
        return employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long employeeId){
        LOGGER.info("Inside deleteEmployee of EmployeeController");
        employeeService.deleteEmployee(employeeId);
        return "Employee has been deleted successfully";
    }



}
