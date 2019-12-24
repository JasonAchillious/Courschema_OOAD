package com.exercise.springproject.service;

import com.exercise.springproject.api.DepartmentRepository;
import com.exercise.springproject.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department findDepartmentById(int idDepartment) {
        return departmentRepository.findDepartmentById(idDepartment);
    }

    @Override
    public Department findDepartmentByName(String chineseName){
        return departmentRepository.findDepartmentByName(chineseName);
    }

    @Override
    public Department findDepartmentByCode(String code){
        return departmentRepository.findDepartmentByCode(code);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
