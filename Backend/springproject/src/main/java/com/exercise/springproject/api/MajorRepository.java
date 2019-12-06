package com.exercise.springproject.api;

import com.exercise.springproject.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Integer> {

    @Query("select p from Major p where p.idMajor=?1")
    public Major findMajorById(int idMajor);

    @Query("select p from Major p where p.chineseName=?1")
    public Major findMajorByCname(String chineseName);

    @Query("select p from Major p where p.department=?1")
    public List<Major> findMajorByDepartment(int idDepartment);

    @Query("select p from Major p where p.englishName=?1")
    public Major findMajorByEname(String englishName);

}
