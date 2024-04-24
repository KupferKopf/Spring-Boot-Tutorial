package com.KupferKopf.Springboot.tutorial.service;


import com.KupferKopf.Springboot.tutorial.entity.Department;
import com.KupferKopf.Springboot.tutorial.error.DepartmentNotFoundException;
import com.KupferKopf.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override // 3rd to be called to save the Entity actual logic of the service layer
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("There is no Department with that ID");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException{
        if(fetchDepartmentById(departmentId) != null){
            departmentRepository.deleteById(departmentId);
        }
        //doesn't need an else because if fetchDepartmentById doesn't find it an exception will be thrown
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException {
        Department departmentDB = departmentRepository.findById(departmentId).get();

        if(departmentDB == null){
            throw new DepartmentNotFoundException("There is no Department with that ID, so it can not be updated");
        }

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException{
        Department department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

        if(department != null){
            return department;
        }else{
            throw new DepartmentNotFoundException("There is no Department with that Name");
        }
    }


}
