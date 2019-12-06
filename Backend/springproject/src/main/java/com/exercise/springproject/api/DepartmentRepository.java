package com.exercise.springproject.api;

import com.exercise.springproject.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("select p from Department p where p.idDepartment=?1")
    public Department findDepartmentById(int idDepartment);

    @Query("select p from Department p where p.chineseName=?1")
    public Department findDepartmentByName(String chineseName);

    @Query("select p from Department p where p.code=?1")
    public Department findDepartmentByCode(String code);

}
