package com.exercise.springproject.api;


import com.exercise.springproject.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MajorRepository extends JpaRepository<Major, Integer> {
    @Query("select p from Major p where p.idMajor=?1")
    public Major findMajorById(int idMajor);
}
