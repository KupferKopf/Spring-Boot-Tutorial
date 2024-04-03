package com.KupferKopf.Springboot.tutorial.repository;

import com.KupferKopf.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Robotics")
                        .departmentAddress("D-Building")
                        .departmentCode("R-06")
                        .build();

        Department department2 =
                Department.builder()
                        .departmentName("Mechanics")
                        .departmentAddress("A-Building")
                        .departmentCode("A-04")
                        .build();

        entityManager.persist(department);
        entityManager.persist(department2);
    }


    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(2L).get();
        assertEquals(department.getDepartmentName(), "Mechanics");
    }



}