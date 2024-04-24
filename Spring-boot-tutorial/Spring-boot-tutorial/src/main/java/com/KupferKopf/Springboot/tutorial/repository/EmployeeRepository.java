package com.KupferKopf.Springboot.tutorial.repository;

import com.KupferKopf.Springboot.tutorial.entity.Department;
import com.KupferKopf.Springboot.tutorial.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByEmployeeFirstName(String employeeFirstName);

    public List<Employee> findByEmployeeLastName(String employeeLastName);

    public Optional<Employee> findByEmployeeFirstnameAndEmployeeLastName(String employeeFirstName, String employeeLastName);
}
