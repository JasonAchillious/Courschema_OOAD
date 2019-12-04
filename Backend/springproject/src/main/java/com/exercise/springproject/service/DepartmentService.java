package com.exercise.springproject.service;

import com.exercise.springproject.domain.Major;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    public Major findDepartmentById(int idDepartment);
}
