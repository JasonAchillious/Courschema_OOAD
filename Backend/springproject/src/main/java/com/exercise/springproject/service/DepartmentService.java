package com.exercise.springproject.service;

import com.exercise.springproject.domain.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public Department findDepartmentById(int idDepartment);

    public Department findDepartmentByName(String chineseName);

    public Department findDepartmentByCode(String code);

    Department save(Department department);

    List<Department> findAll();
}
