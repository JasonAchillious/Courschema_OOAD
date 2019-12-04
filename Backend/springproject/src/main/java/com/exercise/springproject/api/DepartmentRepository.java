package com.exercise.springproject.api;

import com.exercise.springproject.domain.Department;
import com.exercise.springproject.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("select p from Department p where p.idDepartment=?1")
    public Major findDepartmentById(int idDepartment);
}
