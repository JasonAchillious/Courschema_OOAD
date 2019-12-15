package com.exercise.springproject.api;

import com.exercise.springproject.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query("select p from Admin p where p.idAdmin=?1")
    public Admin findAdminByIdAdmin(int id_admin);
}
