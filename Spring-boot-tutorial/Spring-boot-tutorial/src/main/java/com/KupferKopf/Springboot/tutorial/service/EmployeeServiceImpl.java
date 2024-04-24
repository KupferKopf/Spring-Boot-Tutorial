package com.KupferKopf.Springboot.tutorial.service;

import com.KupferKopf.Springboot.tutorial.entity.Employee;
import com.KupferKopf.Springboot.tutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) { return employeeRepository.save(employee); }

    @Override
    public List<Employee> fetchEmployees() { return employeeRepository.findAll(); }

    @Override
    public Employee fetchEmployeeById(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(!employee.isPresent()){
            //throws
        }

        return employee.get();
    }

    @Override
    public List<Employee> fetchEmployeesByFirstName(String firstname) {
    List<Employee> employees = employeeRepository.findByEmployeeFirstName(firstname);
        if(employees == null && employees.isEmpty()){
            //throws
        }
        return employees;
    }

    @Override
    public List<Employee> fetchEmployeesByLastName(String lastname) {
        List<Employee> employees = employeeRepository.findByEmployeeLastName(lastname);
        if(employees == null && employees.isEmpty()){
            //throws
        }
        return employees;
    }

    @Override
    public Employee fetchEmployeeByFirstNameAndLastName(String firstname, String lastname) {
        Optional<Employee> employee = employeeRepository.findByEmployeeFirstnameAndEmployeeLastName(firstname, lastname);
        if(!employee.isPresent()){
            //throws
        }
        return employee.get();
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee employeeDB = employeeRepository.getById(employeeId);

        if(employeeDB == null){
            //throw
        }

        if(Objects.nonNull(employee.getEmployeeFirstName()) &&
           !"".equalsIgnoreCase(employeeDB.getEmployeeFirstName())){
            employeeDB.setEmployeeFirstName(employee.getEmployeeFirstName());
        }

        if(Objects.nonNull(employee.getEmployeeLastName()) &&
                !"".equalsIgnoreCase(employeeDB.getEmployeeLastName())){
            employeeDB.setEmployeeLastName(employee.getEmployeeLastName());
        }

        if(employee.getEmployeeSVNR() > 1000000000){
            employeeDB.setEmployeeSVNR(employee.getEmployeeSVNR());
        }

        if(Objects.nonNull(employee.getEmployeeAddress()) &&
                !"".equalsIgnoreCase(employeeDB.getEmployeeAddress())){
            employeeDB.setEmployeeAddress(employee.getEmployeeAddress());
        }

        if(Objects.nonNull(employee.getEmployeePLZ()) &&
                !"".equalsIgnoreCase(employeeDB.getEmployeePLZ())){
            employeeDB.setEmployeePLZ(employee.getEmployeePLZ());
        }


        return employeeRepository.save(employeeDB);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        if(fetchEmployeeById(employeeId) != null){
            employeeRepository.deleteById(employeeId);
        }
    }
}
