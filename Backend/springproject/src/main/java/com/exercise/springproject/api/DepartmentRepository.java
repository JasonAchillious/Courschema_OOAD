package com.exercise.springproject.api;

import com.exercise.springproject.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("select p from Department p where p.idDepartment=?1")
    public Department findDepartmentById(int idDepartment);
}
