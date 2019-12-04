package com.exercise.springproject.service;

import com.exercise.springproject.api.DepartmentRepository;
import com.exercise.springproject.domain.Major;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Major findDepartmentById(int idDepartment) {
        return departmentRepository.findDepartmentById(idDepartment);
    }
}
