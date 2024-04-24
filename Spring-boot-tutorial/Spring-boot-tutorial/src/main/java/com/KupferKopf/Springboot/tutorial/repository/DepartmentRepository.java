package com.KupferKopf.Springboot.tutorial.repository;


import com.KupferKopf.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    //@Query(value = "", nativQuery = true)
    //Methodnames -> JPQLs -> SQL queryis
    //https://docs.spring.io/spring-data/jpa/reference/#jpa.query-methods
    public Department findByDepartmentNameIgnoreCase(String departmentName);

}
