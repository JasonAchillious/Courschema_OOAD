package com.exercise.springproject.service;

import com.exercise.springproject.domain.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    public Department findDepartmentById(int idDepartment);
}
