package com.KupferKopf.Springboot.tutorial.service;

import com.KupferKopf.Springboot.tutorial.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public List<Employee> fetchEmployees();

    public Employee fetchEmployeeById(Long employeeId);

    public List<Employee> fetchEmployeesByFirstName(String firstname);

    public List<Employee> fetchEmployeesByLastName(String lastname);

    public Employee fetchEmployeeByFirstNameAndLastName(String firstname, String lastname);

    public Employee updateEmployee(Long employeeId, Employee employee);

    public void deleteEmployee(Long employeeId);



}
